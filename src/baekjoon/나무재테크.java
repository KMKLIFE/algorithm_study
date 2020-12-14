package baekjoon;

import java.io.*;
import java.util.*;

public class 나무재테크 {

	// N:땅의 크기 M:묘목 개수 K:재테크 년수
	static int N;
	static int M;
	static int K;

	static int[] moveX = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] moveY = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] land;
	static int[][] food;
	static ArrayList[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nmk = br.readLine();
		StringTokenizer st = new StringTokenizer(nmk);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		land = new int[N][N];
		tree = new ArrayList[N][N];
		food = new int[N][N];

		for (int i = 0; i < N; i++) {
			String arr = br.readLine();
			String[] resultStr = arr.split(" ");
			for (int j = 0; j < resultStr.length; j++) {
				food[i][j] = Integer.parseInt(resultStr[j]);
			}
		}

		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land.length; j++) {
				land[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			String treeLoc = br.readLine();
			st = new StringTokenizer(treeLoc);
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<>();
			list.add(c);
			tree[a][b] = list;
		}

		for (int year = 0; year < K; year++) {

			// spring, summer
			for (int i = 0; i < tree.length; i++) {
				for (int j = 0; j < tree.length; j++) {
					if (tree[i][j] != null) {
						if (tree[i][j].size() > 1) {
							for (int k = tree[i][j].size() - 1; k >= 0; k--) {
								int num = (int) tree[i][j].get(k);
								if (land[i][j] - num >= 0) {
									land[i][j] -= num;
									tree[i][j].set(k, num + 1);
								} else {
									for (int l = k; l >= 0; l--) {
										land[i][j] += (int) tree[i][j].get(l) / 2;
										tree[i][j].remove(l);
									}
									if(tree[i][j].isEmpty()) 
										tree[i][j] = null;
									break;
								}
							}
						} else if (tree[i][j].size() == 1) {
							int num = (int) tree[i][j].get(0);
							if (land[i][j] - num >= 0) {
								land[i][j] -= num;
								tree[i][j].set(0, num + 1);
							} else {
								land[i][j] += num / 2;
								tree[i][j] = null;
							}
						}
					}
				}
			}

			// fall
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (tree[i][j] != null) {
						for (int k = 0; k < tree[i][j].size(); k++) {
							if ((int) tree[i][j].get(k) % 5 == 0) {
								for (int l = 0; l < 8; l++) {
									int nextX = j + moveX[l];
									int nextY = i + moveY[l];
									if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
										if (tree[nextY][nextX] == null) {
											ArrayList<Integer> list = new ArrayList<>();
											list.add(1);
											tree[nextY][nextX] = list;
										} else {
											tree[nextY][nextX].add(1);
										}
									}
								}
							}
						}
					}
				}
			}
			// winter
			for (int i = 0; i < food.length; i++) {
				for (int j = 0; j < food.length; j++) {
					land[i][j] += food[i][j];
				}
			}

		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tree[i][j] != null)
					answer += tree[i][j].size();
			}
		}
		
		System.out.println(answer);
		br.close();
	}

}