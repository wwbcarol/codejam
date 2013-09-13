package codejam.Q2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A_LetterMapping {

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2012";
		
		// Test
		
		String sampleIn = "sample_in.txt";
		String sampleOut = "sample_out.txt";
		
		// Small
		
		String inputFile = "A-small-practice.in";
		String outputFile = "A-small-practice.out";
		
		
		Scanner sample_in = new Scanner(new File(root, sampleIn));
		Scanner sample_out = new Scanner(new File(root, sampleOut));
		
		char[] dic = new char[26];
		
		for(int i=0;i<26;i++){
			dic[i] = '*';
		}
		
		dic['a'-'a'] = 'y';
		dic['o'-'a'] = 'e';
		dic['z'-'a'] = 'q';
		int n = sample_in.nextInt();
		sample_in.nextLine();
		for(int i = 0;i<n;i++){
			
			String in = sample_in.nextLine();
			String out = sample_out.nextLine();
			
			for(int j = 0;j<in.length();j++){
				if(in.charAt(j) != ' '){
					dic[in.charAt(j)-'a'] = out.charAt(j);
				}
			}
		}
		
		sample_in.close();
		sample_out.close();
		
		char[] findLastOne = new char[26];
		int index = 0;
		for(int i = 0;i<26;i++){
			findLastOne[i] = (char) ('a'+i);
		}
		
		for(int i=0;i<26;i++){
			if(dic[i] == '*') index = i;
			else{
				findLastOne[dic[i]-'a'] = '*';
			}
		}
		for(int i=0;i<26;i++){
			if(findLastOne[i] !='*')dic[index] =  findLastOne[i];
		}
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		// TODO T cases
		int T = in.nextInt();
		in.nextLine();
		for(int i=0;i<T;i++){
			
			String inString = in.nextLine();
			out.print("Case #"+(i+1)+": ");
			for(int j = 0;j<inString.length();j++){
				if(inString.charAt(j) != ' '){
					out.print(dic[inString.charAt(j)-'a']);
				}else{
					out.print(' ');
				}
			}
			
			out.println("");
			
			
			
			
		}
		
		in.close();
		out.close();

	}

}
