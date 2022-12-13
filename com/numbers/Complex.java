package com.numbers;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Complex {
	public double real, imag;
	
	public Complex(Number real, Number imag) {
		this.real = real.doubleValue();
		this.imag = imag.doubleValue();
	}
	
	/**
	 * Creates a new instance of Polynomial() with only a real number value (i.e {@code (n+0i)})
	 * @param real The real number value to be assigned to the polynomial
	 */
	@SuppressWarnings("RedundantCast")
	public Complex(Number real) {
		this.real = real.doubleValue();
		this.imag = (double) 0;
	}
	
	public boolean equals(Complex o){
		return (real == o.real && imag == o.imag);
	}
	
	/**
	 * Adds complex number n to this instance of Complex
	 * @see Complex#add(Complex, Complex)
	 */
	public void add(Complex n) {
		Complex nv = Complex.add(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	/**
	 * Subtracts complex number n from this instance of Complex
	 * @see Complex#sub(Complex, Complex)
	 */
	@SuppressWarnings("unused")
	public void sub(Complex n) {
		Complex nv = Complex.sub(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	/**
	 * Multiplies complex number n with this instance of Complex
	 * @see Complex#mult(Complex, Complex)
	 */
	@SuppressWarnings("unused")
	public void mult(Complex n) {
		Complex nv = Complex.mult(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	
	/** Adds complex numbers {@code n1} and {@code n2}
	 * @return the result of the addition */
	public static Complex add(Complex n1, Complex n2) {
		return new Complex(n1.real + n2.real, n1.imag + n2.imag);
	}
	/** Subtracts complex number {@code n2} from complex number {@code n1}
	 * @return the result of the subtraction */
	public static Complex sub(Complex n1, Complex n2) {
		return new Complex(n1.real - n2.real, n1.imag - n2.imag);
	}
	
	/**
	 * Multiplies two complex numbers with each other
	 * @param n1 The first complex number to multiply
	 * @param n2 The second complex number to multiply
	 * @return A new complex number; the result of {@code n1} and {@code n2} multiplied
	 */
	public static Complex mult(Complex n1, Complex n2) {
		double fReal, fImag;
		if(n1.imag == 0.0 && n2.imag != 0.0) { // n1 is real, n2 is not real
			fReal = n1.real * n2.real;
			fImag = n1.real * n2.imag;
		}
		else if(n1.imag != 0 && n2.imag == 0) { // n1 is not real, n2 is real
			fReal = n1.real * n2.real;
			fImag = n1.imag * n2.real;
		}
		else if(n1.imag == 0) { // At this point, if either of n1 or n2 are real, then both are real
			fReal = n1.real * n2.real;
			fImag = 0;
		}
		else {
			fReal = n1.real * n2.real;
			fImag = (n1.real * n2.imag) + (n1.imag * n2.real);
			fReal -= (n1.imag * n2.imag);
		}
		return new Complex(fReal, fImag);
	}
	
	/**
	 * Divides complex number n1 by complex number n2
	 * @param n1 The numerator
	 * @param n2 THe denominator
	 * @return {@code n1} divided by {@code n2} as a new Complex()
	 */
	public static Complex div(Complex n1, Complex n2) {
		double n2realSq = 0.0;
		double n2imagSq = 0.0;
		
		if(n2.real != 0) {
			n2realSq = StrictMath.pow(n2.real, 2.0);
		}
		if(n2.imag != 0) {
			n2imagSq = StrictMath.pow(n2.imag, 2.0);
		}
		
		double ac = n1.real * n2.real;
		double bd = n1.imag * n2.imag;
		double bc = n1.imag * n2.real;
		double ad = n1.real * n2.imag;
		
		return new Complex((ac+bd)/(n2realSq+n2imagSq), (bc-ad)/(n2realSq+n2imagSq));
	}
	
	/**
	 * Raises complex number n1 to the power of complex number n2
	 * @param n1 The imaginary number
	 * @param n2 The imaginary exponent
	 * @return {@code n1} raised to the power of {@code n2} as a new Complex()
	 */
	@SuppressWarnings({"DuplicateExpressions", "DuplicatedCode"})
	public static Complex pow(Complex n1, Complex n2) {
		
		double c = n2.real;
		double d = n2.imag;
		
		double r = StrictMath.sqrt(StrictMath.pow(n1.real, 2) + StrictMath.pow(n1.imag, 2));
		double t = StrictMath.atan2(n1.imag,n1.real);
		
		Complex r1 = new Complex((StrictMath.pow(r, c)*StrictMath.pow(StrictMath.E, -d*t)),0);
		Complex r2 = new Complex(
					StrictMath.cos(d*StrictMath.log(r)+c*t),
					StrictMath.sin(d*StrictMath.log(r)+c*t)
		);
		
		Complex r3 = Complex.mult(r1, r2);
		
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.HALF_UP);
		r3.real = Double.parseDouble(df.format(r3.real));
		r3.imag = Double.parseDouble(df.format(r3.imag));
		
		return r3;
	}
	
	/**
	 * Operates the same as {@code Complex.pow()}, but does not round the output to three decimal places
	 * @see Complex#pow
	 */
	@SuppressWarnings({"DuplicatedCode", "DuplicateExpressions"})
	public static Complex powNoRound(Complex n1, Complex n2) {
		
		double c = n2.real;
		double d = n2.imag;
		
		double r = StrictMath.sqrt(StrictMath.pow(n1.real, 2) + StrictMath.pow(n1.imag, 2));
		double t = StrictMath.atan2(n1.imag,n1.real);
		
		Complex r1 = new Complex((StrictMath.pow(r, c)*StrictMath.pow(StrictMath.E, -d*t)),0);
		Complex r2 = new Complex(
					StrictMath.cos(d*StrictMath.log(r)+c*t),
					StrictMath.sin(d*StrictMath.log(r)+c*t)
		);
		
		return Complex.mult(r1, r2);
	}
	
	public String toString() {
		if(imag == 0) return String.format("%s", real); // real
		if(imag <  0) return String.format("%s%si", real, imag); // real, negative imaginary component
		if(real == 0) return String.format("%si", imag); // only imaginary component
		return String.format("%s+%si", real, imag); //both imaginary and real component
	}
}