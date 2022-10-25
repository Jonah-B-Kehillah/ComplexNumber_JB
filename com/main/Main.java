package com.main;
import com.numbers.*;

public class Main {
	public static void main(String[] args) {
		Complex c1 = new Complex(3,2);
		Complex c2 = new Complex(4,5);
		System.out.println("add: " + Complex.add(c1, c2).toString());
		System.out.println("sub: " + Complex.sub(c1, c2).toString());
		System.out.println("mul: " + Complex.mult(c1, c2).toString());
	}
}
