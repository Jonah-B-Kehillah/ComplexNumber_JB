package com.numbers;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Complex {
	public double real, imag;
	
	public Complex(Number real, Number imag) {
		this.real = real.doubleValue();
		this.imag = imag.doubleValue();
	}
	
	public boolean equals(Complex o){
		return (real == o.real && imag == o.imag);
	}
	
	public void add(Complex n) {
		Complex nv = Complex.add(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	public void sub(Complex n) {
		Complex nv = Complex.sub(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	public void mult(Complex n) {
		Complex nv = Complex.mult(this, n);
		this.real = nv.real;
		this.imag = nv.imag;
	}
	
	public static Complex add(Complex n1, Complex n2) {
		return new Complex(n1.real + n2.real, n1.imag + n2.imag);
	}
	public static Complex sub(Complex n1, Complex n2) {
		return new Complex(n1.real - n2.real, n1.imag - n2.imag);
	}
	
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