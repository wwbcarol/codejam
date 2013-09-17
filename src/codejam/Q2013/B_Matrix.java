package codejam.Q2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import util.U;

public class B_Matrix {

	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/Q2013";
		
		// Test
		
		String inputFile = "B-in.txt";
		String outputFile = "B-out.txt";
		
		// Small
		
//		String inputFile = "B-small-practice.in";
//		String outputFile = "B-small-practice.out";
		
		
		// Large
		
//		String inputFile = "B-large-practice.in";
//		String outputFile = "B-large-practice.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			Integer[][] map = new Integer[N][M];
			Integer[][] mine = new Integer[N][M];
			for(int j=0;j<N;j++){
				for(int k=0;k<M;k++){
					map[j][k] = in.nextInt();
					mine[j][k] = 100;
				}
			}
			
			U.PI(i);
			U.<Integer>daa(map);
			
			boolean isChanged;
			do{
				isChanged = false;
				for(int j=0;j<N;j++){
					int max = map[j][0];
					for(int k=0;k<M;k++){
						if(map[j][k]>max)
							max = map[j][k];
					}
					
					for(int k=0;k<M;k++){
						if(mine[j][k]>max){
							isChanged = true;
							mine[j][k] = max;
						}
					}
				}
				
				for(int k=0;k<M;k++){
					int max = map[0][k];
					for(int j=0;j<N;j++){
						if(map[j][k]>max)
							max = map[j][k];
					}
					
					for(int j=0;j<N;j++){
						if(mine[j][k]>max){
							isChanged = true;
							mine[j][k] = max;
						}
					}
				}
			}while(!Arrays.deepEquals(map, mine)&&isChanged);
			
			String result = Arrays.deepEquals(map, mine)?"YES":"NO";
			System.out.println(result);
			out.println("Case #"+(i+1)+": "+ result);
			
		}
		
		in.close();
		out.close();

	}

}
