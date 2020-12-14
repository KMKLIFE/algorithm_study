package programmers;

public class 목표숫자 {

	public int dfs(int[] numbers, int node, int sum, int target) {

		if (node == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}
		return dfs(numbers, node+1, sum + numbers[node], target)
				+ dfs(numbers, node+1, sum - numbers[node], target);
	}

	public static void main(String[] args) {

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		int answer = 0;
		
		answer = new 목표숫자().dfs(numbers, 0, 0, target);

		System.out.println(answer);

	}

}
