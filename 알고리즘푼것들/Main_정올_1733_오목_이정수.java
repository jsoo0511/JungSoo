import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_정올_1733_오목_이정수 {
	static int arr[][];
	static boolean garo[][];
	static boolean sero[][];
	static boolean diag[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[20][20];
		garo = new boolean[20][20];
		sero = new boolean[20][20];
		diag = new boolean[20][20];
		int b_garo_cnt = 0;
		int b_sero_cnt = 0;
		int b_diag_cnt = 0;
		int w_garo_cnt = 0;
		int w_sero_cnt = 0;
		int w_diag_cnt = 0;
		int row=0,col=0;
		boolean win_black = false;
		boolean win_white = false;
		for (int i = 1; i < 20; i++) {
			String s[] = br.readLine().split(" ");
			for (int j = 1; j < 20; j++) {
				arr[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		outer: for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (win_black || win_white)
					break outer;

				if (arr[i][j] == 1) {
					System.out.println(i+" ,"+j +"시작");
					// 가로체크
					if (!garo[i][j]) { // garo탐색가능한 경우
						for (int c = j; c < 20; c++) {
							if (arr[i][c] == 1)
								b_garo_cnt++;
							else {
//								b_garo_cnt=0;
								break;
							}
						}
						if (b_garo_cnt == 5) {
						//	System.out.println("garo: "+i+", "+j+" : "+b_garo_cnt);
							b_garo_cnt = 0;
							win_black = true;
							row=i;
							col=j;
						} else {
							//System.out.println("garo: "+i+", "+j+" : "+b_garo_cnt);
							for (int x = j; x < (j + b_garo_cnt>20 ? 20:j+b_garo_cnt); x++) {
								garo[i][x] = true;
							}
							b_garo_cnt = 0;
						}
					}  if (!sero[i][j]) {
						temp1: for (int r = i; r < 20; r++) {

							if (win_black)
								break temp1;
							if (arr[r][j] == 1) {
								//System.out.println("세로 임시 탐색: "+r+" : "+j+" : "+arr[r][j]);
								b_sero_cnt++;
							} else {
//								b_sero_cnt=0;
								break;
							}
						}
						if (b_sero_cnt == 5) {
						//	System.out.println("sero: "+i+", "+j+" : "+b_sero_cnt);
							b_sero_cnt = 0;
							win_black = true;
							row=i;
							col=j;
						} else {
							for (int y = i; y < (y + b_sero_cnt>20 ? 20 :y+b_sero_cnt); y++) {
								sero[y][j] = true;
							}
							b_sero_cnt=0;
						}
					} if(!diag[i][j]) {
						temp2:for(int k=0;k<20;k++) {
								if(win_black)
									break temp2;
								
								if(i+k<20 && j+k<20 && arr[i+k][j+k]==1) {
									b_diag_cnt++;
								} else {
//									b_diag_cnt=0;
									break;
								}
						}
					   if(b_diag_cnt==5) {
						//   System.out.println("diag: "+i+", "+j+" : "+b_diag_cnt);
						   b_diag_cnt=0;
						   win_black=true;
						   row=i;
							col=j;
					   } else {
						   System.out.println("diag1: "+i+", "+j+" : "+b_diag_cnt);
						   for(int r=i;r<(i+b_diag_cnt>20 ? 20: i+b_diag_cnt);r++) {
							   for(int c=j;c<(j+b_diag_cnt>20 ? 20 : j+b_diag_cnt);c++) {
								   diag[r][c]=true;
							   }
						   }
						   b_diag_cnt=0;
					   }
					   
					   temp3:for(int k=0;k<20;k++) {
							if(win_black)
								break temp3;
							
							if(i-k>=0 && j+k<20 && arr[i-k][j+k]==1) {
								b_diag_cnt++;
							} else {
//								b_diag_cnt=0;
								break;
							}
						}
							
							 if(b_diag_cnt==5) {
								   //System.out.println("diag: "+i+", "+j+" : "+b_diag_cnt);
								   b_diag_cnt=0;
								   win_black=true;
								   row=i;
									col=j;
							   } else {
								  System.out.println("diag: "+i+", "+j+" : "+b_diag_cnt);
								   for(int r=i;r>(i-b_diag_cnt<0 ? 0: i-b_diag_cnt);r--) {
									   for(int c=j;c<(j+b_diag_cnt>20 ? 20 : j+b_diag_cnt);c++) {
										   diag[r][c]=true;
									   }
								   }
								   b_diag_cnt=0;
							   }
						
					}

				} else if(arr[i][j]==2){ //백돌의 경우

					// 가로체크
					if (!garo[i][j]) { // garo탐색가능한 경우
						for (int c = j; c < 20; c++) {
							if (arr[i][c] == 2)
								w_garo_cnt++;
							else {
//								w_garo_cnt=0;
								break;
							}
						}

						if (w_garo_cnt == 5) {
							w_garo_cnt = 0;
							win_white = true;
							row=i;
							col=j;
						} else {
							for (int x = j; x < (j + w_garo_cnt>20 ? 20:j+w_garo_cnt); x++) {
								garo[i][x] = true;
							}
							w_garo_cnt = 0;
							
							for(int rr=1;rr<20;rr++) {
								   for(int cc=1;cc<20;cc++) {
									   System.out.print(diag[rr][cc]+"\t");
								   }
								   System.out.println();
							   }
							   System.out.println("----------------------------");
						}
					} if (!sero[i][j]) {
						temp1: for (int r = i; r < 20; r++) {

							if (win_white)
								break temp1;
							if (arr[r][j] == 2) {
								w_sero_cnt++;
							} else {
//								w_sero_cnt=0;
								break;
							}
						}

						if (w_sero_cnt == 5) {
							w_sero_cnt = 0;
							win_white = true;
							row=i;
							col=j;
						} else {
							for (int y = i; y < (i + w_sero_cnt>20 ? 20 : i+w_sero_cnt); y++) {
								sero[y][j] = true;
							}
							w_sero_cnt = 0;
							
							for(int rr=1;rr<20;rr++) {
								   for(int cc=1;cc<20;cc++) {
									   System.out.print(diag[rr][cc]+"\t");
								   }
								   System.out.println();
							   }
							   System.out.println("----------------------------");
						}
					} if(!diag[i][j]) {
						temp2:for(int k=0;k<20;k++) {
								if(win_white)
									break temp2;
								
								if(i+k<20 && j+k<20 && arr[i+k][j+k]==2) {
									w_diag_cnt++;
								} else {
//									w_diag_cnt=0;
									break;
								}
						}
					
					   if(w_diag_cnt==5) {
						   w_diag_cnt=0;
						   win_white=true;
						   row=i;
							col=j;
					   } else {
						   for(int r=i;r<(i+w_diag_cnt >20 ? 20 : w_diag_cnt);r++) {
							   for(int c=j;c<(j+w_diag_cnt>20 ? 20 : w_diag_cnt);c++) {
								   diag[r][c]=true;
							   }
						   }
						   w_diag_cnt=0;
						   
						   for(int rr=1;rr<20;rr++) {
							   for(int cc=1;cc<20;cc++) {
								   System.out.print(diag[rr][cc]+"\t");
							   }
							   System.out.println();
						   }
						   System.out.println("----------------------------");
					   }
					   
					   temp3:for(int k=0;k<20;k++) {
							if(win_white)
								break temp3;
							
							if(i-k>=0 && j+k<20 && arr[i-k][j+k]==2) {
								w_diag_cnt++;
							} else {
//								w_diag_cnt=0;
								break;
							}
					   }
							 if(w_diag_cnt==5) {
								  // System.out.println("diag: "+i+", "+j+" : "+b_diag_cnt);
								   w_diag_cnt=0;
								   win_white=true;
								   row=i;
									col=j;
							   } else {
								   for(int r=i;r>(i-w_diag_cnt<0 ? 0: i-w_diag_cnt);r--) {
									   for(int c=j;c<(j+w_diag_cnt>20 ? 20 : j+w_diag_cnt);c++) {
										   diag[r][c]=true;
									   }
								   }
								   w_diag_cnt=0;
								   
								   for(int rr=1;rr<20;rr++) {
									   for(int cc=1;cc<20;cc++) {
										   System.out.print(diag[rr][cc]+"\t");
									   }
									   System.out.println();
								   }
								   System.out.println("----------------------------");
							   }
						
					}

				
				} else
					continue;

			}
		} 
		//System.out.println(win_black+" : "+win_white);
		if(win_black) {
			System.out.println(1);
			System.out.println(row+" "+col);
		}
		else if(win_white) {
			System.out.println(2);
			System.out.println(row+" "+col);
		}
		else
			System.out.println(0);

	}

}
