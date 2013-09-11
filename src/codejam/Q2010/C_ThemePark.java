package codejam.Q2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_ThemePark {

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2010";

		// Test

		// String inputFile = "C-in.txt";
		// String outputFile = "C-out.txt";

		// Small

//		String inputFile = "C-small-practice.in";
//		String outputFile = "C-small-practice.out";

		// Large

		 String inputFile = "C-large-practice.in";
		 String outputFile = "C-large-practice.out";

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			int R = in.nextInt();
			int k = in.nextInt();
			int N = in.nextInt();

			int[] groups = new int[N];

			int[] record = new int[N];
			int[] recordInx = new int[N];

			long isFull = 0;
			for (int j = 0; j < N; j++) {
				record[j] = 0;
				groups[j] = in.nextInt();
				isFull += groups[j];
			}

			if (isFull <= k) {
				out.println("Case #" + (i + 1) + ": " + isFull * R);
			} else {
				int index = 0;
				long Euros = 0;

				for (int m = 0; m < R; m++) {

					int sum = 0;
					if (record[index] != 0) {
						sum = record[index];
						index = recordInx[index];
					} else {

						int tmpInx = index;
						int lastInt = 0;
						while (sum < k) {

							lastInt = groups[index];
							sum += lastInt;
							index = (index + 1) % N;
						}

						if (sum != k) {
							sum -= lastInt;
							index = (index + N - 1) % N;
						}

						record[tmpInx] = sum;
						recordInx[tmpInx] = index;
					}
					Euros += sum;

				}

				out.println("Case #" + (i + 1) + ": " + Euros);
			}

		}

		in.close();
		out.close();

	}

}
