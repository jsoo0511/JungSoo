import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1103_경비원_이정수 {
        public static int arr[][],row,col;
        public static Queue<Integer> pr;
        public static Queue<Integer> pc;
        public static Queue<Integer> loc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		col=Integer.parseInt(s[0]);//가로길이
		row=Integer.parseInt(s[1]);//세로길이
		pr=new LinkedList<>();
		pc=new LinkedList<>();
		loc=new LinkedList<>();
		int test=Integer.parseInt(br.readLine());
		int sum=0;
		arr=new int[row][col];
		for(int i=0;i<=test;i++) {
			String pos[]=br.readLine().split(" ");
			if(i!=test) {
				if(Integer.parseInt(pos[0])==1) { //가게 북쪽
					 pr.add(0);pc.add(Integer.parseInt(pos[1]));loc.add(1);
				} else if(Integer.parseInt(pos[0])==2) {//가게 남쪽
					 pr.add(row-1);pc.add(Integer.parseInt(pos[1]));loc.add(2);
				} else if(Integer.parseInt(pos[0])==3) {//가게 서쪽
					pr.add(Integer.parseInt(pos[1]));pc.add(0);loc.add(3);
				} else {//가게 동쪽
					pr.add(Integer.parseInt(pos[1]));pc.add(col-1);loc.add(4);
				}
			}
			
			else { //동근이 위치
				if(Integer.parseInt(pos[0])==1) { //동근 북쪽
					int start_c=Integer.parseInt(pos[1]);
					
					
					while(!pr.isEmpty()) {
						int c=pc.poll();
						int r=pr.poll();
						int lo=loc.poll();
						int right=0;
						int left=0;
						int result=0;
						if(lo==1) {
							result=Math.abs(start_c-c);
						} else if(lo==2) {
							right=start_c+row+c;
							left=(col-start_c)+row+(col-c);
							if(right>left)
								result=left;
							else
								result=right;
						} else if(lo==3) {
							result=start_c+r;
						} else {
							result=(col-start_c)+r-1;
						}
						
						sum+=result;
					}
					 
				} else if(Integer.parseInt(pos[0])==2) {//동근 남쪽
					int start_c=Integer.parseInt(pos[1]);
					
					
					while(!pr.isEmpty()) {
						int c=pc.poll();
						int r=pr.poll();
						int lo=loc.poll();
						int right=0;
						int left=0;
						int result=0;
						if(lo==1) {
							right=start_c+row+c;
							left=(col-start_c)+row+(col-c);
							if(right>left)
								result=left;
							else
								result=right;
						} else if(lo==2) {
							result=Math.abs(start_c-c);
						} else if(lo==3) {
							result=start_c+row-r;
						} else {
							result=(col-start_c)+row-r;
						}
						sum+=result;
						
					}
				} else if(Integer.parseInt(pos[0])==3) {//동근 서쪽
					int start_r=Integer.parseInt(pos[1]);
					
					while(!pr.isEmpty()) {
						int c=pc.poll();
						int r=pr.poll();
						int lo=loc.poll();
						int right=0;
						int left=0;
						int result=0;
						if(lo==1) {
							result=r+start_r;
						} else if(lo==2) {
							result=start_r+(row-r);
						} else if(lo==3) {
							result=Math.abs(r-start_r);
						} else {
							right=start_r+col+r;
							left=(row-start_r)+col+(row-r);
							if(right>left)
								result=left;
							else
								result=right;
						}
						sum+=result;
					}
				} else {//동근 동쪽
					int start_r=Integer.parseInt(pos[1]);
					while(!pr.isEmpty()) {
						int c=pc.poll();
						int r=pr.poll();
						int lo=loc.poll();
						int right=0;
						int left=0;
						int result=0;
						if(lo==1) {
							result=start_r+col-c;
						} else if(lo==2) {
							right=start_r+col+r;
							left=(row-start_r)+col+(row-r);
							if(right>left)
								result=left;
							else
								result=right;
						} else if(lo==3) {
							result=(col-c+1)+(row-start_r);
						} else {
							result=Math.abs(r-start_r);
							
						}
						sum+=result;
					}
				}
			}
		}
		
		System.out.println(sum);

	}

}
