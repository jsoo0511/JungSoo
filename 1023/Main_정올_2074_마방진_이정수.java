import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_2074_마방진_이정수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		arr[0][n / 2] = 1;
		int temp_r = 0;
		int temp_c = n/2;
		temp_r -= 1;// 왼쪽 사선위로 이동
		temp_c -= 1;

		for (int i = 2; i <= n * n; i++) {

			if (temp_c < 0) {// 열이 범위를 벗어난 경우
				if (i % n != 0) {// n의 배수가 아닌 경우
					arr[temp_r][n - 1] = i;//저장 후
					temp_c=n-1;
					temp_r -= 1;// 왼쪽 사선위로 이동
					temp_c -= 1;
				} else { // n의 배수인 경우
					arr[temp_r][n - 1] = i;
					temp_c=n-1;
					temp_r += 1; //아래로 이동

				}
			} else if (temp_r < 0) { // 행이 범위를 벗어난 경우
				if (i % n != 0) {
					arr[n - 1][temp_c] = i;//저장 후
					temp_r  =n-2;// 왼쪽 사선위로 이동
					temp_c -= 1;
				} else {// n의 배수인 경우
					arr[n - 1][temp_c] = i;//아래로 이동
					temp_r =n;
				}
			} else {//범위 만족
				if(i%n !=0){
				arr[temp_r][temp_c] = i;//저장 후
				temp_r -= 1;// 왼쪽 사선위로 이동
				temp_c -= 1;
				}
				else{
					arr[temp_r][temp_c]=i;
					temp_r+=1;
				}
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(check(arr,n));

	}//end main
	
	//마방진 확인
	public static String check(int arr[][], int n){
		boolean flag=true;
		int row_sum=0;
		int col_sum=0;
		int cross_sum=0;
		for(int i=0;i<arr[0].length;i++){//행의합
			row_sum+=arr[0][i];
		}
		for(int i=0;i<arr.length;i++){//열의합
			col_sum+=arr[i][0];
		}
		
		for(int i=0;i<arr.length;i++){//대각선합
			cross_sum+=arr[i][i];
		}
		int temp_row_sum;
		for(int i=0;i<arr.length;i++){ //행의합들 비교
			temp_row_sum=0;
			for(int j=0;j<arr[i].length;j++){
				temp_row_sum+=arr[i][j];
			}
			if(row_sum!=temp_row_sum){
				flag=false;
				break;
			}
		}
		if(!flag)
		    return "마방진 아님";
		
		int temp_col_sum;
		for(int i=0;i<arr.length;i++){ //열의 합들 비교
			temp_col_sum=0;
			for(int j=0;j<arr[i].length;j++){
				temp_col_sum+=arr[j][i];
			}
			if(col_sum!=temp_col_sum){
				flag=false;
				break;
			}
		}
		if(!flag)
		    return "마방진 아님";
		
		int temp_cross_sum=0;
		for(int i=0;i<arr.length;i++){ //대각선의 합들 비교
			temp_cross_sum+=arr[i][n-1-i];
		}
		if(temp_cross_sum!=cross_sum){
			flag=false;
		}
		
		
		if(!flag)
		    return "마방진 아님";
		else
			return "마방진 성립";
	}

}
