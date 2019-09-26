import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산_이정수 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		for(int test=1;test<=tc;test++) {
			int result=0;
			int n=sc.nextInt();
			int arr[];
			arr=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			int before =0;//시작점
			int point;
			int after=0;
			
			
			for(int i=0;i<arr.length-1;i++) {
				
				if(arr[i]<arr[i+1]) {
					before++;
					continue;
				}
				else {
					point=arr[i];//꼭대기 발견
					for(int j=i;j<arr.length-1;j++) {//꼭대기 찍고 내려감
						if(arr[j]>arr[j+1]) {
						   after++;
						   continue;
						}
						else {
							i=j-1;
							break;
						}
					}
				}
				result+=after*before;
				after=0;
				before=0;
			}
			
			System.out.println("#"+test+" "+result);
			result=0;
			
		}

	}

}
