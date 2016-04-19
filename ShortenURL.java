package google;
/*
 * Basically, we need a mapping, short => long
 * First idea is using hash, but we might encounter collision. 
 * and somehow we need a DB, so the idea is just to use primary key (int) as the shortend url
 * but as the id is base 10, we want something shorter, so we can baseX (X > 10)
 * and we know that valid char set is 'a' - 'z',  'A' - 'Z', 0 - 9
 * so its base 26 + 26 + 10 = 62
 * 
 * downside of above approach, we have to generate diff id for the same url
 * */
public class ShortenURL {
	// char set for base 62
	private static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	
	// lets make it generic
	public String toBaseSomething(int number, int base) {
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			sb.insert(0, chars[number%base]);
			number /= base;
		}
		
		return sb.toString();
	} 
	
	// from base to base 10
	public int toBase10(String str, int base) {
		int number = 0;
		for (int i = 0;i < str.length(); i++) {
			char c = str.charAt(i);
			if ('a' <= c && c <= 'z') {
				number = number * base + c - 'a';
			} else if ('A' <= c && c <= 'Z') {
				number = number * base + c - 'A' + 26;
			} else if ('0' <= c && c <= '9') {
				number = number * base + c - '0' + 52;
			} else {
				// invalid input
				return Integer.MIN_VALUE;
			}
		}
		
		return number;
	}
	
	public static void main(String[] args) {
		ShortenURL s = new ShortenURL();
		System.out.println(s.toBaseSomething(3908, 62));
		System.out.println(s.toBase10("bbb", 62));
		System.out.println(s.toBaseSomething(12345, 62));
		System.out.println(s.toBase10("dnh", 62));
	}
}
