package google;
/*
 * variation of leet code wildcard matching
 * ? matches any single char
 * * matches any sequence of chars including empty 
 * */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				j++;
				mark = i;
				// 这一步是关键，匹配s中当前字符与p中‘＊’后面的字符，如果匹配，则在第一个if中处理，如果不匹配，则继续比较s中的下一个字符。
			} else if (star != -1) {
				// star matching again
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		// 最后在此处处理多余的‘＊’，因为多个‘＊’和一个‘＊’意义相同。
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}
	
	public static void main(String[] args) {
		WildcardMatching w = new WildcardMatching();
//		System.out.println(w.isMatch("acdbbaedc", "a*b*dc"));
		System.out.println(w.isMatch("acdbbd", "a*bd"));
	}
}
