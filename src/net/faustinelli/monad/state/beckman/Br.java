package net.faustinelli.monad.state.beckman;

public class Br<A> extends Tr<A> {

	public Tr<A> left;
	public Tr<A> right;

	public Br(Tr<A> left, Tr<A> right) {

		this.left = left;
		this.right = right;
	}

	@Override
	public void show(int level) {
		for (int i = 0; i < level * Tr.INDENTATION; i++) {
			System.out.print(" ");
		}
		System.out.println("Branch: ");
		left.show(level + 1);
		right.show(level + 1);
	}

	@Override
	public String toString() {
		return "{" + left.toString() + "|" + right.toString() + "}";
	}

}
