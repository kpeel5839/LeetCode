class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        String[] cloneWords = words.clone();
        Arrays.sort(cloneWords, (s1, s2) -> {
            for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
                }
            }

            if (s1.length() > s2.length()) {
                return 1;
            }

            return -1;
        });
        
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(cloneWords[i])) {
                return false;
            }
        }
        
        return true;
    }
}