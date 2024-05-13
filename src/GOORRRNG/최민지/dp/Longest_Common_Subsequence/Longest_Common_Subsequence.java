class Solution {
  public int longestCommonSubsequence(String text1, String text2) {

      int len1 = text1.length();
      int len2 = text2.length();

      // dp[i][j] = text1의 처음 i개 문자와 text2의 처음 j개 문자까지 고려했을 때의 가장 긴 공통 부분 문자열의 길이
      int[][] dp = new int[len1+1][len2+1];

      // 모든 가능한 쌍 비교
      for(int i = 1; i <= len1; i++){
        for(int j = 1; j <= len2; j++){
          if(text1.charAt(i-1) == text2.charAt(j-1)){
            // 문자가 같으면 가장 긴 공통 부분 문자열의 길이 + 1
            dp[i][j] = dp[i-1][j-1] + 1;
          } else {
            // 문자가 다르면 이전 단계에서의 가장 긴 공통 부분 문자열의 길이를 그대로
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
          }
        }
      }

      // dp[len1][len2]에는 text1과 text2의 전체 길이에 대한 가장 긴 공통 부분 뮨자열의 길이가 저장됨
      return dp[len1][len2];
  }
}
