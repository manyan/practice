package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	// this method will exceed time limit
	public List<List<String>> groupAnagramsNotGood(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<Map<Character, Integer>, List<String>> map = new HashMap<Map<Character, Integer>, List<String>>();
		for (String s : strs) {
			Map<Character, Integer> smap = new HashMap<Character, Integer>();
			char[] cs = s.toCharArray();
			for (int i = 0; i < cs.length; i++) {
				char c = cs[i];
				int count = smap.getOrDefault(c, 0);
				smap.put(c, count+1);
			}
			
			List<String> sol = map.getOrDefault(smap, new ArrayList<String>());
			sol.add(s);
			map.put(smap, sol);
		}
		
		for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		
		return result;
	}
	
	// pass online judge
	public List<List<String>> groupAnagrams(String[] strs) {
		Arrays.sort(strs);
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s: strs) {
			int[] featureChars = new int[26];
			for (int i = 0; i < s.length(); i++) {
				featureChars[s.charAt(i) - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < featureChars.length; i++) {
				if (featureChars[i] > 0) {
					sb.append((char)('a' + i));
					sb.append(featureChars[i]);
				}
			}
			String featureString = sb.toString();
			if (!map.containsKey(featureString)) {
				map.put(featureString, new ArrayList<String>());
			}
			map.get(featureString).add(s);
		}
		
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		
		return result;
	}
}
