package com.main;
import com.numbers.Complex;
import static com.numbers.FFT.fft;

public class TestFFT {
	public static void main(String[] args){
		Complex a = new Complex(-0.03480425839330703);
		Complex b = new Complex (0.07910192950176387);
		Complex c = new Complex  (0.7233322451735928);
		Complex d = new Complex  (0.1659819820667019);
		
		Complex[] cn = new Complex[] {a,b,c,d};
		
		Complex[] cnFFT = fft(cn);
		
		if(cnFFT[0].equals(new Complex(0.9336118983487516))) {
			System.out.println("cnFFT[0] transformed correctly");
		} else {
			System.err.println("cnFFT[0] transformed incorrectly");
			System.err.println(cnFFT[0]);
		}
		if(cnFFT[1].equals(new Complex(-0.7581365035668999, 0.08688005256493803))) {
			System.out.println("cnFFT[1] transformed correctly");
		} else {
			System.err.println("cnFFT[1] transformed incorrectly");
			System.err.println(cnFFT[1]);
		}
		if(cnFFT[2].equals(new Complex(0.44344407521182005))) {
			System.out.println("cnFFT[2] transformed correctly");
		} else {
			System.err.println("cnFFT[2] transformed incorrectly");
			System.err.println(cnFFT[2]);
		}
		if(cnFFT[3].equals(new Complex(-0.7581365035668999 , -0.08688005256493803))) {
			System.out.println("cnFFT[3] transformed correctly");
		} else {
			System.err.println("cnFFT[3] transformed incorrectly");
			System.err.println(cnFFT[3]);
		}
		
	}
}
