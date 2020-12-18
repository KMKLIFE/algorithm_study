package algorithm;

public class UnionFindAlgorithm {
	
	//union������ �����ϴ� �޼���
	public static void unionParent(int[] arr, int a, int b) {
		
		//aNode�� bNode�� �θ�Node�� ã��.
		a = getParent(arr, a);
		b = getParent(arr, b);
		
		//aNode�� bNode�� �θ�Node �߿��� �������� ū���� �θ�Node�� ������.
		if(a < b) {
			arr[b] = a;
		} else {
			arr[a] = b;
		}
	}
	
	//Ư�� node�� �θ� ������ ã�� �޼���
	public static int getParent(int[] arr, int x) {
		
		if(arr[x] != x) {
			arr[x] = getParent(arr, arr[x]);
		}
		return arr[x];
	}
	
	//�� Node�� ����Ǿ� �ִ��� Ȯ���ϴ� �޼���
	public static void findParent(int[] arr, int a, int b) {
		
		//aNode�� bNode�� �θ�Node�� ã��.
		a = getParent(arr, a);
		b = getParent(arr, b);
		
		//aNode�� bNode�� �θ��尡 ���ٸ� ����Ǿ� ������ 1, �ƴϸ� 0���� ǥ��
		System.out.println(a == b ? 1 : 0);
	}
	

	public static void main(String[] args) {
		int[] arr = new int[11];
		
		//������ ������ �ڱ� �ڽ��� �θ� ������ �ȴ�.
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
