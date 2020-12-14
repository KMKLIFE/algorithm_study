package programmers;

public class 스킬트리 {

	public static void main(String[] args) {
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		String skill = "CBD";
		int answer = skill_trees.length;
		int beforeIdx = 0, currentIdx = 0;
		
		for (int i = 0; i < skill_trees.length; i++) {
			beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
			
			for (int j = 1; j < skill.length(); j++) {
				currentIdx = skill_trees[i].indexOf(skill.charAt(j));
				
				if((beforeIdx > currentIdx && currentIdx != -1) || (beforeIdx == -1 && currentIdx != -1)) {
					answer--;
					break;
				}
				
				beforeIdx = currentIdx;
			
			}
		}
		
		System.out.println(answer);
	
	}

}
