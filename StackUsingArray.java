import java.util.*;
class arrayStack{
    List<Integer> li;
    arrayStack(){
        li=new ArrayList<>();
    }
    void push(int val){
        li.add(val);
    }
    int pop(){
        if(isEmpty()) return -1;
        int ans=li.get(li.size()-1);
        li.remove(li.size()-1);
        return ans;
    }
    int top(){
        if(isEmpty()) return -1;
        return li.get(li.size()-1);
    }
    boolean isEmpty(){
        return li.size()==0;
    }
}
public class StackUsingArray {
    public static void main(String[] args) {
        arrayStack as=new arrayStack();
        as.push(2);
        as.push(4);
        as.push(6);
        as.push(8);
        as.push(10);
        System.out.println(as.top());
        System.out.println(as.pop() + " deleted");
        System.out.println(as.top());
        System.out.println(as.pop() + " deleted");
        System.out.println(as.top());
        as.push(45);
        System.out.println(as.top());
        System.out.println(as.isEmpty());
    }

}