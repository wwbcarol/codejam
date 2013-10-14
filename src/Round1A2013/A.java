package Round1A2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class A {

	static final String TYPE = "A";
	static String inputFile;
	static String outputFile;

	private static void Name(String s) {
		inputFile = s + ".in";
		outputFile = s + ".out";
	}

	private static boolean isSqrt(BigInteger n, BigInteger root) {
		final BigInteger lowerBound = root.pow(2);
		final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
		return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
	}

	public static BigInteger sqrt(BigInteger n) {
		if (n.signum() >= 0) {
			final int bitLength = n.bitLength();
			BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

			while (!isSqrt(n, root)) {
				root = root.add(n.divide(root)).divide(BigInteger.valueOf(2));
			}
			return root;
		} else {
			throw new ArithmeticException("square root of negative number");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		 String root = "data/R1A2013";
		
		 // Test
		 Name("A-large-practice");
		
		 Scanner in = new Scanner(new File(root, inputFile));
		 PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		 int T = in.nextInt();
		
		 for(int i=0;i<T;i++){
		
		 BigInteger r = in.nextBigInteger();
		 BigInteger t = in.nextBigInteger();
		
		 BigInteger a = BigInteger.valueOf(2);
		 BigInteger b = r.multiply(a).subtract(BigInteger.ONE);
		 BigInteger c = BigInteger.ZERO.subtract(t);
		 
		 BigInteger res = BigInteger.ZERO.subtract(b).add(sqrt(b.multiply(b).subtract(BigInteger.valueOf(4).multiply(a).multiply(c))));
		 res = res.divide(BigInteger.valueOf(4));
		
		 out.println("Case #"+(i+1)+": "+res);
		
		 }
		
		 in.close();
		 out.close();

	}

}
