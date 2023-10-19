class Solution {
    public boolean backspaceCompare(String s, String t) {
        LinkedList<Character> q1 = new LinkedList<>();
        LinkedList<Character> q2 = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '#') {
                q1.pollLast();
            } else {
                q1.addLast(c);
            } 
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (c == '#') {
                q2.pollLast();
            } else {
                q2.addLast(c);
            }
        }
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();


        while (!q1.isEmpty()) {
            s1.append(q1.pollFirst());
        }

        while (!q2.isEmpty()) {
            s2.append(q2.pollFirst());
        }

        return s1.toString().equals(s2.toString());
    }
}