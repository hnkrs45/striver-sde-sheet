class Solution {
    public int compareVersion(String version1, String version2) {
        int v1=0,v2=0;
        int i=0,j=0;
        while(i<version1.length()||j<version2.length()){
            while(i<version1.length()&&version1.charAt(i)!='.'){
                v1*=10;
                v1+=(version1.charAt(i)-'0');
                i++;
            }
            while(j<version2.length()&&version2.charAt(j)!='.'){
                v2*=10;
                v2+=(version2.charAt(j)-'0');
                j++;
            }
            if(v1<v2){
                return -1;
            }
            else if(v1>v2){
                return 1;
            }
            else{
                v1=0;
                v2=0;
            }
            i++;
            j++;
        }
        return 0;
    }
}