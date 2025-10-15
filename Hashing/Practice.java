import java.util.*;
class Bucket
{
    LinkedList<Integer> containers;

    public Bucket()
    {
        this.containers= new LinkedList<Integer>();
    }

    public void add(Integer val)
    {
        if(!this.containers.contains(val))
        this.containers.addFirst(val);
    }
    public void deletion(Integer val)
    {
        this.containers.remove(val);
    }
    public boolean search(Integer val)
    {
        
        return this.containers.contains(val);
    }
}

class MyHash{
    int bucketSize;
    Bucket[] buckets;

    public MyHash()
    {
        bucketSize=769;
        buckets= new Bucket[bucketSize];
        for(int i=0; i<bucketSize; i++)
        {
            this.buckets[i]= new Bucket();
        }
    }

    int getIndex(int key)
    {
        return key % bucketSize;
    }

    public void put(int key)
    {
        int index= getIndex(key);
        this.buckets[index].add(key);
    }
    public void remove(int key)
    {
        int index= getIndex(key);
        this.buckets[index].deletion(key);
    }
    public boolean find(int key)
    {
        int index= getIndex(key);
        return this.buckets[index].search(key);
    }
}
public class Practice {
    public static void main(String[] args) {
           MyHash set = new MyHash();
        set.put(10);
        set.put(20);
        set.put(779); // collision with 10 (779 % 769 == 10)
        
        System.out.println(set.find(10)); // true
        System.out.println(set.find(99)); // false
        
        set.remove(10);
        System.out.println(set.find(10)); // false
    }
}