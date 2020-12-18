package algorithm;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class A implements Comparable<A>{
	int from;
	int to;
	int weight;

	public A(int from, int to, int weight) {
		this.to = to;
		this.from = from; 
		this.weight = weight;
	}
	
	@Override
	public int compareTo(A o) {
		return this.weight >= o.weight ? 1 : -1;
	}

}


public class KruskalAlgorithm {
	
	//node�� �θ��带 ã�� �޼���
	public static int findParent(int a) {
		
		if(a == parent[a]) return a;
		parent[a] = findParent(parent[a]);
		
		return parent[a];
	}
	
	public static void union(int a, int b) {
		
		int aRoot = findParent(a);  //a�� �ֻ��� �θ��� Ž��
		int bRoot = findParent(b);  //b�� �ֻ��� �θ��� Ž��
		
		//a�� b�� �ֻ��� ��尡 �ٸ� ��� aRoot�� �ֻ��� ��带 b�� ����
		if(aRoot != bRoot) {
			parent[aRoot] = b;
		} 
		
		//�θ� ���� ���
		else {
			return;
		}
	}
	
	static int N; //node
	static int E; //arc
	static PriorityQueue<A> pq; //���� ���� Min Heap���� �ϴ� �켱���� ť
	static int[] parent;  //disjoint-set(union find)���� �ʿ��� �θ� ��带 �����ϴ� �迭
	static int result;  //����� ����
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = 9;
		E = 14;
		
		parent = new int[N]; //Disjoint-set
		result = 0;
		
		pq = new PriorityQueue<A>();
		
		int[][] graph = new int[][] {
			{0,1,3},
			{0,7,8},
			{1,2,8},
			{1,7,11},
			{2,3,7},
			{2,5,4},
			{2,8,2},
			{3,4,9},
			{3,5,14},
			{4,5,10},
			{5,6,2},
			{6,7,1},
			{6,8,6},
			{7,8,7}
		};
		
		
		//��� arc�� ���Ͽ� [to, from, cost]�� ���� Ŭ������ �켱���� ť�� add
		for(int i=0; i<graph.length; i++) {
			pq.add(new A(graph[i][0], graph[i][1], graph[i][2]));
		}
		
		//�ڱ� �ڽ��� �ֻ��� node�� �ʱ�ȭ
		for(int i=0; i<N; i++) { 
			parent[i] = i;
		
		}	
		
		for(int i=0; i<E; i++) {
			
			A minNode = pq.poll();  //���� ť�� �ִ� ��� �ν��Ͻ� �� weight�� ���� ���� ������ ����.
		
			System.out.println(minNode.from + " " + minNode.to + " " + minNode.weight);
			
			int from = minNode.from;
			int to = minNode.to;
			
			int a = findParent(from);
			int b = findParent(to);
			
			//a�� b�� root node�� ���� ��� continue
			if(a == b) continue;
		
			//a��  b�� root node�� �ٸ� ��� from�� to�� �ֻ��� node�� ����
			union(from, to); 
			result += minNode.weight;
		}
		
		System.out.println(result);
	}
}


