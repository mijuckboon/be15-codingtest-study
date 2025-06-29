package jinwoong.section15.dp;

public class Question67 {

    /**
     * LCS 길이 계산하기
     * <p>
     * 제약 조건: str, str2의 길이는 1 이상 1,000 이하
     * </p>
     * @param str1 알파벳 대문자, 소문자로 구성된 문자열
     * @param str2 알파벳 대문자, 소문자로 구성된 문자열
     * @return 최장 공통 부분 수열의 길이
     */
    int solution(String str1, String str2) {
        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            char char1 = str1.charAt(i - 1);

            for (int j = 1; j <= str2.length(); j++) {
                char char2 = str2.charAt(j - 1);

                if (char1 == char2) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                if (char1 != char2) {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }

            }

        }

        return lcs[str1.length()][str2.length()];
    }
}
