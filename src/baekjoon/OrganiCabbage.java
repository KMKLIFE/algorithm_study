package baekjoon;

import java.util.Scanner;

public class OrganiCabbage {
	
	static char[][] grid;
	static int[][] land;
	static int[] moveX = {0, 1, 0, -1};	// ╩С, ©Л, го, аб 
	static int[] moveY = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int caseNum = sc.nextInt();
		int cnt = 0;
		
		while(cnt < caseNum) {
			
			int w = sc.nextInt();
			int h = sc.nextInt();
			int target = sc.nextInt();
			int answer = 0;
			
			int[][] land = new int[h][w];
			int[][] visit = new int[h][w];
			
			for(int i=0; i<target; i++) {
					
					int xPos = sc.nextInt();
					int yPos = sc.nextInt();
					
					land[yPos][xPos] = 1;
				}
			
			for(int i=0; i<visit.length; i++) {
				for(int j=0; j<visit[0].length; j++) {
					if(land[i][j] == 1 && visit[i][j] == 0) {
						answer++;
						dfs(i, j, land, land[i][j], visit, answer);
					}
				}
			}
			
			System.out.println(answer);
			
			cnt++;
		}
	}
	
	public static void dfs(int y, int x, int[][] land, int curNum, int[][] visit, int count) {

        visit[y][x] = count;
        
        for(int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX < 0 || nextX >= land[0].length || nextY < 0 || nextY >= land.length) {
				continue;
			}
			
			if(visit[nextY][nextX] != 0) { 
				continue;
			}
            
			int nextNum = land[nextY][nextX];
			if(nextNum == curNum) {
				dfs(nextY, nextX, land, nextNum, visit, count);
			}
		}
    }
}


