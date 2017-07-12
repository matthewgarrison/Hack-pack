int tortoise = foo(x0);
int hare = foo(foo(x0));
while (tortoise != hare) {
	tortoise = foo(tortoise);
	hare = foo(foo(hare));
}