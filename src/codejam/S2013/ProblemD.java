package codejam.S2013;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemD {

	public static String problem = "problem2_d";
	public static String file = "data/S2013/D-large";
	
	public static String fin = file + ".in";
	public static String fout = file + ".out";
	
	public static int shortestPathLargestValue(int [][] mat, int m, int n, int x0, int y0, int x1, int y1) {
		
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		
		boolean [][] processed = new boolean[m][];
		for(int i = 0 ; i < m ; i ++) {
			processed[i] = new boolean[n];
			Arrays.fill(processed[i], false);
		}
		
		int res[][] = new int[m][];
		for(int i = 0; i < m; i ++) {
			res[i] = new int[n];
			Arrays.fill(res[i], 0);
		}
		
		xq.add(x0);
		yq.add(y0);
		res[x0][y0] = mat[x0][y0];
				
		while (xq.size() > 0)
		{
			int x = xq.poll();
			int y = yq.poll();
			processed[x][y] = true;
			if(x == x1 && y == y1)
				return res[x1][y1];
			
			if(x - 1 >= 0) {
				if(mat[x - 1][y] >= 0 && !processed[x-1][y]) {
					xq.add(x-1); yq.add(y);
					res[x-1][y] = Math.max(res[x][y] + mat[x-1][y], res[x-1][y]);
				}
			}
			
			if(x + 1 < m ) {
				if(mat[x + 1][y] >= 0 && !processed[x+1][y]) {
					xq.add(x+1); yq.add(y);
					res[x+1][y] = Math.max(res[x][y] + mat[x+1][y], res[x+1][y]);
				}
			}
			
			if(y - 1 >= 0) {
				if(mat[x][y - 1] >= 0 && !processed[x][y - 1]) {
					xq.add(x); yq.add(y  - 1);
					res[x][y - 1] = Math.max(res[x][y] + mat[x][y  - 1], res[x][y - 1]);
				}
			}
			
			if(y + 1 < n) {
				if(mat[x][y + 1] >= 0 && !processed[x][y + 1]) {
					xq.add(x); yq.add(y  + 1);
					res[x][y + 1] = Math.max(res[x][y] + mat[x][y + 1], res[x][y + 1]);
				}
			}
		}		
		
		if(processed[x1][y1] == false)
			return -1;
		else
			return res[x1][y1];
	}
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(fin)));

		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(fout)));
		
		int K = Integer.valueOf(br.readLine());
		
		int [][] mat = null;
		String [] strs = null;
		int val = 0;
		
		for (int k = 0; k < K; k++ ) {
			
			strs = br.readLine().split(" ");
			int m = Integer.valueOf(strs[0]);
			int n = Integer.valueOf(strs[1]);
			
			strs = br.readLine().split(" ");
			int x0 = Integer.valueOf(strs[0]);
			int y0 = Integer.valueOf(strs[1]);
			int x1 = Integer.valueOf(strs[2]);
			int y1 = Integer.valueOf(strs[3]);
			
			mat = new int[m][];
			for (int i = 0; i < m ; i++) {
				mat[i] = new int[n];
				strs = br.readLine().split(" ");
				for(int j = 0; j < n; j++) {
					mat[i][j] = Integer.valueOf(strs[j]);
				}
			}
			
			bw.write("Case #" + (k + 1) + ": " + 
			((val = shortestPathLargestValue(mat, m, n, x0, y0, x1, y1)) >= 0 ? 
					val : "Mission Impossible.") + "\n");
			
			if(k % 10 == 0)
				System.out.print("Case #" + (k + 1) + "finished");

		}
		
		br.close();
		
		bw.flush();
		bw.close();
	}
}
