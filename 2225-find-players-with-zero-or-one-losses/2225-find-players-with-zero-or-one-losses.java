import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // count win, and lose
        int MAX_SIZE = 100_001;
        int[] numberOfLose = new int[MAX_SIZE];
        Set<Integer> memberGroupIsNotDuplicate = new HashSet<>(); // 나온 플레이어들을 저장하고, Collections.sort 하고 쭉 가줄 것임

        for (int i = 0; i < matches.length; i++) {
            int winPlayer = matches[i][0];   
            int lostPlayer = matches[i][1];
            
            numberOfLose[lostPlayer]++;
            memberGroupIsNotDuplicate.add(winPlayer);
            memberGroupIsNotDuplicate.add(lostPlayer);
        }

        List<Integer> memberGroup = new ArrayList<>(memberGroupIsNotDuplicate);
        List<Integer> notLostAnyMatchPlayer = new ArrayList<>();
        List<Integer> oneLostPlayer = new ArrayList<>();
        Collections.sort(memberGroup);

        for (Integer member: memberGroup) {
            if (numberOfLose[member] == 0) {
                notLostAnyMatchPlayer.add(member);      
            }

            if (numberOfLose[member] == 1) {
                oneLostPlayer.add(member);
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(notLostAnyMatchPlayer);
        answer.add(oneLostPlayer); 

        return answer;
    }
}