int lambda = 1;
hare = foo(tortoise);
while (tortoise != hare) {
	hare = foo(hare);
	lambda++;
}