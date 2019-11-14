import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
 
        for (int test = 1; test <= tc; test++) {
             
            String s[] = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            String S=s[1];
            int arr[][] = new int[N][N];
            boolean visited[][] = new boolean[N][N];// 계산 유무 처리
            for (int i = 0; i < N; i++) {
                String str[] = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            boolean flag;
            if (S.equals("up")) {
                for (int col = 0; col < N; col++) {
                    for (int row = 1; row < N; row++) {
                        flag = false;
                        int zero = 0;
                        for (int move = row - 1; move >= 0; move--) {
                            if (arr[row][col] > 0 && arr[row][col] < 2049) { // 기준 좌표값 더할 수 있는 범위
                                if (arr[move][col] == arr[row][col] && !visited[move][col]) {// 체크좌표값
                                    arr[move][col] += arr[move][col];
                                    visited[move][col] = true;// 계산한 장소 표기 2 2 4 -> 8 되는거방지
                                    arr[row][col] = 0;// 이동했으므로 0으로 변환
                                    flag = false;// 0위치 무시
                                } else if (arr[move][col] == 0) {
                                    zero = move;// 0의 위치 계속 변환
                                    flag = true;
                                } else if (arr[move][col] != arr[row][col]) {// 탐색값이 기준값보다 큰 경우 더 조사할 필요 x
                                    break;
                                }
                            } /*else if (arr[row][col] >= 8) {// 기준값이 8이상인 경우 0의 위치만 탐색
                                if (arr[move][col] == 0 && !visited[move][col]) {
                                    zero = move;
                                    flag=true;
                                }
                                else
                                    break;
                            }*/ else { // 기준값이 0이면 무시함
                                break;
                            }
                        }
 
                        if (flag && arr[row][col] != 0) { // 탐색범위에 0밖에 없는 경우
                            arr[zero][col] = arr[row][col];// 가장 먼 0으로 이동
                            arr[row][col] = 0;// 이동하고 0으로 변환
                        }
                         
//                      System.out.println(row+", "+col+"이동후 "); //테스트 출력
//                      for (int i = 0; i < N; i++) {
//                          for (int j = 0; j < N; j++) {
//                              System.out.print(arr[i][j] + " ");
//                          }
//                          System.out.println();
//                      }
                         
                    }
                }
            } else if(S.equals("left")){
 
                for (int row= 0; row < N; row++) {
                    for (int col = 1; col < N; col++) {
                        flag = false;
                        int zero = 0;
                        for (int move = col - 1; move >=0; move--) {
                            if (arr[row][col] > 0 && arr[row][col] < 2049) { // 기준 좌표값 더할 수 있는 범위
                                if (arr[row][move] == arr[row][col] && !visited[row][move]) {// 체크좌표값
                                    arr[row][move] += arr[row][move];
                                    visited[row][move] = true;// 계산한 장소 표기 2 2 4 -> 8 되는거방지
                                    arr[row][col] = 0;// 이동했으므로 0으로 변환
                                    flag = false;// 0위치 무시
                                } else if (arr[row][move] == 0) {
                                    zero = move;// 0의 위치 계속 변환
                                    flag = true;
                                } else if (arr[row][move] != arr[row][col]) {// 탐색값이 기준값보다 큰 경우 더 조사할 필요 x
                                    break;
                                }
                            } /*else if (arr[row][col] >= 8) {// 기준값이 8이상인 경우 0의 위치만 탐색
                                if (arr[row][move] == 0 && !visited[row][move]) {
                                    zero = move;
                                    flag=true;
                                }
                                else
                                    break;
                            }*/ else { // 기준값이 0이면 무시함
                                break;
                            }
                        }
 
                        if (flag && arr[row][col] != 0) { // 탐색범위에 0밖에 없는 경우
                            arr[row][zero] = arr[row][col];// 가장 먼 0으로 이동
                            arr[row][col] = 0;// 이동하고 0으로 변환
                        }
                         
//                      System.out.println(row+", "+col+"이동후 "); //테스트 출력
//                      for (int i = 0; i < N; i++) {
//                          for (int j = 0; j < N; j++) {
//                              System.out.print(arr[i][j] + " ");
//                          }
//                          System.out.println();
//                      }
                    }
                }
             
                 
            }else if(S.equals("right")) {
 
                for (int row= 0; row <N; row++) {
                    for (int col = N-1-1; col >=0; col--) {
                        flag = false;
                        int zero = 0;
                        for (int move = col+ 1; move <N; move++) {
                            if (arr[row][col] > 0 && arr[row][col] < 2049) { // 기준 좌표값 더할 수 있는 범위
                                if (arr[row][move] == arr[row][col] && !visited[row][move]) {// 체크좌표값
                                    arr[row][move] += arr[row][move];
                                    visited[row][move] = true;// 계산한 장소 표기 2 2 4 -> 8 되는거방지
                                    arr[row][col] = 0;// 이동했으므로 0으로 변환
                                    flag = false;// 0위치 무시
                                } else if (arr[row][move] == 0) {
                                    zero = move;// 0의 위치 계속 변환
                                    flag = true;
                                } else if (arr[row][move] != arr[row][col]) {// 탐색값이 기준값보다 큰 경우 더 조사할 필요 x
                                    break;
                                }
                            } /*else if (arr[row][col] >= 8) {// 기준값이 8이상인 경우 0의 위치만 탐색
                                if (arr[row][move] == 0 && !visited[row][move]) {
                                    zero = move;
                                    flag=true;
                                }
                                else
                                    break;
                            }*/ else { // 기준값이 0이면 무시함
                                break;
                            }
                        }
 
                        if (flag && arr[row][col] != 0) { // 탐색범위에 0밖에 없는 경우
                            arr[row][zero] = arr[row][col];// 가장 먼 0으로 이동
                            arr[row][col] = 0;// 이동하고 0으로 변환
                        }
//                      
//                      System.out.println(row+", "+col+"이동후 "); //테스트 출력
//                      for (int i = 0; i < N; i++) {
//                          for (int j = 0; j < N; j++) {
//                              System.out.print(arr[i][j] + " ");
//                          }
//                          System.out.println();
//                      }
                    }
                }
             
                 
             
                 
            } else { //down
                for (int col = 0; col < N; col++) {
                    for (int row = N-1-1; row >=0; row--) {
                        flag = false;
                        int zero = 0;
                        for (int move = row + 1; move < N; move++) {
                            if (arr[row][col] > 0 && arr[row][col] < 2049) { // 기준 좌표값 더할 수 있는 범위
                                if (arr[move][col] == arr[row][col] && !visited[move][col]) {// 체크좌표값
                                    arr[move][col] += arr[move][col];
                                    visited[move][col] = true;// 계산한 장소 표기 2 2 4 -> 8 되는거방지
                                    arr[row][col] = 0;// 이동했으므로 0으로 변환
                                    flag = false;// 0위치 무시
                                } else if (arr[move][col] == 0) {
                                    zero = move;// 0의 위치 계속 변환
                                    flag = true;
                                } else if (arr[move][col] != arr[row][col]) {// 탐색값이 기준값보다 큰 경우 더 조사할 필요 x
                                    break;
                                }
                            } /*else if (arr[row][col] >= 8) {// 기준값이 8이상인 경우 0의 위치만 탐색
                                if (arr[move][col] == 0 && !visited[move][col]) {
                                    zero = move;
                                    flag=true;
                                }
                                else
                                    break;
                            }*/ else { // 기준값이 0이면 무시함
                                break;
                            }
                        }
 
                        if (flag && arr[row][col] != 0) { // 탐색범위에 0밖에 없는 경우
                            arr[zero][col] = arr[row][col];// 가장 먼 0으로 이동
                            arr[row][col] = 0;// 이동하고 0으로 변환
                        }
                         
//                      System.out.println(row+", "+col+"이동후 "); //테스트 출력
//                      for (int i = 0; i < N; i++) {
//                          for (int j = 0; j < N; j++) {
//                              System.out.print(arr[i][j] + " ");
//                          }
//                          System.out.println();
//                      }
                    }
                }
             
                 
            }
 
            System.out.println("#" + test);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
 
        }
 
    }
 
}