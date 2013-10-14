package codejam.S2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class A {

	static final String TYPE = "A";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/S2013";

		// Test
		Name("A-large");

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			int N = in.nextInt();
			
			int[][] map = new int[N*N][N*N];
			
			
			
			for(int j=0;j<N*N;j++){
				for(int k=0;k<N*N;k++){
					map[j][k] = in.nextInt();
				}
			}
			
			out.print("Case #" + (i + 1) + ": ");
			if(isValidSUdoku(map, N)) out.println("Yes");
			else out.println("No");

		}

		in.close();
		out.close();

	}
	
	public static boolean isValidSUdoku(int[][] map, int N){
		
		HashSet<Integer> checklist = new HashSet<Integer>();
		// row
		for(int i=0;i<N*N;i++){
			checklist.clear();
			for(int j=0;j<N*N;j++){
				if(checklist.contains(map[i][j])||!(map[i][j]>=1&&map[i][j]<=N*N)){
					return false;
				}
				else checklist.add(map[i][j]);
			}
		}
		
		// column
		for(int j=0;j<N*N;j++){
			checklist.clear();
			for(int i=0;i<N*N;i++){
				if(checklist.contains(map[i][j])||!(map[i][j]>=1&&map[i][j]<=N*N)){
					return false;
				}
				else checklist.add(map[i][j]);
			}
		}
		
		for(int i=0;i<N*N;i+=N){
			for(int j=0;j<N*N;j+=N){
				if(!check(map, N, i, j))return false;
			}
		}
		
		return true;
	}
	
	public static boolean check(int[][] map, int N, int i, int j){
		HashSet<Integer> checklist = new HashSet<Integer>();
		for(int k=i;k<=i+N-1;k++){
			for(int t=j;t<=j+N-1;t++){
				if(checklist.contains(map[k][t])||!(map[k][t]>=1&&map[k][t]<=N*N)){
					System.out.println("block");
					return false;
				}
				else checklist.add(map[k][t]);
			}
		}
		return true;
	}

}
