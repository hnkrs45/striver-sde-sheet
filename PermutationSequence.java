class Solution {
    public String getPermutation(int n, int k) {
        int fact[] = new int[n];
        fact[0]=1;
        for(int i=1;i<n;i++){
            fact[i]=fact[i-1]*i;
        }
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        k--;
        StringBuilder result = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            int index=k/fact[i];
            result.append(numbers.get(index));
            numbers.remove(index);
            k%=fact[i];
        }
        return result.toString();
    }
}