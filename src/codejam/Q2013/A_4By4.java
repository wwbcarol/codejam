package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_4By4 {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO data path
		String root = "data/Q2013";
		
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
			
			in.nextLine();
			boolean hasBlank = false;
			
			int[][] X = new int[4][4];
			int[][] O = new int[4][4];
			char c;
			for(int j=0;j<4;j++){
				String s = in.nextLine();
				for(int k=0;k<4;k++){
					c = s.charAt(k);
					if(c == '.') hasBlank = true;
					else if(c == 'X') X[j][k] = 1;
					else if(c == 'O') O[j][k] = 1;
					else{
						X[j][k] = 1;
						O[j][k] = 1;
					}
				}
			}
			
			out.print("Case #"+(i+1)+": ");
			
			if(hasWin(X)){
				// X win
				out.println("X won");
			}else if(hasWin(O)){
				// O win
				out.println("O won");
			}else if(hasBlank == true){
				//not com
				out.println("Game has not completed");
			}else{
				// draw
				out.println("Draw");
			}
			
			
			
			
			
			
		}
		
		in.close();
		out.close();

	}
	
	private static boolean hasWin(int[][] X){
		for(int i=0;i<4;i++){
			if(X[i][0]+X[i][1]+X[i][2]+X[i][3] == 4)
				return true;
			if(X[0][i]+X[1][i]+X[2][i]+X[3][i] == 4)
				return true;
		}
		if(X[0][0]+X[1][1]+X[2][2]+X[3][3] == 4)
			return true;
		if(X[0][3]+X[1][2]+X[2][1]+X[3][0] == 4)
			return true;
	
		return false;
	}
}
