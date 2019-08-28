import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
 
 
public class Solution_3124_최소스패닝트리_이정수 {
     
    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int w;
 
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public String toString() {
            return "Edge [a=" + a + ", b=" + b + ", w=" + w + "]";
        }
 
 
        @Override
        public int compareTo(Edge o) {
            return this.w-o.w;
        }
    }
     
    public static int []p; //트리구조를 배열로 저장, 부모의 정보를 저장
    public static int []rank; //깊이 정보 rank저장할 배열
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        int v,e;
        int start,end,weight;
        Edge G[];
        for(int test=1;test<=tc;test++) {
             
            String s[]=br.readLine().split(" ");
            v=Integer.parseInt(s[0]);//정점 수
            e=Integer.parseInt(s[1]);//간선 수
            G=new Edge[e];
            for(int i=0;i<e;i++) { //가중치 포함 클래스 배열 초기화
                String str[]=br.readLine().split(" ");
                start=Integer.parseInt(str[0]);
                end=Integer.parseInt(str[1]);
                weight=Integer.parseInt(str[2]);
                G[i]=new Edge(start,end,weight);
            }
             
            Arrays.sort(G);
            p=new int[v+1];//부모정점을 저장할 배열
            rank=new int[v+1];//깊이를 저장할 배열
            for(int i=1;i<=v;i++) {
                makeSet(i);//각 정점을 각각 하나의 집합으로 생성
            }
             
            long MST=0; //가중치의 합
            int cnt=0;
            for(int i=0;i<e;i++) {
                Edge edge=G[i];//작은 가중치의 간선부터 꺼낸다.
                int px=findSet(edge.a); //대표자를 찾음
                int py=findSet(edge.b);
                 
                if(px!=py) {//사이클이 생기지 않을 경우만 합치기, 대표자가 같을 경우 사이클이 생긴다., 다른 집합인 경우에만 doing
                    union(px,py);
                //  System.out.println(edge.a+"-"+edge.b+" "+edge.w);//선택한 간선 출력
                    MST+=edge.w;
                    cnt++;
                    if(cnt==v-1)
                        break;
                }
            }
             
            System.out.println("#"+test+" "+MST);
        }
 
    }
     
    public static void makeSet(int x) {
        p[x]=x;//부모가 자기자신이면 대표자 or 부모가 -1이면 대표자
        rank[x]=0; //초기값 0임
    }
    //대표자 탐색
    public static int findSet(int x) {
        if(p[x]==x)
            return p[x];
        else {
            p[x]=findSet(p[x]);
            return p[x];
        }
    }
    /**멤버 x, 멤버 y를 포함하는 두 집합을 통합*/
    public static void union(int x,int y) {
        int px=findSet(x);
        int py=findSet(y);
         
        //서로 다른 집합일 경우만 합쳐야함, 같은 집합인데 합치면 stackOverflowError발생
        if(px!=py) {
            link(px,py);
        }
    }
     
    public static void link(int x,int y) {
        if(rank[x]>rank[y]) {
            p[y]=x;//작은 쪽을 큰 쪽에 붙인다.
        } else {
            p[x]=y;
            if(rank[x]==rank[y])//같은 경우는 랭크값이 증가한다
                rank[y]++;
        }
    }
 
}