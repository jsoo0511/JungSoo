import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_정올_1823_냉장고_이정수 {
	public static class Chemi implements Comparable<Chemi>{
		int low;
		int high;
		public Chemi(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public String toString() {
			return "Chemi [low=" + low + ", high=" + high + "]";
		}
		@Override
		public int compareTo(Chemi o) {
			return this.high-o.high;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Chemi chemi[];
		boolean visited[];
			int result=0;
			int n=Integer.parseInt(br.readLine());
			chemi=new Chemi[n];
			visited=new boolean[n];
			for(int i=0;i<n;i++) { //클래스 초기화
				String []s=br.readLine().split(" ");
				chemi[i]=new Chemi(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			}
			
			Arrays.sort(chemi);
			int hcon=0;
			for(int i=0;i<n;i++) {
				
				for(int j=0;j<n;j++) {//hcon결정
					if(!visited[j]) {
						hcon=chemi[j].high; //Array가장 앞의 가장 높은 온도
						break;
					}
					else
						hcon=-300;
				}
				
				if(hcon==-300) //전부다 방문했으면 탈출
					break;
				
				for(int j=i;j<n;j++) {
					if(!visited[j] && chemi[j].low<=hcon) {
						visited[j]=true; //방문체크
					}
				}
				result++;
				
			}
			
			System.out.println(result);
			
			
			
		

	}

}
