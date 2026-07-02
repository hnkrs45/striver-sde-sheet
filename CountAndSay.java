class Solution {
    List<int[]> strtoint(StringBuffer s){
        List<int[]> ans=new ArrayList<>();
        int count=0;
        char ch=s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch) count++;
            else{
                ans.add(new int[]{ch-'0', count});
                count=1;
                ch=s.charAt(i);
            }
        }
        ans.add(new int[]{ch-'0', count});
        return ans;
    }
    StringBuffer inttostr(List<int[]> freq){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<freq.size();i++){
            sb.append(freq.get(i)[1]);
            sb.append((char)('0'+freq.get(i)[0]));
        }
        return sb;
    }
    public String countAndSay(int n) {
        StringBuffer sb=new StringBuffer();
        sb.append('1');
        List<int[]> freq=new ArrayList<>();
        for(int i=2;i<=n;i++){
            freq=strtoint(sb);
            sb=inttostr(freq);
        }
        return sb.toString();
    }
}