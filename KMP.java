package google;

public class KMP {
	public static boolean contains(String S1, String S2) {
		if (S1 == null || S1.isEmpty()) {
			return S2 == null || S2.isEmpty();
		}
		if (S2 == null || S2.isEmpty()) {
			return true;
		}

		int[] next = getNext(S2);
		int i = 0;
		int j = 0;
		while (i < S1.length() && j < S2.length()) {
			if (j == -1 || S1.charAt(i) == S2.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		
		return j == S2.length();
	}

	public static int[] getNext(String S) {
		int i = 0;
		int j = -1;
		int L = S.length();
		int[] next = new int[L];
		next[0] = -1;
		while (i < L - 1) {
			if (j == -1 || S.charAt(i) == S.charAt(j)) {
				next[++i] = ++j;
			} else {
				j = next[j];
			}
		}

		return next;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("abcabdabcabdabcabdabdabc", "abcabdabc"));
	}
}
