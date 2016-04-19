package google;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		// breakable[i] == true, means [0...i] is breakable
		boolean[] breakable = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (wordDict.contains(s.substring(0, i+1))) {
				breakable[i] = true;
				continue;
			}
			
			// j >= 1 is enough, as j == 0 is covered by above condition
			for (int j = i; j >= 1; j--) {
				if (breakable[j-1] && wordDict.contains(s.substring(j, i+1))) {
					breakable[i] = true;
					continue;
				}
			}
		}
		
		return breakable[s.length()-1];
	}
	
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		WordBreak w = new WordBreak();
		System.out.print(w.wordBreak("leetcode", wordDict));
	}
}
