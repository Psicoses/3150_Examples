import java.util.LinkedList;
import java.util.Random;

public class StringHashMap implements StringMap{
    //Entry for every hash value
    private LinkedList<Entry>[] buckets;
    private int size = 0; //num strings in set
    private int capacity = 10; //initial capacity
    private double threshHold = 0.75;

    public StringHashMap() {
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }


    // get value for corresponding key
    public String get(String k) {
        // 1. Get the right bucket using key's hashcode
        int h = Math.abs(k.hashCode());
        LinkedList<Entry> bucket = buckets[h % buckets.length];
        for(Entry e : bucket){
            if(e.key.equals(k)){
                return e.value;
            }
        }
        //otherwise
        return null;
    }

    public boolean contains(String k) {
        return get(k) != null;
    }

    private void resize() {
        // DOUBLE THE CAPACITY

        //create temp with 2 * as many buckets

        //copy over all old entries (nested loop)
        //for each entry:
            // get its key
            // get the hashcode
            // get the correct new temp bucket
            // add the entry to the temp bucket

        //update buckets field to temp
    }

    public void put(String k, String v) {
        if(this.contains(k)) {
<<<<<<< HEAD
            System.out.println("WARNING: " + k + " already in set");
=======
            System.out.println("WARNING: " + k + " already in key set");
>>>>>>> upstream/main
            return; // exit method
        }

        //check and potentially resize # of buckets
        if(size > capacity * threshHold) {
            resize();
        }

        // get the correct bucket and add new entry
        int h = Math.abs(k.hashCode());
        LinkedList<Entry> buck = buckets[h % buckets.length];
        buck.add(new Entry(k, v));
        size++;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String all = "Map{";
        for(int i = 0; i < buckets.length; i++) {
            all += buckets[i] + ", ";
        }
        if(size > 0)
            all = all.substring(0, all.length()-2);
        return all + "}";
    }

<<<<<<< HEAD
    public static void main(String[] args){
        String[] names = {"James", "Mike", "Rob", "John", "David", "Will", "richard", "Joe", "Tom", "Mary", "Pat", "Jenn", "Linda", "Liz", "Barb", "Susan", "Jessica"};

        StringMap myMap = new StringHashMap();
        for(int i = 0; i < 40; i++){
            String randomName = names[i % names.length];

=======
    public static void main(String[] args) {
        String[] names = {"James", "Mike", "Rob", "John", "David", "Will", "Richard", "Joe",
                "Tom", "Mary", "Pat", "Jenn", "Linda", "Liz", "Barb", "Susan", "Jessica"};

        StringMap myMap = new StringHashMap();
        for(int i = 0; i < 40; i++) {
            String randomName = names[i % names.length];
>>>>>>> upstream/main
            String randomAddress = i + " Sesame St.";
            myMap.put(randomName, randomAddress);
        }
        System.out.println(myMap);
<<<<<<< HEAD
    }
=======

        System.out.println("Liz lives at " + myMap.get("Liz"));

    }



>>>>>>> upstream/main
}
