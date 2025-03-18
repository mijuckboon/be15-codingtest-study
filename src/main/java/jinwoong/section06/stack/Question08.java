package jinwoong.section06.stack;

public class Question08 {

    boolean solution(String s) {
        // 카운터 변수: 효율은 좋으나 정합성 떨어짐
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

//    boolean solution(String s) {
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push('(');
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                } else {
//                    stack.pop();
//                }
//            }
//
//        }
//        if (stack.isEmpty()) return true;
//
//        return false;
//    }

}
