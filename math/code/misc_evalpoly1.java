int value = coefficients[0];
for (int j = 1; j <= polynomialDegree; ++j) {
	value *= x;
	value += coefficients[j];
}