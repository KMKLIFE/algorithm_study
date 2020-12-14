package baekjoon;

import java.util.*;
import java.io.*;

public class 토마토 {

	static int[] moveX = { 0, 1, 0, -1 };
	static int[] moveY = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = 0, N = 0;

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int[][] box = new int[N][M];

		for (int i = 0; i < box.length; i++) {
			s = br.readLine();
			String[] sArr = s.split(" ");

			for(int j = 0; j < sArr.length; j++){
				box[i][j] = Integer.parseInt(sArr[j]);
			}
		}

		BFS(box, M, N);
		
	}
	
	static void BFS(int[][] box, int M, int N) {
		Queue<Point> qu = new LinkedList<>();
		
		//익은 모든 토마토를 qu에 넣음
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 1) {
					qu.add(new Point(i,j));
				}
			}
		}
		
		while(!qu.isEmpty()) {
			Point point = qu.poll();
			int currX = point.x;
			int currY = point.y;
			
			for(int i=0; i<4; i++) {
				int nextX = point.x + moveX[i];
				int nextY = point.y + moveY[i];
				
				if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N)
					continue;
				
				if(box[nextY][nextX] != 0) {
					continue;
				}
				
				qu.add(new Point(nextY, nextX));
				box[nextY][nextX] = box[currY][currX] + 1;
			}
		}
		
		int minDay = 0;
		outer: for(int[] arr : box) {
			for(int num : arr) {
				if(num == 0) {
					minDay = 0;
					break outer;
				}
				minDay = Math.max(minDay, num);
			}
		}
		
		//printBox(box);
		System.out.println(minDay-1);
		
	}
	
	
	// 농장 출력 함수
	static void printBox(int[][] box) {
		for(int[] arr : box) {
			for(int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}

class Point{
	int x;
	int y;
	
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
