import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_4366_정식이의은행업무_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		ArrayList<Integer> list;
		for(int test=1;test<=tc;test++) {
			String twos[]=br.readLine().split("");
			String threes[]=br.readLine().split("");
			list=new ArrayList<>();
			int two[]=new int[twos.length];
			int three[]=new int[threes.length];
			int result=0;
			for(int i=0;i<two.length;i++) { //2진수
				two[i]=Integer.parseInt(twos[i]);
			}
			for(int i=0;i<three.length;i++) { //3진수
				three[i]=Integer.parseInt(threes[i]);
			}
			
			for(int i=0;i<two.length;i++) {
				int temp=0;
				if(two[i]==0) {//0이면 1로 변환
					two[i]=1;
					for(int j=0;j<two.length;j++) {
						if(two[j]==1)
						    temp+=(int)Math.pow(2,two.length-1-j);
					}
					list.add(temp);
					two[i]=0;//복구
				}
				else {//1이면 0으로 변환
					two[i]=0;
					for(int j=0;j<two.length;j++) {
						if(two[j]==1)
						    temp+=(int)Math.pow(2,two.length-1-j);
					}
					list.add(temp);
					two[i]=1;//복구
				}
			} //1자리씩 2진수 수정 list에 저장 완료 
			
			
			outer: for(int q=0;q<list.size();q++) {//list값 하나씩 비교
				int tempResult=list.get(q);
				for(int i=0;i<three.length;i++) {
					//System.out.println("검사시작: "+tempResult);
					int temp=0;
					if(three[i]==0) {//0인경우 1과 2로 다 바꿔봄
						three[i]=1; //1로 바꾸는 경우
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						//임시계산값이랑 리스트의 값이 같으면 그것이 결과가됨
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						//2로바꿔봄
						three[i]=2;
						temp=0;
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						three[i]=0;//복구
					} else if(three[i]==1) {
						three[i]=0; //0로 바꾸는 경우
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						//2로바꿔봄
						three[i]=2;
						temp=0;
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						three[i]=1;//복구
					} else {
						three[i]=0; //0로 바꾸는 경우
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						//1로바꿔봄
						three[i]=1;
						temp=0;
						for(int j=0;j<three.length;j++) {
							if(three[j]==1)
							    temp+=(int)Math.pow(3,three.length-1-j);
							else if(three[j]==2)
								temp+=2*(int)Math.pow(3,three.length-1-j);
							else
								continue;
						}
						if(temp==tempResult) {
							result=temp;
							break outer;
						}
						three[i]=2;//복구
					}
				}
			}
			
			System.out.println("#"+test+" "+result);
			
			
		}

	}

}
