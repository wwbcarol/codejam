package util;

import java.util.ArrayList;
import java.util.Arrays;

public class MathTest {

	public static void main(String[] args) {
//		Integer[] a = new Integer[]{2,3,-1, 5};
//		U.<Integer>da(a);
//		Arrays.sort(a);
//		U.<Integer>da(a);
		
	}
	
	

	public static int solve(int A, int B){
		int power = 1, temp = A;
		while(temp >= 10){
			power *= 10;
			temp /= 10;
		}
		
		int result = 0;
		for(int n=A; n<=B; n++){
			temp = n;
			while(true){
				temp = (temp/10) +((temp%10)*power);
				if(temp == n)
					break;
				if(temp>n && temp<=B)
					result++;
			}
		}
		
		return result;
	}
}
