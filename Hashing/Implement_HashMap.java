import java.util.*;

class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    LinkedList<Pair<Integer, Integer>> lists;

    public Bucket() {
        this.lists = new LinkedList<>();
    }

    void put(int key, int value) {
        for (Pair<Integer, Integer> p : lists) {
            if (p.first.equals(key)) {
                p.second = value;
                return;
            }
        }
        lists.addFirst(new Pair<>(key, value));
    }

    int get(int key) {
        for (Pair<Integer, Integer> p : lists) {
            if (p.first.equals(key)) {
                return p.second;
            }
        }
        return -1;
    }

    void remove(int key) {
        Iterator<Pair<Integer, Integer>> it = lists.iterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> p = it.next();
            if (p.first.equals(key)) {
                it.remove();
                return;
            }
        }
    }
}

class MyHashMap {
    int bucketNo;
    Bucket[] buckets;

    public MyHashMap() {
        this.bucketNo = 769; // prime number -> better distribution
        this.buckets = new Bucket[bucketNo];
        for (int i = 0; i < bucketNo; i++) {
            this.buckets[i] = new Bucket();
        }
    }

    int getKey(int key) {
        return key % bucketNo;
    }

    public void put(int key, int value) {
        int i = getKey(key);
        this.buckets[i].put(key, value);
    }

    public int get(int key) {
        int i = getKey(key);
        return this.buckets[i].get(key);
    }

    public void remove(int key) {
        int i = getKey(key);
        this.buckets[i].remove(key);
    }
}

public class Implement_HashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(10, 100);
        map.put(20, 200);
        map.put(779, 999); // collision with 10
        System.out.println(map.get(10));   // 100
        System.out.println(map.get(779));  // 999
        System.out.println(map.get(99));   // -1
        map.remove(10);
        System.out.println(map.get(10));   // -1
    }
}
