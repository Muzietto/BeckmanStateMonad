package net.faustinelli.monad.state.beckman;

public class Lf<A> extends Tr<A> {

	public A contents;

	public Lf(A contents) {

		this.contents = contents;
	}

	@Override
	public void show(int level) {

		for (int i = 0; i < level * Tr.INDENTATION; i++) {
			System.out.print(" ");
		}
		System.out.print("Leaf: ");
		System.out.print(contents.toString());
		System.out.print("\n");
	}

	@Override
	public String toString() {
		return "" + contents.toString() + "";
	}

}
