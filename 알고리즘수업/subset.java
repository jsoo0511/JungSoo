package 알고리즘수업_Z;

public class subset {

	public static void main(String[] args) {
		int arr[]= {1,3,2};
		int n=arr.length;
		System.out.println("1<<n: "+(1<<n));
		for(int i=0;i<(1<<n);i++) {  
			for(int j=0;j<n;j++) {
				System.out.println("비교: "+i+", "+(1<<j));
				if((i & (1<<j)) != 0) {
					System.out.println("입장");
					System.out.print(arr[j]);
					System.out.println("아웃");
				}
			}
			System.out.println();
		}

	}

}
