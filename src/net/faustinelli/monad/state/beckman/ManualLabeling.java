package net.faustinelli.monad.state.beckman;

public class ManualLabeling {

	public static <A> Tr<Scp<A>> label(Tr<A> t) {

		LLtP<A> r = Lab(t, 0);
		return r.lltpTree;
	}

	public static void main(String[] args) {

		System.out.println("unlabeled tree");

		Tr<String> t = new Br<String>(new Lf<String>("a"), new Br<String>(
				new Br<String>(new Lf<String>("b"), new Lf<String>("c")), new Lf<String>("d")));

		t.show(2);

	}

	private static <A> LLtP<A> Lab(Tr<A> t, int lbl) {

		if (t instanceof Lf<?>) {
			Lf<A> lf = (Lf<A>) t;
			int newLabel = lbl + 1;
			Scp<A> scp = new Scp<A>(lbl, lf.contents);
			Lf<Scp<A>> leaf = new Lf<Scp<A>>(scp);

			return new LLtP<A>(newLabel, leaf);

		} else if (t instanceof Br<?>) {

			Br<A> br = (Br<A>) t;

			LLtP<A> l = Lab(br.left, lbl);
			LLtP<A> r = Lab(br.right, lbl);

			Br<Scp<A>> lltptree = new Br<Scp<A>>(l.lltpTree, r.lltpTree);

			return new LLtP<A>(r.lltplabel, lltptree);

		} else {
			throw new RuntimeException("Lab/Label: impossible tree subtype");
		}
	}

}
