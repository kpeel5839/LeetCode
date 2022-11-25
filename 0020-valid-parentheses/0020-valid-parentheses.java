import java.util.*;

class Solution {
    Stack<Character> bracketStore = new Stack<>();

    public boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    public boolean sameTypeBracket(char bracket) {
        if (bracketStore.empty()) {
            return false;
        }

        // bracket 이 맞는지 봐야함
        if (bracketStore.peek() == '(' && bracket == ')') {
            return true;
        } else if (bracketStore.peek() == '[' && bracket == ']') {
            return true;
        } else if (bracketStore.peek() == '{' && bracket == '}') {
            return true;
        }

        return false;
    }

    public boolean isValid(String s) {
        for (int index = 0; index < s.length(); index++) {
            char characterOfThisIndexInString = s.charAt(index);
            
            if (isOpenBracket(characterOfThisIndexInString)) {
                bracketStore.push(characterOfThisIndexInString);   
            } else if(sameTypeBracket(characterOfThisIndexInString)) {
                bracketStore.pop();
            } else {
                return false;
            }
        }

        return bracketStore.empty();
    }
}