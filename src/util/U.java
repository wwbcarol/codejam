package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class U {

	public static void main(String[] args) {
		System.out.println(Double.MAX_EXPONENT);
		System.out.println(bigSqrt(new BigDecimal("4.0")).doubleValue());;
	}
	public static <E extends Object>void da(E[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println("");
	}
	
	public static <E extends Object>void daa(E[][] arrays){
		for(int i=0;i<arrays.length;i++){
			for(int j=0;j<arrays[0].length;j++){
				System.out.print(arrays[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void PI(int i){
		System.out.println("----------Case:" + (i + 1) + "---------");
	}

	public static boolean isPalindromes(double n) {
		
		double index = 10.0;
		while((n / index)>1){
			index *= 10;
		}
		
		index /= 10;
		
		while(n>=1){
			
			if(Math.floor(n%10) != Math.floor(n/index))
				return false;
			else{
				n = n - index*(Math.floor(n/index));
				n = Math.floor(n / 10);
				index /= 100;
			}
		}
		
		return true;
	}
	
	public static int howManyDigit(int A){
		int power = 1;
		while(A >= 10){
			power *= 10;
			A /= 10;
		}
		return power;
	}
	
	private static final BigDecimal SQRT_DIG = new BigDecimal(150);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());

	/**
	 * Private utility method used to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 * @param c
	 * @param xn
	 * @param precision
	 * @return
	 */
	private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
	    BigDecimal fx = xn.pow(2).add(c.negate());
	    BigDecimal fpx = xn.multiply(new BigDecimal(2));
	    BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
	    xn1 = xn.add(xn1.negate());
	    BigDecimal currentSquare = xn1.pow(2);
	    BigDecimal currentPrecision = currentSquare.subtract(c);
	    currentPrecision = currentPrecision.abs();
	    if (currentPrecision.compareTo(precision) <= -1){
	        return xn1;
	    }
	    return sqrtNewtonRaphson(c, xn1, precision);
	}

	/**
	 * Uses Newton Raphson to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 * @param c
	 * @return
	 */
	public static BigDecimal bigSqrt(BigDecimal c){
	    return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
	}

}
