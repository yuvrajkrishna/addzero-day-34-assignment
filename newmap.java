
class HashMap2 {
    int capacity = 16;
    int size = 0;
    double loadFactor = 0.75;
    int threshold = (int) (capacity * loadFactor);

    LinkedList[] linkedLists = new LinkedList[capacity];

    void put(int key, String value) {
        int hashCode = Integer.hashCode(key);
        int bucketNumber = Math.floorMod(hashCode, capacity);

        // If key already exists, update its value
        if (linkedLists[bucketNumber] != null) {
            if (linkedLists[bucketNumber].update(key, value)) {
                return;
            }
        }

        // Create LinkedList if bucket is empty
        if (linkedLists[bucketNumber] == null) {
            linkedLists[bucketNumber] = new LinkedList();
        }

        linkedLists[bucketNumber]
            .addtoLinkedList(key, value, hashCode);

        size++;

        // Resize when load factor threshold is crossed
        if (size > threshold) {
            resize();
        }
    }

    String get(int key) {
        int hashCode = Integer.hashCode(key);
        int bucketNumber = Math.floorMod(hashCode, capacity);

        if (linkedLists[bucketNumber] == null) {
            return null;
        }

        return linkedLists[bucketNumber].find(key);
    }

    void resize() {
        LinkedList[] oldBuckets = linkedLists;

        capacity = capacity * 2;
        threshold = (int) (capacity * loadFactor);
        linkedLists = new LinkedList[capacity];

        int oldSize = size;
        size = 0;

        // Rehash all existing entries
        for (LinkedList list : oldBuckets) {
            if (list == null) {
                continue;
            }

            Node temp = list.head;

            while (temp != null) {
                put(temp.key, temp.value);
                temp = temp.next;
            }
        }

        System.out.println(
            "Capacity increased: " + capacity
            + ", size: " + size
        );
    }
}

class LinkedList {
    Node head, tail;

    void addtoLinkedList(int key, String value, int hashCode) {
        Node nn = new Node(key, value, hashCode);

        if (head == null) {
            head = tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
    }

    boolean update(int key, String value) {
        Node temp = head;

        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    String find(int key) {
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

public class newmap {
    public static void main(String[] args) {
        HashMap2 hashMap = new HashMap2();

        for (int i = 1; i <= 13; i++) {
            hashMap.put(i, "value" + i);
        }

        System.out.println(hashMap.get(2));
        System.out.println("Final capacity: " + hashMap.capacity);
        System.out.println("Total entries: " + hashMap.size);
    }
}

class Node {
    int key;
    String value;
    int hashCode;
    Node next;

    Node(int key, String value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}
