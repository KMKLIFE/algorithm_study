package baekjoon;

import java.util.*;
import java.io.*;

public class 색종이만들기 {
	static int whitePaper = 0;
	static int bluePaper = 0;
	static int[][] paper;

	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		//System.out.println();
		//printPaper(paper);
		
		check(0,0, N);
		
		System.out.println(whitePaper);
		System.out.println(bluePaper);
		
		
	}
	
	private static void check(int y, int x, int N) {
		int first = paper[y][x];
		boolean flag = false;
		
		for(int i=y; i<y+N; i++) {
			for(int j=x; j<x+N; j++) {
				if(paper[i][j] != first) {
					div(y, x, N);
					flag = true;
					break;
				}
			}
			if(flag) 
				break;
		}
		
		if(!flag) {
			if(first == 0) 
				whitePaper += 1;
			
			else 
				bluePaper += 1;
			
		}
	}
	
	private static void div(int y, int x, int N) {
		int newN = N / 2;
		
		check(y, x, newN);
		check(y,x + newN, newN);
		check(y + newN, x, newN);
		check(y + newN, x + newN, newN);
		
	}
	
	static void printPaper(int[][] paper) {
		for(int[] arr : paper) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
