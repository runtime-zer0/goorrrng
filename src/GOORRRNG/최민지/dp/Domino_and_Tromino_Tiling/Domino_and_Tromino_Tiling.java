class Solution {
  public int numTilings(int n) {

    if(n == 1) return 1;
    if(n == 2) return 2;
    if(n == 3) return 5;

    // dp[i] = 2 * (i + 1) 보드를 타일링하는 방법의 수
    int[] dp = new int[n+1]; 
    int mod = 1000000007;

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5;

    for(int i = 4; i <= n; i++){
        dp[i] = (((2*dp[i-1]) % mod) + dp[i-3] % mod) % mod;
    }

    return dp[n];
  }
}
