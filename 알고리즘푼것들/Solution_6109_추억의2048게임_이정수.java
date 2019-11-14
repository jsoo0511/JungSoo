import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_6109_추억의2048게임_이정수 {
private static int N;
private static int[][] arr;
public static int[] queue=new int[20];
 
public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     
    int TC=Integer.parseInt(br.readLine());
    arr=new int[20][20];
    StringBuilder sb=new StringBuilder();
    for (int testCase = 1; testCase <= TC; testCase++) {
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        char dir=st.nextToken().charAt(0);
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
         
        switch(dir) {
        case 'u':
            for (int i = 0; i < N; i++) {
                int rear=-1;
                int front=-1;
                for (int j = 0; j < N; j++) {
                    if(arr[j][i]!=0) {
                        queue[++rear]=arr[j][i];
                        arr[j][i]=0;
                    }
                }
                int where=0;
                while(front<rear) {
                    int num=queue[++front];
                    if(arr[where][i]==0) {
                        arr[where][i]=num;
                    }else if(arr[where][i]==num) {
                        arr[where++][i]+=num;
                    }else {
                        arr[++where][i]=num;
                    }
                }
            }
            break;
        case 'd':
            for (int i = 0; i < N; i++) {
                int rear=-1;
                int front=-1;
                for (int j = N-1; j >=0; j--) {
                    if(arr[j][i]!=0) {
                        queue[++rear]=arr[j][i];
                        arr[j][i]=0;
                    }
                }
                int where=N-1;
                while(front<rear) {
                    int num=queue[++front];
                    if(arr[where][i]==0) {
                        arr[where][i]=num;
                    }else if(arr[where][i]==num) {
                        arr[where--][i]+=num;
                    }else {
                        arr[--where][i]=num;
                    }
                }
            }
            break;
        case 'r':
            for (int i = 0; i < N; i++) {
                int rear=-1;
                int front=-1;
                for (int j = N-1; j >= 0; j--) {
                    if(arr[i][j]!=0) {
                        queue[++rear]=arr[i][j];
                        arr[i][j]=0;
                    }
                }
                int where=N-1;
                while(front<rear) {
                    int num=queue[++front];
                    if(arr[i][where]==0) {
                        arr[i][where]=num;
                    }else if(arr[i][where]==num) {
                        arr[i][where--]+=num;
                    }else {
                        arr[i][--where]=num;
                    }
                }
            }
            break;
        case 'l':
            for (int i = 0; i < N; i++) {
                int rear=-1;
                int front=-1;
                for (int j = 0; j < N; j++) {
                    if(arr[i][j]!=0) {
                        queue[++rear]=arr[i][j];
                        arr[i][j]=0;
                    }
                }
                int where=0;
                while(front<rear) {
                    int num=queue[++front];
                    if(arr[i][where]==0) {
                        arr[i][where]=num;
                    }else if(arr[i][where]==num) {
                        arr[i][where++]+=num;
                    }else {
                        arr[i][++where]=num;
                    }
                }
            }
            break;
        }
        sb.append("#"+testCase+"\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
         
    }
    System.out.print(sb);
}
}