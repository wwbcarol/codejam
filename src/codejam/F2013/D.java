package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D {
	
	static final String TYPE = "D";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		Name("D-large-practice");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			int N = in.nextInt();
			char[][] map = new char[N+2][N+2];
			for(int j=0;j<N+2;j++){
				if(j==0||j==N+1){
					for(int k=0;k<N+2;k++){
						map[j][k] = '#';
					}
				}else{
					String s = in.next();
					for(int k=0;k<N+2;k++){
						if(k==0||k==N+1) map[j][k] = '#';
						else map[j][k] = s.charAt(k-1);
					}
				}
			}
			
			int sx = in.nextInt();
			int sy = in.nextInt();
			int ex = in.nextInt();
			int ey = in.nextInt();
			
			int head;// up 0; right 1; down 2; left 3;
			if(sx == 1) head = 2;
			else head = 0;
			int count = 0;
			StringBuffer outString = new StringBuffer();
			boolean isFound = false;
			while(count<10000){
				head = go(head, sx, sy, map);
				count++;
				if(head == -1){
					break;
				}else{
					switch (head) {
					case 0:
						sx = sx - 1;
						outString.append("N");
						break;
					case 1:
						outString.append("E");
						sy = sy + 1;
						break;
					case 2:
						outString.append("S");
						sx = sx + 1;
						break;
					case 3:
						outString.append("W");
						sy = sy - 1;
						break;
					}
				}
				if(sx == ex&&sy==ey){
					isFound = true;
					break;
				}
			}
			if(isFound == true){
				out.println("Case #"+(i+1)+": "+count);
				out.println(outString.toString());
			}else{
				out.println("Case #"+(i+1)+": "+"Edison ran out of energy.");
			}
		}
		in.close();
		out.close();
	}
	
	private static int go(int head, int sx, int sy, char[][] map) {
		
		char left, front, right, down;
		if(head == 0){
			left = map[sx][sy-1];
			front = map[sx-1][sy];
			right = map[sx][sy+1];
			down = map[sx+1][sy];
		}else if(head == 1){
			left = map[sx-1][sy];
			front = map[sx][sy+1];
			right = map[sx+1][sy];
			down = map[sx][sy-1];
		}else if(head == 2){
			left = map[sx][sy+1];
			front = map[sx+1][sy];
			right = map[sx][sy-1];
			down = map[sx-1][sy];
		}else{
			left = map[sx+1][sy];
			front = map[sx][sy-1];
			right = map[sx-1][sy];
			down = map[sx][sy+1];
		}
		
		if(left != '#'){
			return (head+3)%4;
		}else if (left == '#' && front != '#') {
			return head;
		}else if(left == '#' && front == '#' && right != '#'){
			return (head+1)%4;
		}else if(left == '#' && front == '#' && right == '#'&& down != '#'){
			return (head+2)%4;
		}else{
			return -1;
		}
	}

}
