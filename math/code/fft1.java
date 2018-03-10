// From the Tokyo hack pack.
static void fft(int sign, double[] real, double[] imag) {
	int n = real.length, d = Integer.numberOfLeadingZeros(n) + 1;
	double theta = sign * 2 * Math.PI / n;
	for (int m = n; m >= 2; m >>= 1, theta *= 2) {
		for (int i = 0, mh = m >> 1; i < mh; i++) {
			double wr = Math.cos(i * theta), wi = Math.sin(i * theta);
			for (int j = i; j < n; j += m) {
				int k = j + mh;
				double xr = real[j] - real[k], xi = imag[j] - imag[k];
				real[j] += real[k];  imag[j] += imag[k];
				real[k] = wr * xr - wi * xi;
				imag[k] = wr * xi + wi * xr;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		int j = Integer.reverse(i) >>> d;
		if (j < i) {
			double tr = real[i];  real[i] = real[j];  real[j] = tr;
			double ti = imag[i];  imag[i] = imag[j];  imag[j] = ti;
		}
	}
}
static double[] multiply(double[] a, double[] b) {
	double[] ar = a.clone(), br = b.clone();
	double[] ai = new double[LEN], bi = new double[LEN];
	fft(1, ar, ai); fft(1, br, bi);
	double[] cr = new double[LEN], ci = new double[LEN];
	for (int i = 0; i < LEN; ++i) {
		cr[i] = ar[i] * br[i] - ai[i] * bi[i];
		ci[i] = ai[i] * br[i] + ar[i] * bi[i];
	}
	ifft(cr, ci);  	return cr;
}
static void ifft(double[] real, double[] imag) {
	fft(-1, real, imag);
	for (int i = 0, n = real.length; i < n; ++i) {
		imag[i] = -imag[i] / n;  real[i] /= n;
	}
}