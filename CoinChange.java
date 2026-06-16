class Solution {
    int dp[]=new int[10001];
    int solve(int[] coins, int amount){
        if(amount==0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int ans=(int)1e9;
        for(Integer denom: coins){
            if(amount-denom>=0){
                ans=Math.min(ans, solve(coins, amount-denom)+1);
            }
        }
        return dp[amount]=ans;
    }
    public int coinChange(int[] coins, int amount) {
        for(int i=0;i<10001;i++){
            dp[i]=-1;
        }
        int ans=solve(coins, amount);
        return ans==1e9? -1: ans;
    }
}