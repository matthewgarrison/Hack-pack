static double[] multiply(double[] a, double[] b) {
	double[] ar = a.clone(), br = b.clone();
	double[] ai = new double[LEN], bi = new double[LEN];
	fft(1, ar, ai);
	fft(1, br, bi);
	double[] cr = new double[LEN], ci = new double[LEN];
	for (int i = 0; i < LEN; ++i) {
		cr[i] = ar[i] * br[i] - ai[i] * bi[i];
		ci[i] = ai[i] * br[i] + ar[i] * bi[i];
	}
	ifft(cr, ci);
	return cr;
}
static void ifft(double[] real, double[] imag) {
	fft(-1, real, imag);
	for (int i = 0, n = real.length; i < n; ++i) {
		imag[i] = -imag[i] / n;
		real[i] /= n;
	}
}