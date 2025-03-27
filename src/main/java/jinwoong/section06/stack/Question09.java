package jinwoong.section06.stack;

import java.util.Stack;

/**
 * 10진수를 입력받아 2진수로 변환해 반환하는 solution( ) 함수를 구현하세요.
 * <p>
 * 제약조건 <br/>
 * decimal은 1 이상 10억 미만의 자연수
 */
public class Question09 {
    String solution(int num) {
        Stack <Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int rem = num % 2;
            num /= 2;
            stack.push(rem);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }


}
