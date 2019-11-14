/**
 * 후위 표기식을 계산하기
 * 
 * */
public class Z19_Calculator3 {

	public static void main(String[] args) {
		String s = "6 5 2 8 - * 2 / +";
		String [] srr=s.split(" ");
		
		int []stackNum = new int[srr.length];
		int top=-1;
		for (int i = 0; i < srr.length; i++) {
			char c=srr[i].charAt(0);
			//숫자이면 스택에 넣고, 연산자면 숫자 2개 꺼내서 연산 후 결과를 스택에 넣기
			int num1,num2;
			switch(c) {
			case '+':
				num2=stackNum[top--];
				num1=stackNum[top--];
				stackNum[++top]=num1+num2;
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
				break;
			case '-':
				num2=stackNum[top--];
				num1=stackNum[top--];
				stackNum[++top]=num1-num2;
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
				break;
			case '*':
				num2=stackNum[top--];
				num1=stackNum[top--];
				stackNum[++top]=num1*num2;
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
				break;
			case '/':
				num2=stackNum[top--];
				num1=stackNum[top--];
				stackNum[++top]=num1/num2;
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
				break;
			default:
				stackNum[++top]=Integer.parseInt(srr[i]);
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
				break;
				
			}//end switch
			//작업 후에 스택에는 숫자 1개 남아있음
		}//end for
		System.out.println(stackNum[top--]);

	}

}
