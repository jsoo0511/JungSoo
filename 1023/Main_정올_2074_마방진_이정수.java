import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_����_2074_������_������ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		arr[0][n / 2] = 1;
		int temp_r = 0;
		int temp_c = n/2;
		temp_r -= 1;// ���� �缱���� �̵�
		temp_c -= 1;

		for (int i = 2; i <= n * n; i++) {

			if (temp_c < 0) {// ���� ������ ��� ���
				if (i % n != 0) {// n�� ����� �ƴ� ���
					arr[temp_r][n - 1] = i;//���� ��
					temp_c=n-1;
					temp_r -= 1;// ���� �缱���� �̵�
					temp_c -= 1;
				} else { // n�� ����� ���
					arr[temp_r][n - 1] = i;
					temp_c=n-1;
					temp_r += 1; //�Ʒ��� �̵�

				}
			} else if (temp_r < 0) { // ���� ������ ��� ���
				if (i % n != 0) {
					arr[n - 1][temp_c] = i;//���� ��
					temp_r  =n-2;// ���� �缱���� �̵�
					temp_c -= 1;
				} else {// n�� ����� ���
					arr[n - 1][temp_c] = i;//�Ʒ��� �̵�
					temp_r =n;
				}
			} else {//���� ����
				if(i%n !=0){
				arr[temp_r][temp_c] = i;//���� ��
				temp_r -= 1;// ���� �缱���� �̵�
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
	
	//������ Ȯ��
	public static String check(int arr[][], int n){
		boolean flag=true;
		int row_sum=0;
		int col_sum=0;
		int cross_sum=0;
		for(int i=0;i<arr[0].length;i++){//������
			row_sum+=arr[0][i];
		}
		for(int i=0;i<arr.length;i++){//������
			col_sum+=arr[i][0];
		}
		
		for(int i=0;i<arr.length;i++){//�밢����
			cross_sum+=arr[i][i];
		}
		int temp_row_sum;
		for(int i=0;i<arr.length;i++){ //�����յ� ��
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
		    return "������ �ƴ�";
		
		int temp_col_sum;
		for(int i=0;i<arr.length;i++){ //���� �յ� ��
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
		    return "������ �ƴ�";
		
		int temp_cross_sum=0;
		for(int i=0;i<arr.length;i++){ //�밢���� �յ� ��
			temp_cross_sum+=arr[i][n-1-i];
		}
		if(temp_cross_sum!=cross_sum){
			flag=false;
		}
		
		
		if(!flag)
		    return "������ �ƴ�";
		else
			return "������ ����";
	}

}
