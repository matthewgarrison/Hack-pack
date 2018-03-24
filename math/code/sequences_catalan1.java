long catalan = 1; // Holds up to C(33) = 212336130412243110
for (long x = 0; x < n; x++) catalan = catalan * (4L * x + 2) / (x + 2);