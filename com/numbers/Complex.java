package com.numbers;

public class Complex {
	public double real, imag;
	
	public Complex(Number real, Number imag) {
		this.real = real.doubleValue();
		this.imag = imag.doubleValue();
	}
	
	public static Complex add(Complex n1, Complex n2) {
		return new Complex(n1.real + n2.real, n1.imag + n2.imag);
	}
	public static Complex sub(Complex n1, Complex n2) {
		return new Complex(n1.real - n2.real, n1.imag - n2.imag);
	}
	
	public static Complex mult(Complex n1, Complex n2) {
		double fReal, fImag;
		if(n1.imag == 0.0 && n2.imag != 0.0) {
			fReal = n1.real * n2.real;
			fImag = n1.real * n2.imag;
		}
		if(n1.imag != 0 && n2.imag == 0) {
			fReal = n1.real * n2.real;
			fImag = n1.imag * n2.real;
		}
		if(n1.imag == 0 && n2.imag == 0) {
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
	
	public String toString() {
		if(imag == 0) return String.format("%s", real);
		if(imag <  0) return String.format("%s%si", real, imag);
		if(real == 0) return String.format("%si", imag);
		return String.format("%s+%si", real, imag);
	}
}