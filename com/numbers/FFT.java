package com.numbers;

/**
 * @see FFT#fft(Complex[]) 
 */
public class FFT {
	/**
	 * An implementation of the Cooley–Tukey FFT algorithm, based on example code hosted by Princeton (see {@code README})
	 * @param cNums The array of complex numbers to be computed
	 * @return The computed fourier transform of {@code cNums}
	 * @throws IllegalArgumentException When the length of {@code cNums} is not a power of 2
	 */
	public static Complex[] fft(Complex[] cNums) throws IllegalArgumentException {
		int l = cNums.length;
		// base case
		if(l==1) return new Complex[] {cNums[0]};
		// checks for power of 2
		if((l%2) != 0) throw new IllegalArgumentException("length is not a power of 2");
		
		// Separately computes odd and even FFTs
		
		// Even FFTs
		Complex[] even = new Complex[l/2];
		for(int k = 0; k<l/2; k++) {even[k] = cNums[2*k];}
		Complex[] evenFFT = fft(even);
		
		// Odd FFTs
		Complex[] odd = new Complex[l/2];
		for(int k = 0; k<l/2; k++) {odd[k] = cNums[(2*k)+1];}
		Complex[] oddFFT = fft(odd);
		
		// Combine the FFTs
		Complex[] out = new Complex[l];
		for(int k = 0; k<l/2; k++) {
			double kth = -2 * k * StrictMath.PI / l;
			Complex wk = new Complex(StrictMath.cos(kth), StrictMath.sin(kth));
			out[k]       = Complex.add(evenFFT[k], Complex.mult(wk, oddFFT[k]));
			out[k + l/2] = Complex.sub(evenFFT[k], Complex.mult(wk, oddFFT[k]));
		}
		
		return out;
	}
}

