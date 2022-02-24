package com.company.revision;

import java.util.*;

public class PalantirTestTypoSquat2 {

    public static void main(String[] args) {

        System.out.println(findTypoSquat2(
                Arrays.asList("palantir.com", "palantiir.com", "bright.com.ng", "daniel.co.za"),
                Arrays.asList("palantir.co.uk", "paiantlr.com", "paiant|r.com", "paiantir.com", "paianti|r.com",
                        "brlght.com.ng", "dani3l.co.za", "bright.co.uk", "bright.ng", "danny.com"),
                Arrays.asList("il|", "3e", "a9")
        ));

    }

    @SuppressWarnings("Duplicates")
    public static List<String> findTypoSquat2(List<String> realDomain,
                                              List<String> givenDomain,
                                              List<String> swaps){
        // swap=>[il|, 3e, a9]
        // realDomain = [palantiir.com, palantir.com, bright.com.ng, daniel.co.za]
        // givenDomain = [palantir.co.uk, paiantlr.com, paiant|ir.com, paiantir.com, brlght.com.ng, dani3l.com.ng,
        // bright.co.uk, bright.ng, danny.com]
        // result2 = [paiantlr.com, paiantir.com, paiant|ir.com, brlght.com.ng]

//        Given realdomain and givenDomain and a set of swap such that each domain can be replaced with the swap and
//        and the suffix is still constant... find typoSquat
//        palantir => palantlr
//        paiantlr => palantlr
//        paiant|ir.com =>
//        il|!

//        remove from the givenDomain those domain that are exact match in the realDomain
//        generate a map of givenDomain to List of suffix
//        generate a map of realDomain to suffix
//        generate a  map of realDomain To Their possible domain after swapping
//        generate a map of givenDomain to their possible swap output after swapping

        Set<String> realDomainSet = new HashSet<>(realDomain);
        Set<String> givenDomainSet = new HashSet<>(givenDomain);

        givenDomainSet.removeIf(realDomainSet::contains);
        givenDomain = new ArrayList<>(givenDomainSet);

        Map<String, String> mapRealDomainToSuffix = new HashMap<>();
        Map<String, Set<String>> mapGivenDomainSuffix = new HashMap<>();


        for (String rd : realDomain){
            String [] arr = rd.split("\\.",2);
            mapRealDomainToSuffix.put(arr[0],arr[1]);
        }

        for(String gd : givenDomain){
            String [] arr = gd.split("\\.",2);
            if(!mapGivenDomainSuffix.containsKey(arr[0]))
                mapGivenDomainSuffix.put(arr[0], new HashSet<>());
            mapGivenDomainSuffix.get(arr[0]).add(arr[1]);
        }

        System.out.println("Map of Given Domain Suffix");
        System.out.println(mapGivenDomainSuffix);
        System.out.println("Map of Real Domain Suffix");
        System.out.println(mapRealDomainToSuffix);


        Map<String, String> possibleSwapToRealDomain = new HashMap<>();
        Set<String> typoSquats = new HashSet<>();


        for(String rd : mapRealDomainToSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfRealDomain = rd.replaceAll(regexTobeReplaced,fixedChar);
                possibleSwapToRealDomain.put(swapOfRealDomain,rd);
            }
        }

        for(String gd : mapGivenDomainSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfGivenDomain = gd.replaceAll(regexTobeReplaced,fixedChar);
                if(possibleSwapToRealDomain.containsKey(swapOfGivenDomain)){
                    String realDomainUnSwapped = possibleSwapToRealDomain.get(swapOfGivenDomain);
                    String suffix = mapRealDomainToSuffix.get(realDomainUnSwapped);
                    mapGivenDomainSuffix.get(gd).forEach(gdSuffix->{
                        if(gdSuffix.equals(suffix)){
                            String typosquat = gd.concat(".").concat(gdSuffix);
                            typoSquats.add(typosquat);
                        }
                    });
                }
            }
        }



        System.out.println("Map of possibleSwapToRealDomain");
        System.out.println(possibleSwapToRealDomain);


        return new ArrayList<>(typoSquats);
    }

    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains) {
        System.out.println("cds");
        System.out.println(companyDomains);

        System.out.println("nds");
        System.out.println(newDomains);

        List<String> swaps = Arrays.asList("1il!|","s5$", "o0", "a@","e3");

        Set<String> companyDomainsSet = new HashSet<>(companyDomains);
        Set<String> newDomainsSet = new HashSet<>(newDomains);

        newDomainsSet.removeIf(companyDomainsSet::contains);

        Map<String, String> mapOfCompanyDomainToSuffix = new HashMap<>();
        Map<String, Set<String>> mapOfNewDomainToSuffix = new HashMap<>();

        for (String cds : companyDomainsSet){
            String [] arr = cds.split("\\.",2);
            mapOfCompanyDomainToSuffix.put(arr[0],arr[1]);
        }

        for(String nds : newDomainsSet){
            String [] arr = nds.split("\\.",2);
            if(!mapOfNewDomainToSuffix.containsKey(arr[0]))
                mapOfNewDomainToSuffix.put(arr[0], new HashSet<>());

            mapOfNewDomainToSuffix.get(arr[0]).add(arr[1]);
        }

        Set<String> typoSquats = new HashSet<>();
        for (String domainName : mapOfNewDomainToSuffix.keySet()){
            if(mapOfCompanyDomainToSuffix.containsKey(domainName)){
                mapOfNewDomainToSuffix.get(domainName).forEach(suffix ->{
                    if(!mapOfCompanyDomainToSuffix.get(domainName).equalsIgnoreCase(suffix))
                        typoSquats.add(domainName.concat(".").concat(suffix));

                });
            }
        }

        Map<String, String> possibleSwapToRealDomain = new HashMap<>();
        Map<String, Set<String>> possibleSwapToGivenDomain = new HashMap<>();

        for(String rd : mapOfCompanyDomainToSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfRealDomain = rd.replaceAll(regexTobeReplaced,fixedChar);
                possibleSwapToRealDomain.put(swapOfRealDomain,rd);
            }
        }

        System.out.println("Map of possibleSwapToRealDomain");
        System.out.println(possibleSwapToRealDomain);

        for(String gd : mapOfNewDomainToSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfGivenDomain = gd.replaceAll(regexTobeReplaced,fixedChar);

                if(!possibleSwapToGivenDomain.containsKey(swapOfGivenDomain))
                    possibleSwapToGivenDomain.put(swapOfGivenDomain,new HashSet<>());
                possibleSwapToGivenDomain.get(swapOfGivenDomain).add(gd);

                if(possibleSwapToRealDomain.containsKey(swapOfGivenDomain)){
                    String realDomainUnSwapped = possibleSwapToRealDomain.get(swapOfGivenDomain);
                    String suffix = mapOfCompanyDomainToSuffix.get(realDomainUnSwapped);
                    mapOfNewDomainToSuffix.get(gd).forEach(gdSuffix->{
                        String typosquat = gd.concat(".").concat(gdSuffix);
                        typoSquats.add(typosquat);
                    });
                }
            }
        }

        System.out.println("Map of possibleSwapToGivenDomain");
        System.out.println(possibleSwapToGivenDomain);

        return new ArrayList<>(typoSquats);


    }
}
