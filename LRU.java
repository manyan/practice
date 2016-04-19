package google;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU<K, V> {
	/*
	 * we need a hashmap to act as cache
	 * then we need a double linked list to keep track of the Least used node (represent as the head of the list)
	 * and we need another map to keep track of the key -> linkedlist node, so we can update the list in O(1) time
	 * */
	
	Deque<K> queue;
	private int size;
	private Map<K,V> map;
	
	public LRU(int size) {
		this.size = size;
		map = new HashMap<K, V>();
		queue = new LinkedList<K>();
	}
	
	public void set(K key, V val) {
		if (!map.containsKey(key) && map.size() >= size) {
			K removedKey = queue.pollFirst();
			map.remove(removedKey);
			queue.addLast(key);
		}
		
		map.put(key, val);	
		update(key);
	}
	
	public V get(K key) {
		return map.get(key);
	}
	
	public boolean contains(K key) {
		return map.containsKey(key);
	}
	
	// put the current node to the tail
	private void update(K key) {
		queue.remove(key);
		queue.addLast(key);
	}
	
	public static void main(String[] rags) {
		LRU<Integer, Integer> cache = new LRU<Integer, Integer>(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(1, 1);
		cache.set(4, 4);
		for (int i = 1; i <= 4; i++) {
			System.out.println(i + " : " + cache.get(i));
		}
	}
}
