package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class E {
	
	static final String TYPE = "E";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		// Test
		Name(TYPE+"-test");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int N = in.nextInt();
			
			HashMap<String, ArrayList<Integer>> tele = new HashMap<String, ArrayList<Integer>>();
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			for(int j=0;j<N;j++){
				String s = in.next();
				map.put(j+1, s);
				if(!tele.containsKey(s)){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(j+1);
					tele.put(s, list);
				}else{
					tele.get(s).add(j+1);
				}
			}
			
			for(int j=0;j<tele.size();j++){
				
				ArrayList<Integer> list = tele.get(j);
				
				for(int k=0;k<list.size();k++) System.out.print(list.get(k));
				
				System.out.println("");
			}
			
			int M = in.nextInt();
			
			
			
			out.print("Case #"+(i+1)+": ");
			
			
			
			
		}
		
		in.close();
		out.close();

	}

}
