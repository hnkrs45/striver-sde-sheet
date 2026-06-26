class LFUCache{
    private static class Node{
        int key,value,cnt;
        Node next,prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.cnt=1;
        }
    }

    private class DoubleLinkedList{
        int size;
        Node head,tail;
        DoubleLinkedList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            size=0;
        }
        void addFront(Node node){
            Node temp=head.next;
            node.next=temp;
            node.prev=head;
            head.next=node;
            temp.prev=node;
            size++;
        }
        void removeNode(Node delnode){
            Node prevNode=delnode.prev;
            Node nextNode=delnode.next;
            prevNode.next=nextNode;
            nextNode.prev=prevNode;
            size--;
        }
    }

    private Map<Integer,Node> keyNode;
    private Map<Integer,DoubleLinkedList> freqListMap;
    private int maxSizeCache,minFreq,curSize;

    public LFUCache(int capacity){
        maxSizeCache=capacity;
        minFreq=0;
        curSize=0;
        keyNode=new HashMap<>();
        freqListMap=new HashMap<>();
    }
    
    private void updateFreqListMap(Node node){
        keyNode.remove(node.key);
        freqListMap.get(node.cnt).removeNode(node);
        if(node.cnt==minFreq&&freqListMap.get(node.cnt).size==0){
            minFreq++;
        }
        DoubleLinkedList nextHigherFreqList=freqListMap.getOrDefault(node.cnt+1,new DoubleLinkedList());
        node.cnt+=1;
        nextHigherFreqList.addFront(node);
        freqListMap.put(node.cnt,nextHigherFreqList);
        keyNode.put(node.key,node);
    }
    
    public int get(int key){
        if(!keyNode.containsKey(key))return -1;
        Node node=keyNode.get(key);
        updateFreqListMap(node);
        return node.value;
    }
    
    public void put(int key,int value){
        if(maxSizeCache==0)return;
        if(keyNode.containsKey(key)){
            Node node=keyNode.get(key);
            node.value=value;
            updateFreqListMap(node);
        }else{
            if(curSize==maxSizeCache){
                DoubleLinkedList list=freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                list.removeNode(list.tail.prev);
                curSize--;
            }
            curSize++;
            minFreq=1;
            DoubleLinkedList listFreq=freqListMap.getOrDefault(minFreq,new DoubleLinkedList());
            Node node=new Node(key,value);
            listFreq.addFront(node);
            keyNode.put(key,node);
            freqListMap.put(minFreq,listFreq);
        }
    }
}
