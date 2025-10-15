import java.util.*;

class Bucket {
    LinkedList<Integer> container;

    public Bucket() {
        this.container = new LinkedList<Integer>();
    }

    void insert(Integer key) {
        if (!this.container.contains(key)) {
            this.container.addFirst(key);
        }
    }

    void deletion(Integer key) {
        this.container.remove(key);
    }

    boolean search(Integer key) {
        return this.container.contains(key);
    }
}

class MyHashSet {
    int bucketNo;
    Bucket[] buckets;

    public MyHashSet() {
        this.bucketNo = 769; // using a prime number reduces collisions
        this.buckets = new Bucket[bucketNo];
        for (int i = 0; i < bucketNo; i++) {
            this.buckets[i] = new Bucket();
        }
    }

    private int getIndex(int key) {
        return key % bucketNo;
    }

    public void add(int key) {
        int index = getIndex(key);
        this.buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = getIndex(key);
        this.buckets[index].deletion(key);
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        return this.buckets[index].search(key);
    }
}

class Implement_HashSet {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(10);
        set.add(20);
        set.add(779); // collision with 10 (779 % 769 == 10)
        
        System.out.println(set.contains(10)); // true
        System.out.println(set.contains(99)); // false
        
        set.remove(10);
        System.out.println(set.contains(10)); // false
    }
}
