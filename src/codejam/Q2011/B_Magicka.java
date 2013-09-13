package codejam.Q2011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class B_Magicka {

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2011";

		// Test

		 String inputFile = "B-in.txt";
		 String outputFile = "B-out.txt";

		// Small

		// String inputFile = "B-small-practice.in";
		// String outputFile = "B-small-practice.out";

		// Large

//		String inputFile = "B-large-practice.in";
//		String outputFile = "B-large-practice.out";

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			char[][] comdic = new char[26][26];
			char[][] oppodic = new char[26][26];

			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 26; k++) {
					comdic[j][k] = '*';
					oppodic[j][k] = '*';
				}
			}

			int C = in.nextInt();
			for (int j = 0; j < C; j++) {
				String combine = in.next();
				comdic[combine.charAt(0) - 'A'][combine.charAt(1) - 'A'] = combine.charAt(2);
				comdic[combine.charAt(1) - 'A'][combine.charAt(0) - 'A'] = combine.charAt(2);
			}

			int D = in.nextInt();
			for (int j = 0; j < D; j++) {
				String oppo = in.next();
				oppodic[oppo.charAt(0) - 'A'][oppo.charAt(1) - 'A'] = '~';
				oppodic[oppo.charAt(1) - 'A'][oppo.charAt(0) - 'A'] = '~';
			}

			int N = in.nextInt();
			String s = in.next();

			ArrayList<Character> list = new ArrayList<Character>();
			list.add(s.charAt(0));

			for (int j = 1; j < N; j++) {

				if (list.isEmpty()) {
					list.add(s.charAt(j));
				} else {

					if (comdic[s.charAt(j) - 'A'][list.get(list.size() - 1) - 'A'] != '*') {
						char c = comdic[s.charAt(j) - 'A'][list
								.get(list.size() - 1) - 'A'];
						list.remove(list.size() - 1);
						list.add(c);
					} else {
						for (int k = 0; k < 26; k++) {
							if (oppodic[s.charAt(j) - 'A'][k] != '*') {
								Character c = new Character((char) ('A' + k));
								if (list.indexOf(c) != -1) {
									list.clear();
									break;
								}
							}
						}

						if (list.isEmpty() != true)
							list.add(s.charAt(j));
					}
				}
			}

			out.print("Case #" + (i + 1) + ": [");

			for (int j = 0; j < list.size(); j++) {
				out.print(list.get(j));
				if (j != list.size() - 1)
					out.print(", ");
			}
			out.println("]");

		}

		in.close();
		out.close();

	}

}
