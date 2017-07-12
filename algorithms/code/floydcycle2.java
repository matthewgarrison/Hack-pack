int mu = 0;
hare = x0;
while (tortoise != hare) {
	tortoise = foo(tortoise);
	hare = foo(hare);
	mu++;
}