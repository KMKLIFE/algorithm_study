package baekjoon;

import java.util.*;
import java.io.*;

public class 토마토2 {

	static int N;
	static int M;
	static int H;
	static int[][][] container;
	static int[] moveX = { 0, 1, 0, -1 };
	static int[] moveY = { -1, 0, 1, 0 };

	static class Point3D {
		int x;
		int y;
		int z;

		public Point3D(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		container = new int[H][M][N];

		for (int i = 0; i < container.length; i++) {
			for (int j = 0; j < container[i].length; j++) {
				String[] sArr = br.readLine().split(" ");
				for (int k = 0; k < sArr.length; k++) {
					container[i][j][k] = Integer.parseInt(sArr[k]);
				}
			}
		}

		// printContainer(container);

		if (H > 1) {
			bfs3D(container);
		} else {
			bfs2D(container);
		}

	}

	static void bfs2D(int[][][] container) {
		Queue<토마토2.Point3D> qu = new LinkedList<토마토2.Point3D>();
		int minDay = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (container[i][j][k] == 1) {
						토마토2.Point3D point3D = new 토마토2.Point3D(i, j, k);
						qu.add(point3D);
					}
				}
			}
		}

		while (!qu.isEmpty()) {
			토마토2.Point3D point3D = qu.poll();
			int currX = point3D.x;
			int currY = point3D.y;

			for (int i = 0; i < 4; i++) {
				int nextX = currX + moveX[i];
				int nextY = currY + moveY[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;

				if (container[0][nextY][nextX] != 0)
					continue;
				
				qu.add(new 토마토2.Point3D(1, nextY, nextX));
				container[0][nextY][nextX] = container[0][currY][currX] + 1;

			}
		}

		outer: for (int[][] arr2D : container) {
			for (int[] arr : arr2D) {
				for (int num : arr) {
					if (num == 0) {
						minDay = 0;
						break outer;
					}
					minDay = Math.max(minDay, num);
				}
			}
		}
		
		System.out.println(minDay-1);
	}

	static void bfs3D(int[][][] container) {
		Queue<토마토2.Point3D> qu = new LinkedList<토마토2.Point3D>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (container[i][j][k] == 1) {
						토마토2.Point3D point3D = new 토마토2.Point3D(i+1, j, k);
						qu.add(point3D);
					}
				}
			}
		}
		
		while (!qu.isEmpty()) {
			토마토2.Point3D point3D = qu.poll();
			
			// 1층인 경우
			if (point3D.z == 1) {
				int currX = point3D.x;
				int currY = point3D.y;

				for (int i = 0; i < 4; i++) {
					int nextX = currX + moveX[i];
					int nextY = currY + moveY[i];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
						continue;

					if (container[0][nextY][nextX] != 0)
						continue;
					
					qu.add(new 토마토2.Point3D(1, nextY, nextX));
					container[0][nextY][nextX] = container[0][currY][currX] + 1;
				}
				
				if(container[1][currY][currX] == 0) {
					qu.add(new 토마토2.Point3D(2, currY, currX));
					container[1][currY][currX] = container[0][currY][currX] + 1;
				}
			}
			
			// H층인 경우
			else if(point3D.z == H){
				int currX = point3D.x;
				int currY = point3D.y;
				int currZ = point3D.z-1;
				
				for (int i = 0; i < 4; i++) {
					int nextX = currX + moveX[i];
					int nextY = currY + moveY[i];

					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
						continue;
					
					if (container[currZ][nextY][nextX] != 0)
						continue;
					
					qu.add(new 토마토2.Point3D(currZ+1, nextY, nextX));
					container[currZ][nextY][nextX] = container[currZ][currY][currX] + 1;
				}
				
				if(container[currZ-1][currY][currX] == 0) {
					qu.add(new 토마토2.Point3D(currZ, currY, currX));
					container[currZ-1][currY][currX] = container[currZ][currY][currX] + 1;
				}

			}
			
			// 2층 ~ H-1층인 경우
			else {
				int currX = point3D.x;
				int currY = point3D.y;
				int currZ = point3D.z-1;
				
				for (int i = 0; i < 4; i++) {
					int nextX = currX + moveX[i];
					int nextY = currY + moveY[i];
					
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
						continue;
					
					if (container[currZ][nextY][nextX] != 0)
						continue;
					
					qu.add(new 토마토2.Point3D(currZ+1, nextY, nextX));
					container[currZ][nextY][nextX] = container[currZ][currY][currX] + 1;
				}
				
				if(container[currZ+1][currY][currX] == 0) {
					qu.add(new 토마토2.Point3D(currZ+2, currY, currX));
					container[currZ+1][currY][currX] = container[currZ][currY][currX] + 1;
				}
				if(container[currZ-1][currY][currX] == 0) {
					qu.add(new 토마토2.Point3D(currZ, currY, currX));
					container[currZ-1][currY][currX] = container[currZ][currY][currX] + 1;
				}
				
			}
			
		}
		
		int minDay = 0;
		
		outer: for (int[][] arr2D : container) {
			for (int[] arr : arr2D) {
				for (int num : arr) {
					if (num == 0) {
						minDay = 0;
						break outer;
					}
					minDay = Math.max(minDay, num);
				}
			}
		}
		
		System.out.println(minDay-1);
	}

	static void printContainer(int[][][] container) {
		System.out.println();
		for (int[][] arr2D : container) {
			for (int[] arr : arr2D) {
				for (int num : arr) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
	}

}
