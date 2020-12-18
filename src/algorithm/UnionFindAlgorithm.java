package algorithm;

public class UnionFindAlgorithm {
	
	//union연산을 수행하는 메서드
	public static void unionParent(int[] arr, int a, int b) {
		
		//aNode와 bNode의 부모Node를 찾음.
		a = getParent(arr, a);
		b = getParent(arr, b);
		
		//aNode와 bNode의 부모Node 중에서 작은값을 큰값의 부모Node로 저장함.
		if(a < b) {
			arr[b] = a;
		} else {
			arr[a] = b;
		}
	}
	
	//특정 node의 부모 정점을 찾는 메서드
	public static int getParent(int[] arr, int x) {
		
		if(arr[x] != x) {
			arr[x] = getParent(arr, arr[x]);
		}
		return arr[x];
	}
	
	//두 Node가 연결되어 있는지 확인하는 메서드
	public static void findParent(int[] arr, int a, int b) {
		
		//aNode와 bNode의 부모Node를 찾음.
		a = getParent(arr, a);
		b = getParent(arr, b);
		
		//aNode와 bNode의 부모노드가 같다면 연결되어 있으면 1, 아니면 0으로 표현
		System.out.println(a == b ? 1 : 0);
	}
	

	public static void main(String[] args) {
		int[] arr = new int[11];
		
		//최조의 정점은 자기 자신이 부모 정점이 된다.
		for (int i = 1; i < arr.length; i++) 
			arr[i] = i;
		
		unionParent(arr, 1, 2);
		unionParent(arr, 2, 3);
		unionParent(arr, 3, 4);
		unionParent(arr, 5, 6);
		unionParent(arr, 6, 7);
		unionParent(arr, 7, 8);
		unionParent(arr, 1, 7);
		
		findParent(arr, 1, 5);
	}
}	
