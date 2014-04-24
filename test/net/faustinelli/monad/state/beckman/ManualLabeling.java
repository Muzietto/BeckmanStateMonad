package net.faustinelli.monad.state.beckman;

import net.faustinelli.monad.state.Scp;

public class ManualLabeling {

	public static void main(String[] args) {

		System.out.println("unlabeled tree");

		Tr<String> t = new Br<String>(new Lf<String>("a"), new Br<String>(
				new Br<String>(new Lf<String>("b"), new Lf<String>("c")),
				new Lf<String>("d")));

		t.show(2);

		Tr<Scp<Integer, String>> result = label(t);

		System.out.println("labeled tree");
		result.show(2);
	}

	public static <A> Tr<Scp<Integer, A>> label(Tr<A> t) {

		LLtP<Integer, A> r = Lab(t, 0);
		return r.lltpTree;
	}

	/**
	 * Helper function - to create a state+content labeled tree you gotta thread
	 * the state explicitly through the recursive calls.
	 * 
	 * @param t
	 *            - the still unlabeled tree
	 * @param lbl
	 *            - current state
	 * @return - a couple (labeledTree, state)
	 */
	private static <A> LLtP<Integer, A> Lab(Tr<A> t, int lbl) {

		if (t instanceof Lf<?>) {
			
			Lf<A> lf = (Lf<A>) t;
			int newLabel = lbl + 1;
			
			Scp<Integer, A> scp = new Scp<Integer, A>(lbl, lf.contents);
			Lf<Scp<Integer, A>> leaf = new Lf<Scp<Integer, A>>(scp);

			return new LLtP<Integer, A>(newLabel, leaf);

		} else if (t instanceof Br<?>) {

			Br<A> br = (Br<A>) t;

			LLtP<Integer, A> l = Lab(br.left, lbl);
			LLtP<Integer, A> r = Lab(br.right, l.lltplabel);

			Br<Scp<Integer, A>> lltptree = new Br<Scp<Integer, A>>(l.lltpTree,
					r.lltpTree);

			return new LLtP<Integer, A>(r.lltplabel, lltptree);

		} else {
			throw new RuntimeException("Lab/Label: impossible tree subtype");
		}
	}

}
