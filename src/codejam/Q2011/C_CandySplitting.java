package codejam.Q2011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_CandySplitting {

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2011";

		// Test

		// String inputFile = "C-in.txt";
		// String outputFile = "C-out.txt";

		// Small

		// String inputFile = "C-small-practice.in";
		// String outputFile = "C-small-practice.out";

		// Large

		String inputFile = "C-large-practice.in";
		String outputFile = "C-large-practice.out";

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			int N = in.nextInt();

			int min = Integer.MAX_VALUE;
			int xor = 0;
			int sum = 0;
			for (int j = 0; j < N; j++) {

				int candy = in.nextInt();
				if (candy < min)
					min = candy;
				xor = xor ^ candy;
				sum += candy;
			}

			out.print("Case #" + (i + 1) + ": ");

			if (xor == 0) {
				out.println(sum - min);
			} else {
				out.println("NO");
			}
		}

		in.close();
		out.close();

	}

}
