import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_3459_승자예측하기_이정수{
	public static long[] arr=new long[63];
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int TC=Integer.parseInt(br.readLine());
	arr[0]=1;
	for (int i = 1; i < 63; i++) {
		arr[i]=arr[i-1]*2;
	}
	for (int i = 1; i <= TC; i++) {
		long n=Long.parseLong(br.readLine());
		int cal=1;
		int cnt=0;
		if(n==1) {
			bw.write("#"+i+" Bob\n");
			bw.flush();
			continue;
		}
		while(true) {
			if(arr[cnt]>n) {
				break;
			}
			cnt++;
		}
		
		
		long calnum=1;
		if(cnt%2==1) {		//마지막 밥이 선택
			while(calnum<=n) {
			calnum=calnum*2+1;
			if(calnum>n) {
				bw.write("#"+i+" Bob\n");
				break;
			}
			calnum=calnum*2;
			if(calnum>n) {
				bw.write("#"+i+" Alice\n");
				break;
			}
			}
		}else {
			while(calnum<=n) {
				calnum*=2;
				if(calnum>n) {
					bw.write("#"+i+" Bob\n");
					break;
				}
				calnum=calnum*2+1;
				if(calnum>n) {
					bw.write("#"+i+" Alice\n");
					break;
				}
				}
		}
		bw.flush();
		
	}
}
}