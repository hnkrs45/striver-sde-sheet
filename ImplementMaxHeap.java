class Heap {
    int arr[];
    int size;
    public Heap() {
        arr=new int[100001];
        arr[0]=-1;
        size=0;
    }

    public void insert(int val) {
        size+=1;
        int index=size;
        arr[index]=val;
        while(index>1){
            int parent=index/2;
            if(arr[parent]<arr[index]){
                int temp=arr[parent];
                arr[parent]=arr[index];
                arr[index]=temp;
                index=parent;
            }
            else{
                return ;
            }
        }
    }

    void heapify(int arr[], int n, int i){
        int largest=i;
        int left=2*i;
        int right=2*i+1;
        if(left<=n && arr[largest]<arr[left]){
            largest=left;
        }
        if(right<=n && arr[largest]<arr[right]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr, n, largest);
        }
    }

    public void changeKey(int index, int newVal) {
        if(index>size || index<1) return;
        int oldVal=arr[index];
        arr[index]=newVal;
        if(newVal>oldVal){
            while(index>1 && arr[index/2]<arr[index]){
                int temp=arr[index/2];
                arr[index/2]=arr[index];
                arr[index]=temp;
                index=index/2;
            }
        }
        else{
            heapify(arr, size, index);
        }
    }

    public void extractMax() {
        if (size==0) return;
        arr[1]=arr[size];
        size--;
        heapify(arr, size, 1);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int getMax() {
       return size>0? arr[1]: -1;
    }

    public int heapSize() {
        return size;
    }
}

public class ImplementMaxHeap {
    public static void main(String[] args) {
        Heap h=new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        System.out.println(h.getMax());
        h.extractMax();
        System.out.println(h.getMax());
    }
}