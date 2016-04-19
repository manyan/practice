package google;


public class CountAndSay {
	public String countAndSay(int n) {
		String s = "1";
		for (int count = 2; count < n; count++) {
			s = getNextCountAndSay(s);
		}
		
		return s;
	}
	
	private String getNextCountAndSay(String s) {
		String tmp = "";
		int L = s.length();
		int i = 0;
		while (i < L) {
			char num = s.charAt(i);
			int c = 1;
			i++;
			while (i < L && s.charAt(i) == num) {
				i++;
				c++;
			}
			tmp += String.valueOf(c) + num;
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		String s = "1";
		for (int i = 2; i <= 10; i++) {
			s = c.getNextCountAndSay(s);
			System.out.println(s);
		}
	}
}
