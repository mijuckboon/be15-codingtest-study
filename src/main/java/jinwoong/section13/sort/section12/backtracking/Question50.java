package jinwoong.section13.sort.section12.backtracking;

public class Question50 {
    /**
     * 계수 정렬 구현하기
     * @param s 알파벳 소문자로 이루어진 문자열 (길이 1 이상 10,000 이하)
     * @return 정렬된 문자열
     */

    String solution(String s) {
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            counts[ch - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
             sb.append(String.valueOf(ch).repeat(Math.max(0, counts[ch - 'a'])));
        }

        return sb.toString();
    }


}
