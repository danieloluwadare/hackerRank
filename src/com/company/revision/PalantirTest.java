package com.company.revision;

import java.util.*;

public class PalantirTest {

    public static void main(String[] args) {

//        String strMain = "Alpha.Beta.Delta.Gamma.Sigma";
//        String[] arrSplit_2 = strMain.split("\\.", 2);

//        System.out.println("pallantir".replace("l","i"));
////        String regexToBeReplaced = "[".concat("|it").concat("]");
//        String regexToBeReplaced2 = new StringBuilder("[").append("|it").append("]").toString();
//
//        System.out.println("paiant|iriivt.com".replaceAll(regexToBeReplaced2,"z"));
//        System.out.println("brlght.com".replaceAll("[l|]","i"));
//        System.out.println("paiant|iriivt.com".substring(1));

//        Map<Character, Character>m = new HashMap<>();
//        m.put('w','w');
//        char x = m.getOrDefault('c',' ');
//        System.out.println(m.get('x'));

//        System.out.println(findTypoSquat1(
//                Arrays.asList("palantir.com", "bright.com.ng", "daniel.co.za"),
//                Arrays.asList("palantir.co.uk", "palantir.com", "bright.com", "daniel.com", "bright.co.uk", "bright.ng",
//                        "danny.com")));

//
//                System.out.println(findTypoSquat2(
//                Arrays.asList("palantir.com", "palantiir.com", "bright.com.ng", "daniel.co.za"),
//                Arrays.asList("palantir.co.uk", "paiantlr.com", "paiant|r.com", "paiantir.com", "paianti|r.com",
//                        "brlght.com.ng", "dani3l.co.za", "bright.co.uk", "bright.ng", "danny.com"),
//                        Arrays.asList("il|", "3e", "a9")
//                        ));

//        System.out.println(findTypoSquat3(
//                Arrays.asList("palantir.com", "palantiir.com", "bright.com.ng", "daniel.co.za"),
//                Arrays.asList("palantir.co.uk", "paiantlr.com", "paiant|r.com", "paiantir.com", "paianti|r.com","brlght.com.ng",
//                        "palantii.rcom", "palant|i.rcom", "dani3l.co.za", "bright.co.uk", "bright.ng", "danny.com",
//                        "paalntiir.com"),
//                Arrays.asList("il|", "3e", "a9")
//        ));
//        palantii.rcom
//        palantiir.com

//        pialanti.rcom
//        palantiir.com
    }

    public static List<String> findTypoSquat1(List<String> realDomain, List<String> givenDomain){
        // realDomain = [palantir.com, bright.com.ng, daniel.co.za]
        // givenDomain = [palantir.co.uk, palantir.com, bright.com, daniel.com, bright.co.uk, bright.ng, danny.com]
        // result = [palantir.co.uk,  bright.com, daniel.com, bright.co.uk, bright.ng]
        Set<String> realDomainSet = new HashSet<>(realDomain);
        Set<String> givenDomainSet = new HashSet<>(givenDomain);

        givenDomainSet.removeIf(realDomainSet::contains);
        givenDomain = new ArrayList<>(givenDomainSet);

        Map<String, String> mapRealDomain = new HashMap<>();
        Map<String, Set<String>> mapGivenDomain = new HashMap<>();


        for (String rd : realDomain){
            String [] arr = rd.split("\\.",2);
            mapRealDomain.put(arr[0],arr[1]);
        }

        for(String gd : givenDomain){
            String [] arr = gd.split("\\.",2);
            if(!mapGivenDomain.containsKey(arr[0]))
                mapGivenDomain.put(arr[0], new HashSet<>());

            mapGivenDomain.get(arr[0]).add(arr[1]);
        }

        Set<String> typoSquat = new HashSet<>();
        for (String domainName : mapGivenDomain.keySet()){
            if(mapRealDomain.containsKey(domainName)){
                mapGivenDomain.get(domainName).forEach(suffix ->{
                    if(!mapRealDomain.get(domainName).equalsIgnoreCase(suffix))
                        typoSquat.add(domainName.concat(".").concat(suffix));

                });
            }
        }

        return new ArrayList<>(typoSquat);
    }

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


        Map<String, Set<String>> possibleSwapToGivenDomain = new HashMap<>();
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
//               if(possibleSwapToRealDomain.containsKey(swapOfGivenDomain)){
//                   String realDomainUnSwapped = possibleSwapToRealDomain.get(swapOfGivenDomain);
//                   String suffix = mapRealDomainToSuffix.get(realDomainUnSwapped);
//                   mapGivenDomainSuffix.get(gd).forEach(gdSuffix->{
//                       if(gdSuffix.equals(suffix)){
//                           String typosquat = gd.concat(".").concat(gdSuffix);
//                           typoSquats.add(typosquat);
//                       }
//                   });
//               }
                if(possibleSwapToGivenDomain.containsKey(swapOfGivenDomain))
                    possibleSwapToGivenDomain.put(swapOfGivenDomain,new HashSet<>());
                possibleSwapToGivenDomain.get(swapOfGivenDomain).add(gd);
            }
        }



        System.out.println("Map of possibleSwapToRealDomain");
        System.out.println(possibleSwapToRealDomain);


        Set<String> typoSquat = new HashSet<>();
        for(String gd : possibleSwapToGivenDomain.keySet()){
            if(possibleSwapToRealDomain.containsKey(gd)){
                Set<String> unSwappedGds = possibleSwapToGivenDomain.get(gd);
                String unSwappedRd = possibleSwapToRealDomain.get(gd);
                String suffixOfUnSwappedRd = mapRealDomainToSuffix.get(unSwappedRd);
                for(String unSwappedGd : unSwappedGds){
                    mapGivenDomainSuffix.get(unSwappedGd).forEach(suffix ->{
                        if(suffix.equals(suffixOfUnSwappedRd)){
                            typoSquat.add(unSwappedGd.concat(".").concat(suffix));
                        }
                    });
                }

            }
        }

        return new ArrayList<>(typoSquats);
    }

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


        Map<String, Set<String>> possibleSwapToGivenDomain = new HashMap<>();
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

//        for(String gd : mapGivenDomainSuffix.keySet()){
//            for(String swap : swaps){
//                String fixedChar =  String.valueOf(swap.charAt(0));
//                String regexTobeReplaced = new StringBuilder("[").append(swap.substring(1)).append("]").toString();
//                String swapGivenDomain = gd.replaceAll(regexTobeReplaced,fixedChar);
//                if(!possibleSwapToGivenDomain.containsKey(swapGivenDomain))
//                    possibleSwapToGivenDomain.put(swapGivenDomain, new HashSet<>());
//                possibleSwapToGivenDomain.get(swapGivenDomain).add(gd);
//            }
//        }

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

//        System.out.println("Map of possibleSwapToGivenDomain");
//        System.out.println(possibleSwapToGivenDomain);





//        for(String gd : possibleSwapToGivenDomain.keySet()){
//            if(possibleSwapToRealDomain.containsKey(gd)){
//                Set<String> unSwappedGds = possibleSwapToGivenDomain.get(gd);
//                String unSwappedRd = possibleSwapToRealDomain.get(gd);
//                String suffixOfUnSwappedRd = mapRealDomainToSuffix.get(unSwappedRd);
//                for(String unSwappedGd : unSwappedGds){
//                    mapGivenDomainSuffix.get(unSwappedGd).forEach(suffix ->{
//                        if(suffix.equals(suffixOfUnSwappedRd)){
//                            String typoSquat = unSwappedGd.concat(".").concat(suffix);
//                            typoSquats.add(typoSquat);
//                            givenDomainSet.remove(typoSquat);
//                        }
//                    });
//                }
//
//            }
//        }

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

//        System.out.println("Map of real Domain set map");
//        System.out.println(realDomainSet);

//        balantiir.com==>palantii.rcom
//               b           ' '
//              r               r

        for(String gd : givenDomainSet){
            for(String rd : realDomainSet){
                if(rd.length()==gd.length()){
//                    System.out.println(rd + "==>" +gd);
                    boolean foundDuplicates = false;
                    for(int i =gd.length()-1; i >= 0; i--){
                        if(gd.charAt(i) != rd.charAt(i) && i != 0){
                            char exception = swapMap.getOrDefault(gd.charAt(i), ' ');
                            char oneEditAwayCharRealD = rd.charAt(i-1);
                            if(exception != rd.charAt(i) && oneEditAwayCharRealD != gd.charAt(i)){
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
