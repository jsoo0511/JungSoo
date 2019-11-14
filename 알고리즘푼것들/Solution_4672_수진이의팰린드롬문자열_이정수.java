import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_4672_수진이의팰린드롬문자열_이정수 {
    static ArrayList<String> list;
    static int result;
    static int max;
    static String[] str;
    static int len;
    static String s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine());
		
		for(int test=1;test<=tc;test++) {
			max=0;
			result=0;
			s=br.readLine();
			len=s.length();
			list=new ArrayList<>();
			
			str=s.split("");
			
			Arrays.sort(str);//오름차순 정렬 
			s="";
			for(int i=0;i<str.length;i++) {
				s=s.concat(str[i]);
			}
			for(int i=1;i<=len;i++) { //부분문자열 생성
				for(int start=0;start<len;start++) {
					if(start+i>len)
						break;
					list.add(s.substring(start,start+i));
				}
			}
			//팰린드롬체크
			for(int i=0;i<list.size();i++) {
				int leng=list.get(i).length(); //부분문자열의 길이
				
				boolean flag=true;
				if(leng==1)
				{
					result++;
					continue;
				}
				else {
					if(leng%2==0) {//문자열의 길이가 짝수라면
						int centerL=(leng-1)/2;
						int centerR=centerL+1;
						
						for(int k=0;k<leng/2;k++) {
							if(list.get(i).charAt(centerL)==list.get(i).charAt(centerR)) {
								if(centerL-1<0)
									break;
								centerL--;
								centerR++;
							}
							else {
								flag=false;
						//		System.out.println("fail!!");
								break;
							}
						}
					}
					else { //문자열의 길이가 홀수라면
						int center=leng/2;
						int centerL=center-1;
						int centerR=center+1;
						
						for(int k=0;k<leng/2;k++) {
							if(list.get(i).charAt(centerL)==list.get(i).charAt(centerR)) {
								if(centerL-1<0)
									break;
								centerL--;
								centerR++;
								
							}
							else {
								flag=false;
								break;
							}
						}
					}
				}
				
				if(flag)
					result++;
			}
			System.out.println("#"+test+" "+result);
		}
	}
}
