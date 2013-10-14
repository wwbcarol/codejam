package codejam.H2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class C {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/H2013";
		
		// Test
		
//		String inputFile = "C-in.txt";
//		String outputFile = "C-out.txt";
		
		// Small
		
//		String inputFile = "C-small-1-attempt1.in";
//		String outputFile = "C-small-1-attempt1.out";
		
		
		// Large
		
		String inputFile = "C-small-2-attempt0.in";
		String outputFile = "C-small-2-attempt0.out";
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			
			in.nextLine();
			ArrayList<String> list = new ArrayList<String>();
			
			for(int j=0;j<N;j++){
				
				list.add(in.nextLine());
				
			}
			
			
			
			int num = 0;
			
			while(!list.isEmpty()){
				
				String bottom = list.get(0);
				ArrayList<String> tmp = new ArrayList<String>();
				for(int j=1;j<list.size();j++){
					if((list.get(j)).compareTo(bottom)>0){
						bottom = list.get(j);
						tmp.add(list.get(j));
					}else{
						num++;
					}
				}
				list = (ArrayList<String>) tmp.clone();
			}
			
			
			
			out.println("Case #"+(i+1)+": "+num);
			
		}
		
		in.close();
		out.close();

	}

}
