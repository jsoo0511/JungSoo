import java.util.Scanner;

public class Main_백준_셀프넘버 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10001];
		int ans[] = new int[10001];
		for (int i = 1; i < 10001; i++)
			ans[i] = i;
		int cnt = 0;
		for (int n = 1; n < 10001; n++) {
			int n1 = n / 1000;
			int n2 = (n % 1000) / 100;
			int n3 = (n % 100) / 10;
			int n4 = n % 10;
			int make = n + n1 + n2 + n3 + n4;
            cnt++;
			if (make > 10000)
				continue;
			arr[n] = make;
			
		}
		
		boolean flag = true;
		for (int i = 1; i < 10001; i++) {
			flag=true;
			for (int j = 1; j < cnt; j++) {
				if (i == arr[j]) {
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println(i);
		}

	}

}
