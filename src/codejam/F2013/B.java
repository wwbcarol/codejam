package codejam.F2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

class rNum {
	BigInteger p;
	BigInteger q;
};

public class B {
	
	static final String TYPE = "B";
	static String inputFile;
	static String outputFile;

	private static void Name(String s){
		inputFile = s + ".in";
		outputFile = s + ".out";
	}
	
	private static void getPQ(BigInteger n, rNum r){
		
		if(n.compareTo(BigInteger.ZERO) == 0){
			r.p = BigInteger.ONE;
			r.q = BigInteger.ONE;
		}else{
			
			rNum rr = new rNum();
			getPQ(n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2)),rr);

			if(n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0){
				r.p = rr.p.add(rr.q);
				r.q = rr.q;
			}else{
				r.p = rr.p;
				r.q = rr.p.add(rr.q);
			}
		}
	}
	
	private static BigInteger getN(BigInteger p, BigInteger q){
		
		if(p.compareTo(BigInteger.ONE)==0&&q.compareTo(BigInteger.ONE)==0)
			return BigInteger.ZERO;
		else{
			if(p.compareTo(q)<0){
				return getN(p, q.subtract(p)).multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
			}else{
				return getN(p.subtract(q), q).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(2));
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		
		String root = "data/F2013";
		
		// Test
		Name("B-large-practice"
				+ "");
		
		Scanner in = new Scanner(new File(root, inputFile));
		PrintWriter out = new PrintWriter(new File(root, outputFile));
		
		int T = in.nextInt();
		
		for(int i=0;i<T;i++){
			
			int type = in.nextInt();
			
			out.print("Case #"+(i+1)+": ");
			if(type==1){
				rNum r = new rNum();
				getPQ(in.nextBigInteger().subtract(BigInteger.ONE), r);
				out.print(r.p+" "+r.q);
			}else{
				out.print(getN(in.nextBigInteger(), in.nextBigInteger()).add(BigInteger.ONE));
			}
			
			out.println("");
			
			
		}
		
		in.close();
		out.close();

	}

}