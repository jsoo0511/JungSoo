import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕_teacher {

	private static int R;
	private static int T;
	private static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken()); //행
	    C = Integer.parseInt(st.nextToken());  //열
		T = Integer.parseInt(st.nextToken());  //시간
		
		int[][]m1=new int[R][C];//원본
		int[][]m2=new int[R][C];//복사본
		
		for(int i=0;i<T;i++) {
			//m2=new int[R][C];//객체 생성시간이 많이 걸린다.
			//작업 m1 => m2
			int [][] temp=m1;
			m1=m2;
			m2=temp; //일일이 복사하지않는다.
		}

	}

}
