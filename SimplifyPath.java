package google;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] pathes = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (String s : pathes) {
			if (s.isEmpty() || s.equals(".")) {
				continue; // ignore
			} 
			
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(s);
			}
		}
		
		if (stack.isEmpty()) {
			return "/";
		} else {
			pathes = stack.toArray(new String[0]);
			return "/" + String.join("/", pathes);
		}
	}
	
	public static void main(String[] arsg) {
		String s = "/home/.././/cat";
		Stack<String> stack = new Stack<String>();
		stack.add("a");
		stack.add("b");
		String[] template = stack.toArray(new String[0]);
		System.out.println(String.join("/", template));
	}
}
