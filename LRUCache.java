package google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache {
	private int capacity;
	// key -> val
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	// key -> index
	private Map<Integer, Integer> index = new HashMap<Integer, Integer>();
	// List, the first is the Least used one 
	private List<Integer> leastUsedIndex;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Integer>();
		index = new HashMap<Integer, Integer>();
		leastUsedIndex = new LinkedList<Integer>();
	}
	
	private void updateIndex(int key) {
		int i = index.containsKey(key) ? index.get(key) : leastUsedIndex.size()-1;
		i = i < 0 ? 0 : i; // edge case
		int curSize = map.size();
		if (!leastUsedIndex.isEmpty()) {
			leastUsedIndex.remove(i);
			leastUsedIndex.add(key);
		}
		index.put(key, curSize > capacity ? capacity-1 : leastUsedIndex.size()-1);
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return Integer.MIN_VALUE;
		}
		
		int val = map.get(key);
		updateIndex(key);
		return val;
	}

	public void set(int key, int value) {
		map.put(key, value);
		updateIndex(key);
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(1, 1);
		cache.set(2, 2);
		System.out.println("1: " + cache.get(1));
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println("1: " + cache.get(1));
		System.out.println("2: " + cache.get(2));
		cache.set(2, 2);
		System.out.println("4: " + cache.get(4));
		cache.set(5, 5);
		System.out.println("3: " + cache.get(3));
	}
}
