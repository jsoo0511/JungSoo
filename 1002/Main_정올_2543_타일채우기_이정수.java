import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_2543_타일채우기_이정수 {

	    static int T[][];
	    static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		T=new int[n+1][n+1];
		int r=Integer.parseInt(s[0]);
		int c=Integer.parseInt(s[1]);
		
		tile(1,1,n,n,r+1,c+1,0);
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc) {
		int mx=(sx+ex)/2,my=(sy+ey)/2;
	    if(sx==ex)
	    {
	        T[sx][sy]=hc;
	        return;
	    }
	    if(hx>=sx&&hx<=mx&&hy>=sy&&hy<=my)
	    {
	        T[mx+1][my]=1;
	        T[mx][my+1]=1;
	        T[mx+1][my+1]=1;
	        tile(sx,sy,mx,my,hx,hy,hc);
	        tile(mx+1,sy,ex,my,mx+1,my,1);
	        tile(sx,my+1,mx,ey,mx,my+1,1);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,1);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=sy&&hy<=my)
	    {
	        T[mx][my]=2;
	        T[mx+1][my]=2;
	        T[mx+1][my+1]=2;
	        tile(sx,sy,mx,my,mx,my,3);
	        tile(mx+1,sy,ex,my,hx,hy,hc);
	        tile(sx,my+1,mx,ey,mx,my+1,3);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,3);
	    }
	    else if(hx>=sx&&hx<=mx&&hy>=my+1&&hy<=ey)
	    {
	        T[mx][my]=3;
	        T[mx][my+1]=3;
	        T[mx+1][my+1]=3;
	        tile(sx,sy,mx,my,mx,my,2);
	        tile(mx+1,sy,ex,my,mx+1,my,2);
	        tile(sx,my+1,mx,ey,hx,hy,hc);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,2);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=my+1&&hy<=ey)
	    {
	        T[mx][my]=4;
	        T[mx+1][my]=4;
	        T[mx][my+1]=4;
	        tile(sx,sy,mx,my,mx,my,4);
	        tile(mx+1,sy,ex,my,mx+1,my,4);
	        tile(sx,my+1,mx,ey,mx,my+1,4);
	        tile(mx+1,my+1,ex,ey,hx,hy,hc);
	    }


	}

}
