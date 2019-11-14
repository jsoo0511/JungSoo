import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3074_입국심사_강사님 {	public static void main(String[] args) throws NumberFormatException, IOException {	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	StringBuilder sb=new StringBuilder();int tc=Integer.parseInt(br.readLine());for (int test = 1; test <= tc; test++) {StringTokenizer st=new StringTokenizer(br.readLine()," ");int N=Integer.parseInt(st.nextToken());int M=Integer.parseInt(st.nextToken());int []t=new int[N];for(int i=0;i<t.length;i++) {t[i]=Integer.parseInt(br.readLine());}long start=0;long end=1000000000L*M;long min=Long.MAX_VALUE;while(start<=end) {long mid=(start+end)/2;long sum=0;for(int i=0;i<t.length;i++) {sum+=mid/t[i];}if(sum>=M) {if(min>mid)min=mid;end = mid -1;} else {start = mid +1;}}System.out.println("#"+test+" "+min);}}}
