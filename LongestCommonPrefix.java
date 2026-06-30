class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer temp=new StringBuffer();
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()<=i || strs[j].charAt(i)!=ch){
                    return temp.toString();
                }
            }
            temp.append(strs[0].charAt(i));
        }
        return temp.toString();
    }
}