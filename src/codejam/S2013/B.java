package codejam.S2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class B {

	static final String TYPE = "B";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	
	static int rx = 0;
	static int ry = 0;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/S2013";

		// Test
		Name("B-small-practice");

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			min = Integer.MAX_VALUE;
			int B = in.nextInt();
			
			int[] x1 = new int[B];
			int[] y1 = new int[B];
			int[] x2 = new int[B];
			int[] y2 = new int[B];
			
			for(int j=0;j<B;j++){
				x1[j] = in.nextInt();
				y1[j] = in.nextInt();
				x2[j] = in.nextInt();
				y2[j] = in.nextInt();
			}
			
			for (int j = 0; j < B; j++) {
				for(int xx=x1[j];xx<=x2[j];xx++){
					for(int yy=y1[j];yy<=y2[j];yy++){
						int d = findD(xx,yy,B, x1,y1,x2,y2);
						System.out.println("xx:" + xx + ",yy:" + yy +",d:"+d);
						if(d<min){
							min = d;
							rx = xx;
							ry = yy;
						}else if(d==min){
							if(xx<rx||(xx==rx&&yy<ry)){
								min = d;
								rx = xx;
								ry = yy;
							}
						}
					}
				}
			}
			
			
			out.println("Case #" + (i + 1) + ": "+rx+" "+ry+" "+min);

		}

		in.close();
		out.close();

	}
	
	public static int findD(int x, int y, int B, int[] x1, int[]y1, int[]x2, int[]y2 ){
		int d=0;
		for (int j = 0; j < B; j++) {
			for(int xx=x1[j];xx<=x2[j];xx++){
				for(int yy=y1[j];yy<=y2[j];yy++){
					d += Math.abs(x-xx)+Math.abs(y-yy);
				}
			}
		}
		return d;
	}

}
