package 프로그래머스;
import java.util.*;

public class StringZip {

	public static void main(String[] args) {
		
		String s = "aabbacccd";
		
		int arrSize = 0;
		int cnt = 1;
		int answer = 9999;
		
		if(s.length() == 1) {
			
			answer = 1;
		} 
		else {
			
			while(cnt<=s.length()/2) {
				
				String[] tmp;
				String ansStr = "";
				int next = 0;
				
				if(s.length() % cnt != 0) {
					arrSize = s.length() / cnt + 1;
					tmp = new String[arrSize];
				} else {
					arrSize = s.length() / cnt;
					tmp = new String[arrSize];
				}
				
				for(int i=0; i<s.length(); i+=cnt) {
					if(i + cnt <= s.length()) {
						
						tmp[next++] = s.substring(i, i + cnt);
					} else {
						
						tmp[next] = s.substring(i);
					}
				}
				
				int num = 1;
				String compStr = "";
				
				for(int i=0; i<tmp.length-1; i++) {
					
					compStr = tmp[i];
					
					if(compStr.equals(tmp[i+1])){
						if(i == tmp.length-2) {
							num++;
							ansStr += num + compStr;
						}else {
							
							num++;
						}
					} else {
						
						if(i == tmp.length-2) {
							
							if(num == 1) {
								
								ansStr += compStr;
								ansStr += tmp[i+1];
							}
							else {
								
								ansStr += num + compStr;
								ansStr += tmp[i+1];
							}
						}
						else if(num == 1) {
							
							ansStr += compStr;
						}
						else {
							
							ansStr += num + compStr;
							num = 1;
						}
					}
					
				}
				
				if(answer>=ansStr.length()) answer = ansStr.length();
				
				cnt++;
				
			}
		}
		
		System.out.println("answer: " + answer);
	}

}
