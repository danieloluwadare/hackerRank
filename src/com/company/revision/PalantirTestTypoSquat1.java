package com.company.revision;

import java.util.*;

public class PalantirTestTypoSquat1 {

    public static void main(String[] args) {
        System.out.println(findTypoSquat1(
                Arrays.asList("palantir.com", "bright.com.ng", "daniel.co.za"),
                Arrays.asList("palantir.co.uk", "palantir.com", "bright.com", "daniel.com", "bright.co.uk", "bright.ng",
                        "danny.com")));

    }

    @SuppressWarnings("Duplicates")
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

    @SuppressWarnings("Duplicates")
    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains) {

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

        Set<String> typoSquat = new HashSet<>();
        for (String domainName : mapOfNewDomainToSuffix.keySet()){
            if(mapOfCompanyDomainToSuffix.containsKey(domainName)){
                mapOfNewDomainToSuffix.get(domainName).forEach(suffix ->{
                    if(!mapOfCompanyDomainToSuffix.get(domainName).equalsIgnoreCase(suffix))
                        typoSquat.add(domainName.concat(".").concat(suffix));

                });
            }
        }

        return new ArrayList<>(typoSquat);
    }
}
