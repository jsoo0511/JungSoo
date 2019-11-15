public class 마이쮸_t {
public static int[] q= new int[100];
public static int f = -1;
public static int r = -1;
    public static void main(String[] args) {
        int 마이쭈 =20;
        int num = 1;//진입할 사람의 번호
        int[] cnt = {1,1,1,1,1,1,1,1,1,1,1,};//각 index사람이 받을 마이쭈 개수
        
        while(true) {
            //새로운 사람이 줄 선다(큐에 넣기),  num을 증가해두기
            q[++r] = num++;
            print(num-1+"진입");
            //줄에서 나와서 마이쭈 받기(큐에서 빼기), 다음 받을 마이쭈 개수를 증가시키기
            int x = q[++f];//줄에서 나온사람
            마이쭈 -= cnt[x];// 마이쭈 받기
            print(x+"나옴: "+ cnt[x]+"가 받음, 남은 마이쭈: "+마이쭈);
            if(마이쭈 <=0 ){
                System.out.println("20번째꺼는 "+x+"가 받음");
                break;
            }
            cnt[x]++;    // 다음 받을 마이쭈 개수 증가시킴
            
            //마이쭈 받은 사람 다시 줄서기(큐에 넣기)
                q[++r] = x;
                print(x+"진입 : ");
            
        }
    }//end of main
    
    /**큐의 줄서있는 사람의 목록 출력*/
    public static void print(String str) {
        System.out.print(str + " [");
        for (int i = f+1; i <= r; i++) {
            System.out.print(q[i]+" " );
            
        }
        System.out.println("]");
    }
}//end of class