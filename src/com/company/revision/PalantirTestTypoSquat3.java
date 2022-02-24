package com.company.revision;

import java.util.*;

public class PalantirTestTypoSquat3 {

    public static void main(String[] args) {

        System.out.println(findTypoSquat3(
                Arrays.asList("palantir.com", "palantiir.com", "bright.com.ng", "daniel.co.za"),
                Arrays.asList("palantir.co.uk", "paiantlr.com", "paiant|r.com", "paiantir.com", "paianti|r.com","brlght.com.ng",
                        "palantii.rcom", "palant|i.rcom", "dani3l.co.za", "bright.co.uk", "bright.ng", "danny.com",
                        "paalntiir.com"),
                Arrays.asList("il|", "3e", "a9")
        ));

    }

    @SuppressWarnings("Duplicates")
    public static List<String> findTypoSquat3(List<String> realDomain,
                                              List<String> givenDomain,
                                              List<String> swaps){
        // swap =>[il|, 3e, a9]
        // realDomain = [palantiir.com,palantir.com, bright.com.ng, daniel.co.za]
        // givenDomain = [palantir.co.uk, plaant|r.com, palantii.rcom, paiantlr.com, paiant|ir.com, paiantir.com, brlght.com.ng, daniel.com, bright.co.uk, bright.ng, danny.com]
        // result2 = [paiantlr.com, paiantir.com, paiant|ir.com, plaant|r.com ; brlght.com.ng]

//        palantir => palantlr
//        paiantlr => palantlr

//        paiant|ir.com =>

//        il|!

//        Given realdomain and givenDomain and a set of swap such that each domain can be replaced with the swap and and the suffix
//        is still constant and the
//        2 rule)given domain may contain at list one edit/swap
//        e.g palantiir.com=> palantii.rcom this is one swap away find typosquat
//        and afetr the ... find typosquat

        Set<String> realDomainSet = new HashSet<>(realDomain);
        Set<String> givenDomainSet = new HashSet<>(givenDomain);

        givenDomainSet.removeIf(realDomainSet::contains);
        givenDomain = new ArrayList<>(givenDomainSet);

        System.out.println("Given Domain");
        System.out.println(givenDomainSet);

        Map<String, String> mapRealDomainToSuffix = new HashMap<>();
//        google => com
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

        for(String rd : mapRealDomainToSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfRealDomain = rd.replaceAll(regexTobeReplaced,fixedChar);
                possibleSwapToRealDomain.put(swapOfRealDomain,rd);
            }
        }

        System.out.println("Map of possibleSwapToRealDomain");
        System.out.println(possibleSwapToRealDomain);


        Set<String> typoSquats = new HashSet<>();

        for(String gd : mapGivenDomainSuffix.keySet()){
            for(String swap : swaps){
                String fixedChar =  String.valueOf(swap.charAt(0));
                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
                String swapOfGivenDomain = gd.replaceAll(regexTobeReplaced,fixedChar);
                if(possibleSwapToRealDomain.containsKey(swapOfGivenDomain)){
                    String realDomainNotSwapped = possibleSwapToRealDomain.get(swapOfGivenDomain);
                    String realDomainSuffix = mapRealDomainToSuffix.get(realDomainNotSwapped);
                    mapGivenDomainSuffix.get(gd).forEach(gdsuffix->{
                        if(gdsuffix.equals(realDomainSuffix)){
                            String typoSquat = gd.concat(".").concat(gdsuffix);
                            typoSquats.add(typoSquat);
                            givenDomainSet.remove(typoSquat);
                        }
                    });
                }
            }
        }


        System.out.println("Given Domain List After Deleting");
        System.out.println(givenDomainSet);

        Map<Character,Character> swapMap = new HashMap<>();
        for(String swap : swaps){
            char firstChar = swap.charAt(0);
            String remainChar = swap.substring(1);
            for(int i =0; i < remainChar.length(); i++){
                swapMap.put(remainChar.charAt(i),firstChar);
            }
        }
        System.out.println("Map of swap map");
        System.out.println(swapMap);


        for(String gd : givenDomainSet){
            for(String rd : realDomainSet){
                if(rd.length()==gd.length()){
//                    System.out.println(rd + "==>" +gd);
                    boolean foundDuplicates = false;
                    for(int i =gd.length()-1; i >= 0; i--){
                        if(gd.charAt(i) != rd.charAt(i) && i != 0){
                            char possibleSwap = swapMap.getOrDefault(gd.charAt(i), ' ');
                            char oneEditAwayCharRealD = rd.charAt(i-1);
                            if(possibleSwap != rd.charAt(i) && oneEditAwayCharRealD != gd.charAt(i)){
                                if(foundDuplicates)
                                    break;
                                foundDuplicates=true;
                            }
                        }
                        if(i==0 && gd.charAt(i) == rd.charAt(i)){
                            typoSquats.add(gd);
                        }
                    }
                }
            }
        }


        return new ArrayList<>(typoSquats);
//        [paiantir.com, paiantlr.com, dani3l.co.za, brlght.com.ng,
//        paianti|r.com, palant|i.rcom, palantii.rcom, paalntiir.com, paiant|r.com]

//        [paiantir.com, paiantlr.com, dani3l.co.za, brlght.com.ng,
//        paianti|r.com, palant|i.rcom, palantii.rcom, paalntiir.com, paiant|r.com]


    }
}
