package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class E {

	static final String TYPE = "E";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/F2013";

		// Test
		 Name("E-large-practice");
//		Name("E-test");

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			
			int N = in.nextInt();
			HashMap<String, Integer> tele = new HashMap<String, Integer>();
			int[] colorMap = new int[N];
			int NumOfNode = 0;
			for (int j = 1; j <= N; j++) {
				String s = in.next();
				if (!tele.containsKey(s)) {
					tele.put(s, ++NumOfNode);
					colorMap[j - 1] = NumOfNode;
				} else {
					colorMap[j - 1] = tele.get(s);
				}
			}

			int[][] edges = new int[NumOfNode][NumOfNode];
			for (int j = 0; j < NumOfNode; j++) {
				for (int t = 0; t < NumOfNode; t++) {
					if (j != t)
						edges[j][t] = -1;
					else
						edges[j][t] = 0;
				}
			}
			int M = in.nextInt();
			for (int j = 0; j < M; j++) {
				int s = colorMap[in.nextInt() - 1] - 1;
				int e = colorMap[in.nextInt() - 1] - 1;
				int ti = in.nextInt();
				if (edges[s][e] == -1 || ti < edges[s][e])
					edges[s][e] = ti;
			}

			out.println("Case #" + (i + 1) + ": ");
			int S = in.nextInt();
			for (int j = 0; j < S; j++) {
				int s = colorMap[in.nextInt() - 1] - 1;
				int e = colorMap[in.nextInt() - 1] - 1;
				out.println(findShortestPath(edges, s, e));
			}
		}
		in.close();
		out.close();
	}

	public static int findShortestPath(int[][] edges, int s, int e) {
		int N = edges.length;
		int[] dMap = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			dMap[i] = -1;
			visited[i] = false;
		}

		dMap[s] = 0;

		for (int t = 0; t < N; t++) {
			int k = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && dMap[j] != -1 && dMap[j] < min) {
					min = dMap[j];
					k = j;
				}
			}
			if (k == -1)
				break;

			for (int j = 0; j < N; j++) {
				if (!visited[j]&&edges[k][j] != -1
						&& (dMap[j] == -1 || dMap[k] + edges[k][j] < dMap[j])) {
					dMap[j] = dMap[k] + edges[k][j];
				}
			}

			visited[k] = true;
			if(visited[e]) break;
		}
		return dMap[e];
	}

}
