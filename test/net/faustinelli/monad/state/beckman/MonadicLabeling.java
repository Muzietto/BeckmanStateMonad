package net.faustinelli.monad.state.beckman;

import net.faustinelli.monad.state.Scp;
import net.faustinelli.monad.state.StateMonad;

public class MonadicLabeling {

	private StateMonad<Integer, Integer> updateState = new StateMonad<Integer, Integer>(
			n -> new Scp<Integer, Integer>(n + 1, n));

	public static void main(String[] args) {

		System.out.println("unlabeled tree");

		Tr<String> t = new Br<String>(new Lf<String>("a"), new Br<String>(
				new Br<String>(new Lf<String>("b"), new Lf<String>("c")),
				new Lf<String>("d")));

		t.show(2);

		Tr<Scp<Integer, String>> result = MkM(t).s2scp(0).content;

		result.show(2);
	}

	private static StateMonad<Integer, Tr<Scp<Integer, String>>> MkM(
			Tr<String> t) {

		StateMonad<Integer, Scp<Integer, Tr<String>>> stateTree = StateMonad
				.unit(new Scp<Integer, Tr<String>>(0, t));

		if (t instanceof Lf<?>) {

		} else if (t instanceof Br<?>) {
			/**
			 * do leftSM <- MkM(t.left) rightSM <- MkM(t.right) return (Br
			 * leftSM rightSM)
			 */
			Br<String> br = (Br<String>) t;
			Tr<String> oldLeft = br.left;
			Tr<String> oldRight = br.right;

			return

			MkM(oldLeft)
					.bind((Tr<Scp<Integer, String>> leftSM) -> MkM(oldRight)
							.bind((Tr<Scp<Integer, String>> rightSM) -> {
								return new StateMonad<Integer, Tr<Scp<Integer, String>>>(
										(Integer s) -> {
											return new Scp<Integer, Tr<Scp<Integer, String>>>(
													s,
													new Br<Scp<Integer, String>>(
															rightSM, rightSM));
										});
							}));

		}
		return null;
	}

}
