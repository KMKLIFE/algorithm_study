package SWEA;
import java.io.*;

class 홀수만_더하기 {
	public static void main(String args[]) throws Exception {
		
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] answer = new int[T];
        
        for(int i=0; i<T; i++){
            int sum = 0;
        	String str = br.readLine();
            String[] numArr = str.split(" ");
            
            for(int j=0; j<numArr.length; j++){
            	if(Integer.parseInt(numArr[j]) % 2 != 0){
                	sum += Integer.parseInt(numArr[j]);
                }
            }
            answer[i] = sum;
        }
        
        int cnt = 1;
        for(int num : answer){
        	System.out.println("#" + cnt++ + " " + num);
        }
	}
}