public class Complex {
	public double real, imag;
	
	public Complex(Number real, Number imag) {
		this.real = (double) real;
		this.imag = (double) imag;
	}
	
	public static Complex add(Complex n1, Complex n2) {
		return new Complex(n1.real + n2.real, n1.imag + n2.imag);
	}
	public static Complex sub(Complex n1, Complex n2) {
		return new Complex(n1.real - n2.real, n1.imag - n2.imag);
	}
	
}