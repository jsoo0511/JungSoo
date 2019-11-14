import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 계산기
 * 중위 표기식을 후위 표기식으로 변경하기
 * 
 * 토큰   isp icp  비고
 * )    -   -   스택에 안넣음
 * *,/  2   2
 * +,-  1   1
 * (    0   3   스택에 무조건 넣음, 스택안에 있으면 무조건 위로 쌓을 수 있음
 * 마지막엔 스택에 남아있는 스택의 연산자들을 모두 계산
 * (6+5*(2-8)/2)
 *  => -9
 */
public class Z20_Calculator4 {
        static char[] stackOp;
        static int num1,num2;
        static int[] stackNum;
        static int top;
        static int n_top;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] srr=br.readLine().split("");
		stackOp= new char[srr.length];//연산자를 저장할 스택
		stackNum=new int[srr.length];//숫자를 저장
		//char[] s=new char[srr.length];
		//int index=0;
        int top=-1;
        int n_top=-1;
        for (int i = 0; i < srr.length; i++) {
			char c=srr[i].charAt(0);
			int num1,num2;
			switch(c) {
			case '('://넣을때는 3 무조건 넣음
				stackOp[++top]=c;
//				for(char a:stackOp)
//					System.out.print(a+" ");
				//System.out.println();
				break;
			case '*': //2
			case '/': //2, 스택 내의 맨 위 연산자의 우선순위가 2라면 빼서 출력
				while(top>=0 && (stackOp[top]=='*' || stackOp[top]=='/')) {
				//	s[index++]=stackOp[top];
					//System.out.print(stackOp[top--]+" ");
					operation(stackOp[top--]);
				}
				stackOp[++top] = c;
				
//				for(char a:stackOp)
//					System.out.print(a+" ");
				//System.out.println();
				break;
			case '+': //1
			case '-': //1,, 스택내의 맨 위 연산자의 우선순위가  0이면 넣고 아니면 빼서 출력
				while(top>=0 && stackOp[top] !='(') {
			//		s[index++]=stackOp[top];
					operation(stackOp[top--]);
				}
				
				stackOp[++top]=c;
//				for(char a:stackOp)
//					System.out.print(a+" ");
				//System.out.println();
				break;
			case ')': //'('나올때까지 연산자스택에서 모두빼서 출력
				while(top>=0 && stackOp[top] !='(') {
					System.out.print(stackOp[top--]+" ");
					//int temp=top+1;
			//		s[index++]=stackOp[temp];
				}
				if(stackOp[top]=='(') { //여는 괄호 들어있겠지만, 확인차
					top--;
				}
//				for(char a:stackOp)
//					System.out.print(a+" ");
				//System.out.println();
				break;
			default: //피연산자(숫자) : 바로 출력 ->
				stackNum[++n_top]=Integer.parseInt(srr[i]);
			//	System.out.print(srr[i]+" ");
			//	s[index++]=srr[i].charAt(0);
			//	System.out.println();
				break;
			}//end switch
        }//end for
        
      //스택에 남아있는 연산자가 있으면 꺼내서 출력
		while(top>-1) {
			System.out.print(stackOp[top--]+" ");
		}
		System.out.println();
		
	
		
		
		System.out.println("q출력");
		
		System.out.println();
		
		//System.out.println(operation(temp));	
	}
	
	public static void operation(char c) {
		
		//for (int i = 0; i < s.length; i++) {
			
			//숫자이면 스택에 넣고, 연산자면 숫자 2개 꺼내서 연산 후 결과를 스택에 넣기
			//num1,num2;
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
			//default:
				//stackNum[++top]=s[i]-'0';
//				for(int j:stackNum)
//					System.out.print(j+" ");
//				System.out.println();
			//	break;
				
			}//end switch
			//작업 후에 스택에는 숫자 1개 남아있음
		//}//end for
		//System.out.println(stackNum[top--]);
		//return stackNum[top--];
		
	}

}
