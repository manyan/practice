package google;

import java.util.Stack;


public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			count[chars[i] - 'a']++;
		}
		
		Stack<Character> stack = new Stack<Character>();
		int[] visit = new int[26];
		for (int i = 0; i < chars.length; i++) {
			char cur = chars[i];
			count[cur-'a']--;
			if (visit[cur-'a'] == 0) {
				while (!stack.isEmpty() && cur < stack.peek() && count[stack.peek() - 'a'] > 0) {
					visit[stack.pop() - 'a'] = 0;
				}
				stack.add(cur);
				visit[cur-'a'] = 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}
}
