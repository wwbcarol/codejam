package codejam.Q2009;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		String root = "data/Q2009";
		
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
		
		int L = in.nextInt();
		int D = in.nextInt();
		int N = in.nextInt();
		
		String[] dic = new String[D];
		
		in.nextLine();
		for(int i=0;i<D;i++){
			dic[i] = in.nextLine();
		}
		
		boolean isOneChar;
		
		for(int i = 0;i<N;i++){
			int count = 0;
			String word = in.nextLine();
			
			isOneChar = true;
			
			int index = 0;
			StringBuilder[] each = new StringBuilder[L];
			
			for(int j = 0;j<L;j++){
				each[j] = new StringBuilder();
			}
			
			for(int j = 0;j<word.length();j++){
				if(word.charAt(j) == '('){
					index++;
					isOneChar = false;
					continue;
				} else if(word.charAt(j) == ')'){
					isOneChar = true;
					continue;
				} else {
					
					if(isOneChar == true)
						index++;
					each[index - 1].append(word.charAt(j));
				}
			}
			
			
			boolean isExist;
			
			for(int j=0;j<D;j++){
				isExist = true;
				for(int k=0;k<L;k++){
					if(each[k].toString().indexOf(dic[j].charAt(k))<0){
						isExist = false;
						break;
					}
				}
				
				if(isExist == true)
					count++;
			}
			
			out.println("Case #"+(i+1)+": "+count);
		}
		
		
		in.close();
		out.close();

	}

}
