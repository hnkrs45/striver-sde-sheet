import java.util.*;
class arrayQueue{
    List<Integer> li;
    arrayQueue(){
        li=new ArrayList<>();
    }
    void push(int val){
        li.add(val);
    }
    int pop(){
        if(isEmpty()) return -1;
        int ans=li.get(0);
        li.remove(0);
        return ans;
    }
    int peek(){
        if(isEmpty()) return -1;
        return li.get(0);
    }
    boolean isEmpty(){
        return li.size()==0;
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
        arrayQueue aq=new arrayQueue();
        aq.push(2);
        aq.push(4);
        aq.push(6);
        aq.push(8);
        aq.push(10);
        System.out.println(aq.peek());
        System.out.println(aq.pop() + " deleted");
        System.out.println(aq.peek());
        System.out.println(aq.pop() + " deleted");
        System.out.println(aq.peek());
        aq.push(45);
        System.out.println(aq.peek());
        System.out.println(aq.isEmpty());
    }

}