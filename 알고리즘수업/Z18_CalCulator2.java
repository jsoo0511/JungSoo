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
 * ( 6 + 5 * ( 2 - 8 ) / 2 )
 *  => -9
 */
public class Z18_CalCulator2 {

	public static void main(String[] args) {
		String str="( 6 + 5 * ( 2 - 8 ) / 2 )";
		String[] srr=str.split(" ");
		char[] stackOp= new char[srr.length];//연산자를 저장할 스택
        int top=-1;
        for (int i = 0; i < srr.length; i++) {
			char c=srr[i].charAt(0);
			switch(c) {
			case '('://넣을때는 3 무조건 넣음
				stackOp[++top]=c;
				for(char a:stackOp)
					System.out.print(a+" ");
				System.out.println();
				break;
			case '*': //2
			case '/': //2, 스택 내의 맨 위 연산자의 우선순위가 2라면 빼서 출력
				while(top>=0 && (stackOp[top]=='*' || stackOp[top]=='/')) {
					System.out.print(stackOp[top--]+" ");
				}
				stackOp[++top] = c;
				for(char a:stackOp)
					System.out.print(a+" ");
				System.out.println();
				break;
			case '+': //1
			case '-': //1,, 스택내의 맨 위 연산자의 우선순위가  0이면 넣고 아니면 빼서 출력
				while(top>=0 && stackOp[top] !='(') {
					System.out.print(stackOp[top--]+" ");
				}
				stackOp[++top]=c;
				for(char a:stackOp)
					System.out.print(a+" ");
				System.out.println();
				break;
			case ')': //'('나올때까지 연산자스택에서 모두빼서 출력
				while(top>=0 && stackOp[top] !='(') {
					System.out.print(stackOp[top--]+" ");
				}
				if(stackOp[top]=='(') { //여는 괄호 들어있겠지만, 확인차
					top--;
				}
				for(char a:stackOp)
					System.out.print(a+" ");
				System.out.println();
				break;
			default: //피연산자(숫자) : 바로 출력
				//System.out.print(srr[i]+" ");
				for(char a:stackOp)
					System.out.print(a+" ");
				System.out.println();
				break;
			}//end switch
        }//end for
        
      //스택에 남아있는 연산자가 있으면 꺼내서 출력
		while(top>-1) {
			System.out.print(stackOp[top--]+" ");
		}
		System.out.println();
	}

}
