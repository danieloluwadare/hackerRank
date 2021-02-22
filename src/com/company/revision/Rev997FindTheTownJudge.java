package com.company.revision;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class Rev997FindTheTownJudge {

    public static void main(String[] args) {

        int [][] trust1= {
                {1,3},{1,4},{2,3},{2,4},{4,3}
        };
        int [][] trust2= {
                {1,2},{2,3}
        };
        int [][] trust3= {
                {1,3},{2,3},{3,1}
        };
        int [][] trust4= {
                {1,3},{2,3}
        };
        int [][] trust5= {
                {1,2}
        };
        System.out.println(findJudge(4, trust1));
        System.out.println(findJudge(4, trust2));
        System.out.println(findJudge(4, trust3));
        System.out.println(findJudge(4, trust4));
        System.out.println(findJudge(4, trust5));
        System.out.println(findJudge(2, trust5));
    }

    @SuppressWarnings("Duplicates")
    public static int findJudge(int N, int[][] trusts) {
        if (N == 1)
            return N;

        int [] trusted = new int[N+1];
        for(int [] trust : trusts){
            trusted[trust[0]]--;
            trusted[trust[1]]++;
        }

        for (int i = 0; i <trusted.length; i++ ){
            if(trusted[i] ==N-1)
                return  i;
        }

        return -1;
    }
}
