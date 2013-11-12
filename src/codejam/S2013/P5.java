package codejam.S2013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class P5 {

	/**
	 * @param args
	 */
	
	public static String inputfile = "data/S2013/E-small-attempt1.in";
	public static String output = "output";
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(inputfile)));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(output)));
		StringBuffer input = new StringBuffer();
		String line = null;
		line = bufferedReader.readLine();
		while (line!=null){
			input.append(line+"\n");
			line = bufferedReader.readLine();
		}
		//process
		Stack<Integer> start = new Stack<Integer>();
		for (int i = 0; i<input.length()-1; i++){
			if (input.charAt(i) == '/' && input.charAt(i+1) == '*'){
				start.push(i);
				i += 2;
			}
			if (input.charAt(i) == '*' && input.charAt(i+1) == '/' && (!start.isEmpty())){
				int end = ++i;
				int s = start.pop();
				input.replace(s, end+1, "");
				i = s;
			}
		}
		System.out.println(input.toString());
		bufferedWriter.write("Case #1:\n"+input.toString());
		bufferedWriter.close();
		bufferedReader.close();
		
	}

}
