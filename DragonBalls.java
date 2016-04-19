package google;
/*
 * http://blog.csdn.net/dm_vincent/article/details/7769159
 * http://www.cnblogs.com/Shirlies/archive/2012/03/06/2382118.html
 * */
public class DragonBalls {
	int[] p;
	int[] size;
	int[] move;
	
	public DragonBalls(int n) {
		p = new int[n];
		size = new int[n];
		move = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
			size[i] = 1;
		}
	}
	
	public int find(int i) {
		if (p[i] == i) {
			return i;
		}
		
		p[i] = find(p[i]);
		move[i] += move[p[i]];
		return p[i];
	}
	
	public void move(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if (pi == pj) {
			return;
		}
		
		p[pi] = pj;
		size[pj] += size[pi];
		move[pi]++;
	}
}
