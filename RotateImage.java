class Solution {
    void swap(int[][] matrix, int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    void rev(int arr[]){
        int s=0, e=arr.length-1;
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j>i){
                    swap(matrix, i, j);
                }
            }
        }
        for(int i=0;i<n;i++){
            rev(matrix[i]);
        }
    }
}