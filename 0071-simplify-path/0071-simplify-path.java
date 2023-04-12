class Solution {
    public String simplifyPath(String path) {
        StringBuilder s = new StringBuilder(path);    
        int index = 1;
        
        while (s.length() < index) {
            if (s.charAt(index) == '/' && s.charAt(index - 1) == '/') {
                s.deleteCharAt(index);
            } else {
                index++;
            }
        }
        
        String[] arr = s.toString().split("/");
        Deque<String> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isBlank() || arr[i].isEmpty()) {
                continue;
            }
            
            if (arr[i].equals(".")) {
                continue;
            } else if (arr[i].equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.addLast(arr[i]);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        while (!deque.isEmpty()) {
            answer.append("/").append(deque.pollFirst());
        }
        
        return answer.length() == 0 ? "/" : answer.toString();
    }
}