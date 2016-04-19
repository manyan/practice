package google;

public class CopyListWithRandomPointer {
	public static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		
		// add cloned nodes
		RandomListNode node = head;
		while (node != null) {
			RandomListNode next = node.next;
			RandomListNode cloned = new RandomListNode(node.label);
			node.next = cloned;
			cloned.next = next;
			node = next;
		}
		
		// add random nodes
		RandomListNode pre = head;
		RandomListNode cur = head.next;
		while (cur != null) {
			if (pre.random != null) {
				cur.random = pre.random.next;
			}
			
			RandomListNode nextPre = cur.next;
			if (nextPre == null) {
				break;
			}
			RandomListNode nextCur = nextPre.next;
			pre = nextPre;
			cur = nextCur;
		}
		
		// split
		RandomListNode origin = head;
		RandomListNode cloned = origin.next;
		RandomListNode clonedHead = cloned;
		while (cloned != null) {
			RandomListNode nextOrigin = cloned.next;
			if (nextOrigin == null) {
				origin.next = null;
				break;
			}
			RandomListNode nextCloned = nextOrigin.next;
			
			origin.next = nextOrigin;
			cloned.next = nextCloned;
			origin = nextOrigin;
			cloned = nextCloned;
		}
		print(head);
		System.out.println();
		return clonedHead;
	}
	
	public static void print(RandomListNode head) {
		RandomListNode node = head;
		while (node != null) {
			System.out.print("[" + node.label + ", "+ (node.next == null ? "null" : + node.next.label) + ", " + (node.random == null ? "null" : node.random.label) + " ]  -> ");
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.random = head.next;
		//print(head);
		
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		RandomListNode cloned = c.copyRandomList(head);
		print(head);
		System.out.println();
		print(cloned);
	}
}
