package algorithm;
public class DFSAlgorithm {
	
	static int N;
	static int E;
	static int[][] ad;
	static boolean[] visit;
	
	public static void dfs(int i) {
		
		visit[i] = true;
		System.out.print(i + " -> ");
		
		for(int j=1; j<=N; j++) {
			
			if(ad[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) {
		N = 6;
		E = 16;
		ad = new int[N+1][N+1];
		visit = new boolean[N+1];
		int[][] graph = new int[][] {
			{1,5},
			{1,6},
			{2,3},
			{2,4},
			{2,6},
			{3,4},
			{3,5},
			{5,6}
		};
	
		for(int i=0; i<graph.length; i++) {
			
			int a = graph[i][0];
			int b = graph[i][1];
			
			ad[a][b] = ad[b][a] = 1;
			
		}
		
		dfs(1);
		
	}

}
