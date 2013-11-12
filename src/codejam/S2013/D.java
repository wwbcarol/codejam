package codejam.S2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D {

	static final String TYPE = "D";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/S2013";

		// Test
		Name("sub-3");

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			int N = in.nextInt();
			int M = in.nextInt();
			
			int enx = in.nextInt();
			int eny = in.nextInt();
			int exx = in.nextInt();
			int exy = in.nextInt();
			
			
			int[][] map = new int[N][M];
			
			for(int j=0;j<N;j++){
				for(int k=0;k<M;k++){
					map[j][k] = in.nextInt();
				}
			}
			
			int r = bfs(new pos(enx, eny), new pos(exx, exy), map, N, M);
			
			out.print("Case #" + (i + 1) + ": ");

			if(r==-1) out.println("Mission Impossible.");
			else out.println(r);
		}

		in.close();
		out.close();

	}
	
	public static int bfs(pos start, pos end, int[][] map, int N, int M){
		
		 boolean[][] isVisited = new boolean[N][M];
		 Queue<pos> queue = new LinkedList<pos>();
		 
		 int power[][] = new int[N][M];
//			for(int i = 0; i < M; i ++) {
//				power[i] = new int[N];
//				Arrays.fill(power[i], 0);
//			}
			
			
		 queue.add(start);
		 power[start.x][start.y] = map[start.x][start.y];
		 
		 isVisited[start.x][start.y] = true;
		 
		 while(!queue.isEmpty()){
			 pos u = queue.poll();
			 isVisited[u.x][u.y] = true;
			 if(u.x == end.x&&u.y==end.y){
				 return power[end.x][end.y];
			 }
			 
			 if(u.x-1>=0){
				 if(map[u.x-1][u.y] !=-1 && !isVisited[u.x-1][u.y]){
					 queue.add(new pos(u.x-1, u.y));
					 power[u.x-1][u.y] = Math.max(power[u.x][u.y]+map[u.x-1][u.y], power[u.x-1][u.y]);
				 }
			 }
			 
			 if(u.x+1<N){
				 if(map[u.x+1][u.y] !=-1 && !isVisited[u.x+1][u.y]){
					 queue.add(new pos(u.x+1, u.y));
					 power[u.x+1][u.y] = Math.max(power[u.x][u.y]+map[u.x+1][u.y], power[u.x+1][u.y]);
				 }
			 }
			 if(u.y-1>=0){
				 if(map[u.x][u.y-1] !=-1 && !isVisited[u.x][u.y-1]){
					 queue.add(new pos(u.x, u.y-1));
					 power[u.x][u.y-1] = Math.max(power[u.x][u.y]+map[u.x][u.y-1], power[u.x][u.y-1]);
				 }
			 }
			 if(u.y+1<M){
				 if(map[u.x][u.y+1] !=-1 && !isVisited[u.x][u.y+1]){
					 queue.add(new pos(u.x, u.y+1));
					 power[u.x][u.y+1] = Math.max(power[u.x][u.y]+map[u.x][u.y+1], power[u.x][u.y+1]);
				 }
			 }
			 
		 }
		 
		 if(isVisited[end.x][end.y] == false) return -1;
		 else return power[end.x][end.y];
	}

	

}

class pos{
	int x;
	int y;
	pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}