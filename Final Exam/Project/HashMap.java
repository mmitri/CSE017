import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Generic class HashMap 
 * Implementation of the hash table data structure
 * @author Houria Oudghiri
 * Date of creation: December 10, 2021
 * @param <K> type of the key
 * @param <V> type of the value
 */
public class HashMap<K, V> {
	public static int iterations;
	private int size;
	private double loadFactor;
	private LinkedList<HashMapEntry<K, V>>[] hashTable;
	/**
	 * Private inner class for the type of the hash table entries
	 *
	 * @param <K> type of the key
	 * @param <V> type of the value
	 */
	private class HashMapEntry<K, V> {
		K key;
		V value;
		/**
		 * Constructor of the class
		 * @param k initial value of key
		 * @param v initial value of value
		 */
		public HashMapEntry(K k, V v) {
			key = k;
			value = v;
		}
		/**
		 * Method to get the value of the entry key
		 * @return value of the data member key
		 */
		public K getKey() {
			return key;
		}
		/**
		 * Method to get the value of the entry value
		 * @return value of the data member value
		 */
		public V getValue() {
			return value;
		}
		/**
		 * Method to set the value of the entry key
		 * @param k new value of the data member key
		 */
		public void setKey(K k) {
			key = k;
		}
		/**
		 * Method to set the value of the entry value
		 * @param v new value of the data member value
		 */
		public void setValue(V v) {
			value = v;
		}
		/**
		 * Method to return the entry members as a string
		 * @return key and value as a string
		 */
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
	/**
	 * Default constructor
	 * sets the capacity of the hash table to 100
	 * sets the load factor to 0.9
	 */
	public HashMap() {
		this(100, 0.9);
	}
	/**
	 * Constructor with one parameter
	 * @param c: capacity of the hash table
	 * sets the load factor to 0.9
	 */
	public HashMap(int c) { // O(log n)
		this(c, 0.9);
	}
	/**
	 * Constructor with two parameters
	 * @param c: capacity of the hash table 
	 * @param lf: load factor of the hash table
	 */
	public HashMap(int c, double lf) {
		hashTable = new LinkedList[trimToPowerOf2(c)];
		loadFactor = lf;
		size = 0;
	}
	/**
	 * Private method to find the closest power of 2 
	 * for the capacity of the hash table
	 * @param c: capacity of the hash table
	 * @return the closest power of 2 to c
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1; // * 2
		return capacity;
	}
	/**
	 * Hash function
	 * Uses the bitwise operator & instead of %
	 * Capacity of the hash table is a power of 2
	 * @param hashCode value to be hashed
	 * @return a valid index within the hash table capacity
	 */
	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}
	/**
	 * Rehash function
	 * Creates a new hash table with double capacity
	 * All entries are rehashed in the new table using put()
	 */
	private void rehash() {
		ArrayList<HashMapEntry<K,V>> list = toList();
		hashTable = new LinkedList[hashTable.length << 1];
		size = 0;
		for(HashMapEntry<K,V> entry: list)
			put(entry.getKey(), entry.getValue());
	}

	/**
	 * Method size
	 * @return the number of entries inserted in the hash table
	 */
	public int size() {
		return size;
	}
	/**
	 * Method clear to reset all the hash table entries to null
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				hashTable[i].clear();
	}
	/**
	 * Predicate to indicate if the hash table is empty
	 * @return true if there are no entries in the hash table
	 */
	public boolean isEmpty() { // O(1)
		return (size == 0);
	}

	/**
	 * Search method for the hash table
	 * @param key: key being searched in the hash table
	 * @return true if an entry has a key equal to key
	 * uses the definition of the method equals() for type K
	 */
	public boolean containsKey(K key) {
		if (get(key) != null)
			return true;
		return false;
	}
	
	/**
	 * Method get() to get the value of the entry with the key equal to key
	 * @param key: key being searched
	 * @return the value of the entry that has key
	 */
	public V get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] != null) {
			LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
			for (HashMapEntry<K, V> entry : ll) {
				iterations++;
				if (entry.getKey().equals(key))
					return entry.getValue();
			}
		}
		return null;
	}
	
	/**
	 * Method remove to remove the entry that has the key equal to key
	 * @param key: key to be searched and removed
	 * Entry removed if found, otherwise hash table stays unchanged
	 */
	public void remove(K key) { // O(1)
		int HTIndex = hash(key.hashCode());
		if (hashTable[HTIndex] != null) { // key is in the hash map
			LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
			for (HashMapEntry<K, V> entry : ll) {
				if (entry.getKey().equals(key)) {
					ll.remove(entry);
					size--;
					break;
				}
			}
		}
	}
	
	/**
	 * Method put
	 * @param key: key of the entry to be added to the hash table
	 * @param value: value of the entry to be added to the hash table
	 * @return the old value of the entry if the entry already exists in the hash table
	 *         the new value of the entry if a new entry is added to the hash table
	 */
	public V put(K key, V value) {
		if(get(key) != null) {
			int HTIndex = hash(key.hashCode());
			LinkedList<HashMapEntry<K,V>> ll;
			ll = hashTable[HTIndex];
			for(HashMapEntry<K,V> entry: ll) {
				if(entry.getKey().equals(key)) {
					V old = entry.getValue();
					entry.setValue(value); 
					return old;
				}
			}
		}
		// key not in the hash map - check load factor
		if(size >= hashTable.length * loadFactor)
			rehash();
		int HTIndex = hash(key.hashCode());
		//create a new LL if empty
		if(hashTable[HTIndex] == null){
				hashTable[HTIndex] = new LinkedList<>();
		}
		hashTable[HTIndex].add(new HashMapEntry<>(key, value));
		size++; 
		return value;
	}
	
	/**
	 * Method toList
	 * @return the entries of the hash table in an array list
	 */
	public ArrayList<HashMapEntry<K,V>> toList(){
		ArrayList<HashMapEntry<K,V>> list = new ArrayList<>();
		for(int i=0; i< hashTable.length; i++) {
			if(hashTable[i]!= null) {
				LinkedList<HashMapEntry<K,V>> ll = hashTable[i];
				for(HashMapEntry<K,V> entry: ll)
					list.add(entry);
			}
		} 
		return list;
	}
	/**
	 * Method toString
	 * @return the entries of the hash table in a string
	 */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				for(HashMapEntry<K,V> entry: hashTable[i])
					out += entry.toString();
				out += "\n";
			}
		}
		out += "]"; 
		return out;
	}
}

