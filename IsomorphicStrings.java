package google;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.isEmpty()) {
			return t == null || t.isEmpty();
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		int L = s.length();
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> reversed = new HashMap<Character, Character>();
		for (int i = 0; i < L; i++) {
			char c = s.charAt(i);
			char other = t.charAt(i);
			if (map.containsKey(c) && map.get(c) != other || reversed.containsKey(other) && reversed.get(other) != c) {
				return false;
			} 
			map.put(c, other);
			reversed.put(other, c);
		}
		
		return true;
	}
	
	/*
	 * same idea as about solution, but with smaller memory footprint and faster speed
	 * */
	public boolean isIsomorphicImproved(String s, String t) {
		if (s == null || s.isEmpty()) {
			return t == null || t.isEmpty();
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		int L = s.length();
		// instead of using to map, we use 2 arrays with a link value
		int[] smap = new int[256];
		int[] tmap = new int[256];
		int link = 1;
		
		for (int i = 0; i < L; i++) {
			char c = s.charAt(i);
			char other = t.charAt(i);
			if (smap[c] > 0 && smap[c] != tmap[other] || tmap[other] > 0 && smap[c] != tmap[other]) {
				return false;
			}
			
			smap[c] = link;
			tmap[other] = link;
			link++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		IsomorphicStrings i = new IsomorphicStrings();
		System.out.println(i.isIsomorphic("ab", "aa"));
	}
}
