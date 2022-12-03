import java.util.*;

class Solution {
    public StringBuilder answer = new StringBuilder();
    
    public void addGivenNumberOfCharcter(char character, int frequency) {
        for (int i = 0; i < frequency; i++) {
            answer.append(character);
        }
    }
        
    public String frequencySort(String s) {
        // First, 해쉬맵으로 연결
        // Second, List 에다가 int[] 형태로 집어넣음
        // Third, List 정렬
        // 나오는 순서대로 문자열 만듦
        Map<Character, Integer> frequencyOfCharacter = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char characterOfString = s.charAt(i);
            
            frequencyOfCharacter.put(characterOfString, frequencyOfCharacter.getOrDefault(characterOfString, 0) + 1);
        }
        
        List<int[]> characterAndFrequency = new LinkedList<>();
        System.out.println(frequencyOfCharacter);
        
        for (Character key : frequencyOfCharacter.keySet()) {
            characterAndFrequency.add(new int[] {(int) key, frequencyOfCharacter.get(key)});        
        }
        
        Collections.sort(characterAndFrequency, (o1, o2) -> o2[1] - o1[1]); // reverse order
        
        for (int[] instance : characterAndFrequency) {
            addGivenNumberOfCharcter((char) instance[0], instance[1]);
        }
        
        return answer.toString();
    }
}