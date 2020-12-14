package baekjoon;

import java.util.*;
public class RGMedicine {
	
	static char[][] grid;
	static int[][] pictures, patient;
	static int[] moveX = {0, 1, 0, -1};	// ��, ��, ��, �� 
	static int[] moveY = {-1, 0, 1, 0};
	static int n;
	
	public static void main(String[] args) {
		n = 5;
		
		pictures = new int[n][n];
		patient = new int[n][n];
		
		grid = new char[][] 
	    {
							{'R', 'R', 'R', 'B', 'B'},
							{'G', 'G', 'B', 'B', 'B'},
							{'B', 'B', 'B', 'R', 'R'},
							{'B', 'B', 'R', 'R', 'R'},
							{'R', 'R', 'R', 'R', 'R'}
		};
		
		
		int count = 0, patientCount = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(pictures[i][j] == 0) {	// ���� �湮���� ���� ������ ���
					count++;
					dfs(i, j, grid[i][j], count); 
				}
				
				if(patient[i][j] == 0) {	// ���� �湮���� ���� ������ ���
					patientCount++;
					patientDFS(i, j, grid[i][j], count);
				}
			}
		}
		
		System.out.println(count + " " + patientCount);
	}
	
	static void patientDFS(int y, int x, char color, int count) {
		patient[y][x] = count;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
				continue;
			}	
			
			if(patient[nextY][nextX] != 0) { // �̹� Ž���� ���� ��� �ѱ��
				continue;
			}
			
			char nextColor = grid[nextY][nextX];
			if(nextColor == color) {
				patientDFS(nextY, nextX, nextColor, count);
			}
			else {
				if((color == 'R' && nextColor == 'G') || (color == 'G' && nextColor == 'R')) {
					patientDFS(nextY, nextX, nextColor, count);
				}
			}
		}
	}
	
	// ���ϻ����� ����� �ƴ� ��� 
	static void dfs(int y, int x, char color, int count) {
		pictures[y][x] = count;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
				continue;
			}
			
			if(pictures[nextY][nextX] != 0) { // �̹� Ž���� ���� ��� �ѱ��
				continue;
			}
			
			char nextColor = grid[nextY][nextX];
			if(nextColor == color) {
				dfs(nextY, nextX, nextColor, count);
			}
		}
	}
}
