class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 1. word1, word2 가 가지고 있는 알파벳이 동일해야함
        // 2. 각각 알파벳마다 가지고 있는 개수가 있는데, 그 개수들을 쭉 정렬했을때, word1 == word2 가 동일해야함
        Set<Character> alphabetOfWord1 = new HashSet<>();
        Set<Character> alphabetOfWord2 = new HashSet<>();
        Map<Character, Integer> numberOfEachAlphabetOfWord1 = new HashMap<>();
        Map<Character, Integer> numberOfEachAlphabetOfWord2 = new HashMap<>();
        
        // operate word1
        for (int i = 0; i < word1.length(); i++) {
            char letterOfWord1 = word1.charAt(i);
            alphabetOfWord1.add(letterOfWord1);
            numberOfEachAlphabetOfWord1.put(letterOfWord1, numberOfEachAlphabetOfWord1.getOrDefault(letterOfWord1, 0) + 1);
        }

        // operate word2
        for (int i = 0; i < word2.length(); i++) {
            char letterOfWord2 = word2.charAt(i);
            alphabetOfWord2.add(letterOfWord2);
            numberOfEachAlphabetOfWord2.put(letterOfWord2, numberOfEachAlphabetOfWord2.getOrDefault(letterOfWord2, 0) + 1);
        }

        if (!alphabetOfWord1.containsAll(alphabetOfWord2)) {
            System.out.println("containsAll");
            return false;
        }

        List<Integer> numberOfWord1 = new ArrayList<>();
        List<Integer> numberOfWord2 = new ArrayList<>();
        
        for (Character key : numberOfEachAlphabetOfWord1.keySet()) {
            numberOfWord1.add(numberOfEachAlphabetOfWord1.get(key));
        }

        for (Character key : numberOfEachAlphabetOfWord2.keySet()) {
            numberOfWord2.add(numberOfEachAlphabetOfWord2.get(key));
        }

        Collections.sort(numberOfWord1);
        Collections.sort(numberOfWord2);

        // System.out.println(alphabetOfWord1);
        // System.out.println(alphabetOfWord2);
        // System.out.println(numberOfWord1);
        // System.out.println(numberOfWord2);
        
        if (numberOfWord1.size() != numberOfWord2.size()) {
            // System.out.println("not equal size");
            return false;
        }

        for (int i = 0; i < numberOfWord1.size(); i++) {
            if (!numberOfWord1.get(i).equals(numberOfWord2.get(i))) {     
                // System.out.println("is fucking not equal at two list");
                return false;
            }
        }

        return true;
    }
}