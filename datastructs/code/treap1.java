// From the Tokyo hack pack.
class Treap {
	final int key, val;
	final double p;
	final Treap left, right;
	Treap(int key, int val, double p, Treap left, Treap right) {
		this.key = key;  this.val = val;  this.p = p;
		this.left = left;  this.right = right;
	}
	Treap change(Treap left, Treap right) {
		return new Treap(key, val, p, left, right);
	}
	Treap normal() {
		if (left != null && left.p < p && (right == null || left.p < right.p)) {
			return left.change(left.left, change(left.right, right));
		} else if (right != null && right.p < p) {
			return right.change(change(left, right.left), right.right);
		}
		return this;
	}
}
Treap put(Treap t, int key, int val) {
	if (t == null) return new Treap(key, val, Math.random(), null, null);
	if (key < t.key) return t.change(put(t.left, key, val), t.right).normal();
	if (key > t.key) return t.change(t.left, put(t.right, key, val)).normal();
	return new Treap(key, val, t.p, t.left, t.right);
}
Treap remove(Treap t, int key) {
	if (t == null) return null;
	if (key < t.key) return t.change(remove(t.left, key), t.right);
	if (key > t.key) return t.change(t.left, remove(t.right, key));
	return merge(t.left, t.right);
}
Treap merge(Treap t1, Treap t2) {
	if (t1 == null) return t2;
	if (t2 == null) return t1;
	if (t1.p < t2.p) return t1.change(t1.left, merge(t1.right, t2));
	return t2.change(merge(t1, t2.left), t2.right);
}