import java.util.LinkedList;
import java.util.Random;

public class StringHashMap implements StringMap{
    //Entry for every hash value
    private LinkedList<Entry>[] buckets;
    private int size = 0; //num strings in set
    private int capacity = 10; //initial capacity
    private double threshHold = 0.75;

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
        // 2. Loop through the bucket looking for entry with matching key

        //3. Return value for matching entry

        //otherwise
        return null;
    }

    public boolean contains(String k) {
        return get(k) != null;
    }

    public void put(String k, String v) {
        if(this.contains(k)) {
            System.out.println("WARNING: " + k + " already in set");
            return; // exit method
        }

        //check and potentially resize # of buckets

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

    public static void main(String[] args){
        String[] names = {"James", "Mike", "Rob", "John", "David", "Will", "richard", "Joe", "Tom", "Mary", "Pat", "Jenn", "Linda", "Liz", "Barb", "Susan", "Jessica"};

        StringMap myMap = new StringHashMap();
        for(int i = 0; i < 40; i++){
            String randomName = names[i % names.length];

            String randomAddress = i + " Sesame St.";
            myMap.put(randomName, randomAddress);
        }
        System.out.println(myMap);
    }
}
