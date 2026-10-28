import java.util.HashMap;

public class lruq{
    public static void main(String[] args) {
        lru l = new lru();
        l.put(10);
        l.put(20);
        l.put(30);
        l.put(40);
    }
}

class lru{
    private int n = 0;
    private int l = 4;
    doublyLL d = new doublyLL();
    HashMap<Integer,Integer> map = new HashMap<>();
    public void put(int data){
        if(n == l-1){
            d.removehead();
            d.add(data);
            d.print();
        }
        else{
            d.add(data);
            map.put(data, 0);
            n++;
        }
    }
}



class doublyLL{
    Node head;
    Node tail;
    public doublyLL(){
        head = tail = null;
    }
    public void add(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn;
            tail.next = null;
        }
        else{
            tail.next = nn;
            nn.prev = tail;
            tail = nn;
        }
    }
    public void print(){
        if(head == null){
            System.out.println("Empty LL");
        }
        else{
            Node temp = head;
            while(temp!= null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    public void removehead(){
        if(head == null){
            System.out.println("Empty LL");
        }
        else{
            head = head.next;
            head.prev= null;
        }

    }
    
    public void update(int data , int newdata){
        if(head == null){
            System.out.println("Empty LL");
        }
        else if(head.data == data){
            head.data = newdata;
        }
        else{
            Node temp = head.next;

            while(temp!= null){
                if(temp.data == data){
                    temp.data = newdata;
                    return;
                }
                temp = temp.next;
            }
            
            if(temp == null){
                System.out.println("Value Doesn't Exist");
            }
        }
    }
}

class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data = data;
    }
}