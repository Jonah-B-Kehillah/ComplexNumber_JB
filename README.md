# FourierTransform_JB
###### By *Jonah B.*
A super-project containing both my implementation of a complex `Polynomial()`
and of the fast fourier transform

## Class and Method List
- `main`
  - `Main`
  - `TestFFT`
- `numbers`
  - `Complex`
    - `Complex(Number, Number)`
    - `Complex(Number)`
    - `void add(Complex)`
    - `void sub(Complex)`
    - `void mult(Complex)`
    - `static Complex add(Complex, Complex)`
    - `static Complex sub(Complex, Complex)`
    - `static Complex mult(Complex, Complex)`
    - `static Complex div(Complex, Complex)`
    - `static Complex pow(Complex, Complex)`
    - `static Complex powNoRound(Complex, Complex)`
    - `String toString()`
  - `FFT`
    - `static Complex[] fft(Complex[])`
  - `Polynomial`
    - `Polynomial(Complex[])`
    - `Complex evaluate(Complex)`
    - `Complex evaluate(Number)`
    - `Complex evaluate(Number, Number)`

## Acknowledgements
- Mr. Christopher Kuszmaul
- geeksforgeeks.org
- GitHub user `cab1729` (division and power function)
- [Robert Sedgewick and Kevin Wayne](https://introcs.cs.princeton.edu/java/97data/FFT.java.html)
  (example FFT function)
