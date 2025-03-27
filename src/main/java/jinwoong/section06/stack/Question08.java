package jinwoong.section06.stack;

import java.util.Stack;

public class Question08 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } //else {
                    stack.pop();
                //}
            }

        }
        return stack.isEmpty();
//        if (stack.isEmpty()) return true;
//
//        return false;
    }

    boolean solution2(String s) {
        // 카운터 변수: 효율은 좋으나 정합성, 유지보수성 떨어짐 (괄호 2개 이상이면 못 쓰는 코드)
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
                if (count < 0) return false;
            }

        }

        return (count == 0);
    }


}
