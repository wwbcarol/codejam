package codejam.Q2011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_BotTrust {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2011";
		
		// Test
		
//		String inputFile = "A-in.txt";
//		String outputFile = "A-out.txt";
		
		// Small
		
//		String inputFile = "A-small-practice.in";
//		String outputFile = "A-small-practice.out";
		
		
		// Large
		
		String inputFile = "A-large-practice.in";
		String outputFile = "A-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			
			int[] Sequence = new int[N];
			
			int preO = 1;
			int preB = 1;
			for(int j=0;j<N;j++){
				String c = in.next();
				int n = in.nextInt();
				
				if(c.equals("O")){
					Sequence[j] = Math.abs(n-preO)+1;
					preO = n;
				}else{
					Sequence[j] = -(Math.abs(n-preB)+1);
					preB = n;
				}
				
			}
			
			int pre = Math.abs(Sequence[0]);
			int sum = pre;
			for(int j=1;j<N;j++){
				
				
				if(Sequence[j-1]*Sequence[j]<0){
					sum += Math.abs(Sequence[j])-pre > 1? Math.abs(Sequence[j])-pre:1;
					pre = Math.abs(Sequence[j])-pre > 1? Math.abs(Sequence[j])-pre:1;
				}else{
					pre += Math.abs(Sequence[j]);
					sum += Math.abs(Sequence[j]);
				}
			}
			
			out.println("Case #"+(i+1)+": "+sum);
			
		}
		
		in.close();
		out.close();

	}

}
