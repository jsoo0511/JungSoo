import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 선형 자료구조 : 배열, 리스트, 스택, 큐, 덱 Queue류: FIFO 선입선출 front, rear 변수 두개가 필요 1. API사용
 * 2. 메서드 작성 3. 배열 인덱스 관리
 *
 */
public class Z24_Queue {

	public static void main(String[] args) {
		// 1.API사용
		Stack s = new Stack();// 클래스임, 객체를 만들수있음
		// Queue q = new Queue();//interface임, 객체생성불가
		Queue q = new LinkedList();
		System.out.println("////////API//////////");
		q.offer(6); // 삽입
		q.offer(7);
		q.offer(8);
		System.out.println(q.poll());// 삭제
		System.out.println(q.poll());
		System.out.println(q.poll());

		// 2.메서드 작성
		System.out.println("////////메서드작성//////////");
		enQueue(6);
		enQueue(7);
		enQueue(8);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		
		
		//3.배열 인덱스 관리
		System.out.println("/////////배열 인덱스 관리");
		int queue[]=new int[5];
		int f=-1;
		int r=-1;
		queue[++r]=6;
		queue[++r]=7;
		queue[++r]=8;
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);
		System.out.println(queue[++f]);

	}// end main

	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!!!");
			return -1;
		} else {
			++front;
			if(front==q.length) {
				front=0;
			}
		//	front=(front+1)%q.length;
			return q[front];
		}
	

	}
	
	public static boolean isEmpty() {
		return front==rear;
	
	}
	
	public static void delete() {
		if(isEmpty()) {
			System.out.println("Queue is Empty!!!");
		} else {
			front=(front+1)%q.length;
		}
	}
	

	public static int[] q = new int[5];// 부족하지 않게 선언
	public static int front = -1;
	public static int rear = -1;

	public static boolean isFull() {
		return (rear+1)%q.length==front;
	
	}

	public static void enQueue(int item) {
		if(isFull()) {
			System.out.println("Queue is Full!!!");
		}
		else {
			rear=(rear+1)%q.length;
			q[rear]=item;
		}
	

	}

}// end class
