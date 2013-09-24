package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A {
	
	static final String TYPE = "A";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		// Test
//		Name(TYPE+"-test");
		// Small
		Name("A-large");
		// Large
//		Name(TYPE+"-large-practice");
		
//		Name(TYPE+"--small-1-attempt0");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		HashMap<Integer, String> number = new HashMap<Integer, String>();
		number.put(0, "zero");
		number.put(1, "one");
		number.put(2, "two");
		number.put(3, "three");
		number.put(4, "four");
		number.put(5, "five");
		number.put(6, "six");
		number.put(7, "seven");
		number.put(8, "eight");
		number.put(9, "nine");
		
		HashMap<Integer, String> cMap = new HashMap<Integer, String>();
		cMap.put(2, "double");
		cMap.put(3, "triple");
		cMap.put(4, "quadruple");
		cMap.put(5, "quintuple");
		cMap.put(6, "sextuple");
		cMap.put(7, "septuple");
		cMap.put(8, "octuple");
		cMap.put(9, "nonuple");
		cMap.put(10, "decuple");
		
		for(int i=0;i<T;i++){
			
			String s = in.next();
			String format = in.next();
			
			ArrayList<Integer> nFormat = new ArrayList<Integer>();
			
			StringBuffer sb = new StringBuffer();
			for(int j=0;j<format.length();j++){
				
				if(format.charAt(j)!='-'){
					sb.append(format.charAt(j));
				}else{
					nFormat.add(Integer.parseInt(sb.toString()));
					sb = new StringBuffer();
				}
			}
			nFormat.add(Integer.parseInt(sb.toString()));
			
//			System.out.println(i+1+"："+ s + "," + format);
			int count=0;
			out.print("Case #"+(i+1)+": ");
			for(int j=0;j<nFormat.size();j++){
				
				int n = nFormat.get(j);
				
				int c = 1;
				int preN = -1;
//				System.out.println("n:" + n);
				for(int k=count;k<n+count;k++){
					int curN = s.charAt(k)-'0';
					if (curN == preN) {
						c++;
					}else{
//						System.out.println("else:" + preN + "," + curN+","+c);
						if(preN!=-1){
							if(c>=2&&c<=10){
								out.print(cMap.get(c)+" "+number.get(preN));
							}else if(c>10){
								for(int t=0;t<c-1;t++){
									out.print(number.get(preN)+" ");
								}
								out.print(number.get(preN));
							}else{
								out.print(number.get(preN));
							}
							out.print(" ");
							c=1;
						}
					}
					
					preN = curN;
				}
				
				if(c>=2&&c<=10){
					out.print(cMap.get(c)+" "+number.get(preN));
				}else if(c>10){
					for(int t=0;t<c-1;t++){
						out.print(number.get(preN)+" ");
					}
					out.print(number.get(preN));
				}else{
					out.print(number.get(preN));
				}
				out.print(" ");
				count += n;
				;
			}
			out.println("");
			
			
			
			
		}
		
		in.close();
		out.close();

	}

}
