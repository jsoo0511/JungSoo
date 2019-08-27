import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []s=br.readLine().split(" ");
		int col=Integer.parseInt(s[0]);
		int row=Integer.parseInt(s[1]);
		ArrayList<Integer> garo=new ArrayList<>();
		ArrayList<Integer> sero=new ArrayList<>();
		int n=Integer.parseInt(br.readLine());
		int max_garo=0;
		int max_sero=0;
		garo.add(0);
		sero.add(0);
		for(int i=0;i<n;i++){
			String num[]=br.readLine().split(" ");
			if(Integer.parseInt(num[0])==0)
				sero.add(Integer.parseInt(num[1]));
			else
				garo.add(Integer.parseInt(num[1]));
		}
		garo.add(col);
		sero.add(row);
		Collections.sort(garo);
		Collections.sort(sero);
		for(int i=0;i<garo.size()-1;i++){
			if(garo.get(i+1)-garo.get(i)>max_garo)
				max_garo=garo.get(i+1)-garo.get(i);
		}
		
		for(int i=0;i<sero.size()-1;i++){
			if(sero.get(i+1)-sero.get(i)>max_sero)
				max_sero=sero.get(i+1)-sero.get(i);
		}
		
		System.out.println(max_garo*max_sero);

	}

}
