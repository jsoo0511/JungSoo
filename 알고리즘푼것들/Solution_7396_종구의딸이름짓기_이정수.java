import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class Solution_7396_종구의딸이름짓기_이정수 {
    public static char[][] m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            m = new char[N][];
            for (int i = 0; i < N; i++) {
                m[i] = br.readLine().toCharArray();
            }
            
            char[] crr = new char[N+M-1]; // 종구 딸 이름
            
            // BFS 탐색, 우선순위 큐 사용, (각 글자와 좌표)의 객체 사용
            PriorityQueue<V> pq = new PriorityQueue<>(new Comparator<V>() {
                @Override
                public int compare(V o1, V o2) {
                    return o1.x - o2.x; // 오름차순
                }
            });
            PriorityQueue<V> pqChild = new PriorityQueue<>(new Comparator<V>() {
                @Override
                public int compare(V o1, V o2) {
                    return o1.x - o2.x; // 오름차순
                }
            });
            PriorityQueue<V> temp; // swap용 임시 변수
            boolean[][] visited = new boolean[N][M];
            pq.add(new V(0,0));
            visited[0][0] = true;
            while(pq.size() > 0) { // queue가 빌 때까지 반복
                V v = pq.poll();
                char x = v.x;
                crr[v.r+v.c] = x; // 사전 순으로 앞서는 글자를 딸이름으로 저장
                pqChild.clear(); // 자식큐 초기화
                
                // 우
                if (v.c + 1 < M) {
                    pqChild.add(new V(v.r, v.c + 1));
                    visited[v.r][v.c + 1] = true;
                }
                // 하
                if (v.r + 1 < N) {
                    pqChild.add(new V(v.r+1, v.c));
                    visited[v.r+1][v.c] = true;
                }
                
                for (int i = pq.size(); i > 0; i--) {
                    v = pq.poll();
                    if(v.x == x) { // 우선순위가 같은 글자이면 큐에 자식을 넣는다
                        if (v.c + 1 < M && !visited[v.r][v.c + 1]) {
                            pqChild.add(new V(v.r, v.c + 1));
                            visited[v.r][v.c + 1] = true;
                        }
                        // 하
                        if (v.r + 1 < N && !visited[v.r+1][v.c]) {
                            pqChild.add(new V(v.r+1, v.c));
                            visited[v.r+1][v.c] = true;
                        }
                    }else { // 사전 순으로 뒤쪽인 글자이면 탈출
                        break;
                    }
                }
                temp = pq;
                pq = pqChild;
                pqChild = temp;
            }
                        
            StringBuilder s = new StringBuilder();
            s.append('#').append(t).append(' ').append(new String(crr));
            System.out.println(s);
        }// test case
    }// main
    public static class V{
        int r, c; // 좌표
        char x; // 좌표의 글자
        public V(int r, int c) {
            this.r = r;
            this.c = c;
            this.x = m[r][c];
        }
        
    }
}
