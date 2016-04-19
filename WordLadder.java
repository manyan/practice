package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	// below method will exceed time limit
	public int ladderLengthExceedTimeLimit(String beginWord, String endWord, Set<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		String last = beginWord;
		String levelLast = beginWord;
		Set<String> visited = new HashSet<String>();
		int level = 1;
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			for (String s : wordList) {
				if (!visited.contains(s) && distance(cur, s) == 1) {
					if (s.equals(endWord)) {
						break;
					}
					
					visited.add(s);
					queue.add(s);
					last = s;
				}
			}
			
			if (cur.equals(levelLast)) {
				level++;
				levelLast = last;
			}
		}
		
		return level+1;
	}
	
	// so lets build the graph first
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		for (String cur : wordList) {
			Set<String> curSet = new HashSet<String>();
			for (String other : wordList) {
				if (cur.equals(other) || distance(cur, other) != 1) {
					continue;
				}
				
				curSet.add(other);
			}
			graph.put(cur, curSet);
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int length = 1;
		String last = beginWord;
		String levelLast = beginWord;
		Set<String> visited = new HashSet<String>();
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			Set<String> adj = graph.get(cur);
			for (String s : adj) {
				if (s.equals(endWord)) {
					break;
				}
				
				if (!visited.contains(s)) {
					queue.add(s);
					last = s;
					visited.add(s);
				}
			}
			
			if (cur.equals(levelLast)) {
				levelLast = last;
				length++;
			}
		}
		
		return length+1;
	}
	
	// all the words share the same length
	public int distance(String word1, String word2) {
		int L = word1.length();
		int distance = 0;
		for (int i = 0; i < L; i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				distance++;
			}
		}
		return distance;
	}
}
