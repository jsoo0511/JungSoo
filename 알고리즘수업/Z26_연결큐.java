/**
 * 선형큐: 메모리를 재활용할 수 없다.(낭비)
 *  => 삭제연산시마다 쉬프트(성능이 떨어짐)
 * 원형큐: 나머지연산 성능 떨어짐
 * 연결큐: 안쓰는 메모리는 없지만, 다음 링크를 위한 메모리가 낭비, 삽입시마다 노드 객체를 생성하는 시간이 걸린다.
 */
public class Z26_연결큐 {

	public static class Node{ //데이터, 다음 노드의 링크
		int data;
		Node link;//다음 노드
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	public static Node front;
	public static Node rear;
	
	public static void main(String[] args) {
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

	}//end main
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Underflow Error");
			return -1;
		} else {
			int data=front.data;
			front=front.link;
			if(isEmpty()) {
				rear=null;
			}
			return data;
		}
		
	}

	public static boolean isEmpty() {
		return front==null;
	}
	public static void enQueue(int item) {
		Node newNode = new Node(item); //새로운 노드 객체
		if(isEmpty()) {//공백큐
			front=newNode;
			rear=newNode;
		} else {
			rear.link = newNode;
			rear = newNode;		
		}
	}
}//end class
