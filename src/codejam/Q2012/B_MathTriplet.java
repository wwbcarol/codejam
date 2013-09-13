package codejam.Q2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B_MathTriplet {

	public static void main(String[] args) throws FileNotFoundException {

		String root = "data/Q2012";

		// Test

//		String inputFile = "B-in.txt";
//		String outputFile = "B-out.txt";

		// Small

//		 String inputFile = "B-small-practice.in";
//		 String outputFile = "B-small-practice.out";

		// Large

		 String inputFile = "B-large-practice.in";
		 String outputFile = "B-large-practice.out";

		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));

		int T = in.nextInt();

		for (int i = 0; i < T; i++) {

			int N = in.nextInt();
			int S = in.nextInt();
			int p = in.nextInt();

			
				int safe = 3 * p - 2;
				int count = 0;
				int boadenline = 0;
				for (int j = 0; j < N; j++) {

					int score = in.nextInt();

					if (score >= safe)
						count++;
					else if (score >= safe - 2)
						boadenline++;

					System.out.println(score + "," + count + "," + boadenline);
				}
				
			if (p >= 2) {
				out.println("Case #" + (i + 1) + ": "
						+ (count + (boadenline > S ? S : boadenline)));
			}else{
				
				if(p==0){
					out.println("Case #" + (i + 1) + ": "
							+ N);
				}else{
					out.println("Case #" + (i + 1) + ": "
							+ count);
				}
				
			}
		}

		in.close();
		out.close();

	}

}
