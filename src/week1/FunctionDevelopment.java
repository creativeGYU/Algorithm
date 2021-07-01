package week1;

import java.util.Arrays;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] day0fend = new int[100];
	    int day = -1;
	    
	    for (int i = 0; i < progresses.length; i++) {
	    	while(progresses[i] + (day*speeds[i]) < 100) {
	    		day++;
	        }
	    	day0fend[day]++;
	    } 
	        return Arrays.stream(day0fend).filter(i -> i!=0).toArray();
	}
}
