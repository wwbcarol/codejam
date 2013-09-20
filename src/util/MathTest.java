package util;

import java.util.ArrayList;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(solve(9, 1));
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
