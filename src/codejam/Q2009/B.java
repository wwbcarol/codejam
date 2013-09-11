package codejam.Q2009;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

	static char c;

	public static void findMin(int[][] in, char[][] charBasin, int i, int j) {

		if (charBasin[i][j] == '*') {
			int N, W, S, E;
			if (i == 0) {
				N = in[i][j] + 1;
			} else {
				N = in[i - 1][j];
			}

			if (j == 0) {
				W = in[i][j] + 1;
			} else {
				W = in[i][j - 1];
			}

			if (i == in.length - 1) {
				S = in[i][j] + 1;
			} else {
				S = in[i + 1][j];
			}

			if (j == in[0].length - 1) {
				E = in[i][j] + 1;
			} else {
				E = in[i][j + 1];
			}

			if (N < in[i][j] && N <= W && N <= S && N <= E) {
				findMin(in, charBasin, i - 1, j);
				charBasin[i][j] = charBasin[i - 1][j];
			} else if (W < in[i][j] && W < N && W <= S && W <= E) {
				findMin(in, charBasin, i, j - 1);
				charBasin[i][j] = charBasin[i][j - 1];
			} else if (E < in[i][j] && E < N && E < W && E <= S) {
				findMin(in, charBasin, i, j + 1);
				charBasin[i][j] = charBasin[i][j + 1];
			} else if (S < in[i][j] && S < N && S < W && S < E) {
				findMin(in, charBasin, i + 1, j);
				charBasin[i][j] = charBasin[i + 1][j];
			} else {
				charBasin[i][j] = c++;

			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		String root = "data/Q2009";

		// Test

		// String inputFile = "B-in.txt";
		// String outputFile = "B-out.txt";

		// Small

		// String inputFile = "B-small-practice.in";
		// String outputFile = "B-small-practice.out";

		// Large

		String inputFile = "B-large-practice.in";
		String outputFile = "B-large-practice.out";

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		// T maps
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int H = in.nextInt();
			int W = in.nextInt();

			int[][] map = new int[H][W];

			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					map[j][k] = in.nextInt();
				}
			}

			char[][] charBasin = new char[H][W];
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					charBasin[j][k] = '*';
				}
			}
			c = 'a';
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					findMin(map, charBasin, j, k);
				}
			}

			out.println("Case #" + (i + 1) + ":");
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					out.print(charBasin[j][k]);

					if (k == W - 1)
						out.print("\n");
					else
						out.print(" ");
				}
			}

		}

		in.close();
		out.close();
	}
}
