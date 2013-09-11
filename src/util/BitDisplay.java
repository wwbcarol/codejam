package util;

public class BitDisplay {

	public static void display(int number){
		
		System.out.print(number + "\t");
		
		for(int i=31;i>=0;i--){
			if( ((1 << i)&number)!=0)
				System.out.print(1);
			else
				System.out.print(0);
			
			if((i%4)==0)
				System.out.print(" ");
		}
		
		System.out.println("");
	}
}
