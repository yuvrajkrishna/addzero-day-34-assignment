import java.util.Objects;

class HashMap2 {
    int capacity = 16;
    LinkedList[] linkedLists = new LinkedList[capacity];

    void put(int key, String value) {
        int hashCode = Objects.hashCode(key);
        int bucketNumber = hashCode % capacity;

        // Create the LinkedList if bucket is empty
        if (linkedLists[bucketNumber] == null) {
            linkedLists[bucketNumber] = new LinkedList();
        }

        linkedLists[bucketNumber].addtoLinkedList(key,value,hashCode);
    }

    String get(int key) {
        int hashCode = Objects.hashCode(key);
        int bucketNumber = hashCode % capacity;

        if (linkedLists[bucketNumber] == null) {
            return null;
        }

        return linkedLists[bucketNumber].find(key);
    }
}

class LinkedList {
    Node head, tail;

    void addtoLinkedList(int key , String value , int hashCode) {
        Node nn = new Node(key, value, hashCode);

        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
    }

    public String find(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }

        return null;
    }
}

class Node {
    int key;
    String value;
    int hashCode;
    Node next;

    public Node(int key, String value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

public class Prog1 {
    public static void main(String[] args) {
        HashMap2 hashMap = new HashMap2();

        hashMap.put(1, "abc");
        hashMap.put(2, "pqr");
        hashMap.put(3, "xyz");

        System.out.println(hashMap.get(2));
    }
}