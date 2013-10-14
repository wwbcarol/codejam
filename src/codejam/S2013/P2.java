package codejam.S2013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class P2 {
	
	public static class Rec{
		public int x1;
		public int x2;
		public int y1;
		public int y2;
		public Rec(int x1, int y1,int x2, int y2){
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		
	}
	public static String inputfile = "data/S2013/B-small-attempt2.in";
	public static String output = "output";
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(inputfile)));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(output)));
		String line = null;
		line = bufferedReader.readLine();
		int caseNum = Integer.parseInt(line);
		
		for (int i = 0 ; i < caseNum; i++){
			int B = Integer.parseInt(bufferedReader.readLine());
			Rec[] recs = new Rec[B];
			for (int j = 0; j < B; j++){
				line = bufferedReader.readLine();
				String[] items = line.split(" ");
				recs[j] = new Rec(Integer.parseInt(items[0]), Integer.parseInt(items[1]), 
						Integer.parseInt(items[2]), Integer.parseInt(items[3]));
			}
			
			int min = Integer.MAX_VALUE;
			int min_x = 0;
			int min_y = 0;
			
			for (int j = 0; j < B; j++){
				for (int x = recs[j].x1; x <= recs[j].x2; x++){
					for (int y = recs[j].y1; y <= recs[j].y2; y++){
						int cost = 0;
						for (int j0 = 0; j0 < B; j0++){
							for (int x0 = recs[j0].x1; x0 <= recs[j0].x2; x0++){
								for (int y0 = recs[j0].y1; y0 <= recs[j0].y2; y0++){
									cost+= Math.abs(x0-x) + Math.abs(y0-y);
								}
							}
						}
						if (min> cost){
							min = cost;
							min_x = x;
							min_y = y;
						}
					}
				}
			}
			
//			System.out.println(min_x+" "+ min_y +" "+ min);
			bufferedWriter.write("Case #" +(i+1) + ": " + min_x +" "+ min_y +" "+ min + "\n");
		}
		//process
		
		
		bufferedWriter.close();
		bufferedReader.close();
		
	}

}
