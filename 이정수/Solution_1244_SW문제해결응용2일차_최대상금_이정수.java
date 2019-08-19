import java.io.*;
 
public class Solution_1244_SW문제해결응용2일차_최대상금_이정수 {
    static int result,maxCount;
    static boolean[][] check;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
         
        for (int test = 1; test <= tc; test++) {
            String[]s=br.readLine().split(" ");
            String number=s[0];
            maxCount=Integer.parseInt(s[1]);//카운트 횟수
             
            check=new boolean[maxCount+1][1000000]; //같은 횟수에 같은 수 방문했는지 확인
            result=0;
             
            changeNumber(number.toCharArray(),0);
            System.out.println("#"+test+" "+result);
            System.out.println();
 
        }
 
    }// end main
 
    public static void changeNumber(char[] numberChar,int nowCount) {
        if(maxCount==nowCount) { //횟수만큼 바꿨으면 결과입력 후 종료
        	//탐색된 값이 기존result보다 작으면 무시하고 크면 result값으로 입력
            result = result>getInteger(numberChar)? result: getInteger(numberChar);
            return;
        }
         
        int max=numberChar.length; //char배열의 길이
         
        for(int i=0;i<max-1;i++) {
            for(int j=i+1;j<max;j++) {
                char[] tempNumber=swap(numberChar,i,j);//해당 자리바꾼 char가져오기
                System.out.println("swap후: "+getInteger(tempNumber));
                if(!check[nowCount+1][getInteger(tempNumber)]) { //같은 횟수내 같은 숫자를 탐색하지 않았으면 탐색시작
                    check[nowCount+1][getInteger(tempNumber)]=true; //해당 횟수에 해당 숫자 탐색 시작
                    changeNumber(tempNumber,nowCount+1);
                    System.out.println("changeNumber후: "+getInteger(tempNumber));
                }
            }
        }
         
    }
     
    public static int getInteger(char[] numberChar) {//char배열 int로 변환
        return Integer.valueOf(String.valueOf(numberChar));
    }
     
    public static char[] swap(char[] numberChar,int point1,int point2) {
        char[] tempNumber=numberChar.clone();
        char num=tempNumber[point1];
        tempNumber[point1]=tempNumber[point2];
        tempNumber[point2]=num;
        return tempNumber;
    }
}// end class