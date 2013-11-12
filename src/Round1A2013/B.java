package Round1A2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	
	static final String TYPE = "B";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/R1A2013";
		
		// Test
		Name("B-test");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
//			int E = in.nextInt();
//			int R = in.nextInt();
			int N = in.nextInt();
			
			Integer[] V = new Integer[N];
			for(int j=0;j<N;j++){
				V[j] = in.nextInt(); 
			}
			
//			Arrays.sort(V, Collections.reverseOrder());


			
////			max = Integer.MIN_VALUE;
////			rec(V, 0, E, E, R, 0);
//
//			
//			out.println("Case #"+(i+1)+": "+max(V, 0, E, E, R));
			
			
			out.print("Case #"+(i+1)+": ");
			
			
			
		}
		
		in.close();
		out.close();

	}
	
//	static int max;
	
//	public static void rec(Integer[] V, int index, int init, int E, int R, int value){
//		if(index == V.length-1){
//			
//			if(value+init*V[index]>max) max = value+init*V[index];
//			
//			return;
//		}
//		
//		for(int i=0;i<=init;i++){
//			int newinit = init-i+R>E?E:init-i+R;
//			rec(V, index+1, newinit, E, R, value+i*V[index]);
//		}
//		
//		return;
//		
//	}
//	
//	public static int max(Integer[] V, int index, int init, int E, int R){
//		if(index == V.length-1){
//			return init*V[index];
//		}
//		else {
//			int m = Integer.MIN_VALUE;
//			for(int i=0;i<=init;i++){
//				int tmp = V[index]*i+max(V, index+1, init-i+R>E?E:init-i+R, E, R);
//				if(tmp>m){
//					m = tmp;
//				}
//			}
//			return m;
//		}
//	}

}
