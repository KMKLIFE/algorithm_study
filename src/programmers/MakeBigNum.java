package 프로그래머스;

public class MakeBigNum {

	public static void main(String[] args) {
		String answer = "";
		String number = "4177252841";
        int k = 4;
        StringBuilder a = new StringBuilder(number);
        int i = 0;
        int j = 0;
        int idx;
        int l;

        for (i = 0; i < k; i++) {
            l=a.length();
            idx = l - 1;
            for (j = 0; j < l - 1; j++) {
                if (a.charAt(j) < a.charAt(j + 1)) {
                    idx = j;
                    break;
                }
            }

            a.deleteCharAt(idx);
        }
        
        System.out.println(a.toString());

    }
//        powerset(str, state, 0, str.length);

	public static void powerset(String[] arr, boolean[] state, int d, int end) {
		if (d == end) {
			for (int i = 0; i < end; i++) {
				if (state[i] = true) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}

		// 내가 없을때
		state[d] = false;
		powerset(arr, state, d + 1, end);
		// 내가 있을때
		state[d] = true;
		powerset(arr, state, d + 1, end);
	}

}
