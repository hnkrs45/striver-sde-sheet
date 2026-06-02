class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int profit_if_sold_today=0;
        int least=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(least>prices[i]){
                least=prices[i];
            }
            profit_if_sold_today=prices[i]-least;
            ans=Math.max(ans, profit_if_sold_today);
        }
        return ans;
    }
}