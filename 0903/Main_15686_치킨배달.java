import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_15686_치킨배달 {
	static public class Chicken{
		int r;
		int c;
		public Chicken(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Chicken [r=" + r + ", c=" + c + "]";
		}
	}
	
	static public class House{
		int r;
		int c;
		public House(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "House [r=" + r + ", c=" + c + "]";
		}
		
	}
	static int n;
	static int m;
	static int arr[][];
	static int copy[][];
	static ArrayList<Chicken> list;
	static ArrayList<House> list_house;
	
	static int min;
	static int distance;
	static int result;
	static int count,ans;
	static int fixr,fixc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" "); // 기본값 입력
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		arr=new int[n+1][n+1];
		copy=new int[n+1][n+1];
		min=Integer.MAX_VALUE;
		list=new ArrayList<>();
		list_house=new ArrayList<>();
		result=0;
		ans=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			String[] str=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				arr[i][j]=Integer.parseInt(str[j-1]);
				if(arr[i][j]==2)
					list.add(new Chicken(i, j));
				if(arr[i][j]==1)
					list_house.add(new House(i, j));
			}
		}
		dfs(0,0);
		System.out.println(ans);
		
		
	} //end main
	
	public static void dfs(int start,int depth) {
		if(depth==(list.size()-m)) {
			result=0;
			
			for(int i=0;i<list_house.size();i++) {
				count=0;
				min=Integer.MAX_VALUE;
				copyArr();
				fixr=list_house.get(i).r;
				fixc=list_house.get(i).c;
				for(int row=1;row<=n;row++) {
					for(int col=1;col<=n;col++) {
						if(copy[row][col]==2) {
							int dis=Math.abs(fixr-row)+Math.abs(fixc-col);
							min=Math.min(min, dis);
							count++;
						}
						if(count>=m)
							break;
					}
					if(count>=m)
						break;
				}
				result+=min;
			}
			ans=Math.min(ans, result);
			
		} else {
			for(int i=start;i<list.size();i++) {
				int temp_r=list.get(i).r;
				int temp_c=list.get(i).c;
				arr[temp_r][temp_c]=0;//치킨집 일시 제거
				dfs(i+1,depth+1);
				arr[temp_r][temp_c]=2;
			}
		}
	}
	
	public static void copyArr() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				copy[i][j]=arr[i][j];
		}
	}
	
	public static boolean isRange(int r,int c) {
		if(r>0 && r<=n && c>0 && c<=n)
			return true;
		else
			return false;
	}

}
