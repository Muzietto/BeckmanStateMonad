package net.faustinelli.monad.state.beckman;

import net.faustinelli.monad.state.Scp;
import net.faustinelli.monad.state.StateMonad;

/**
 * 
 * @author Marco Faustinelli <contacts@faustinelli.net>
 *
 */public class MonadicLabeling {

	public static void main(String[] args) {

		System.out.println("unlabeled tree");

//		Tr<String> t = new Lf<String>("a");

		Tr<String> t = new Br<String>(new Lf<String>("a"), new Br<String>(
				new Br<String>(new Lf<String>("b"), new Lf<String>("c")),
				new Lf<String>("d")));

		t.show(2);

		StateMonad<Integer, Tr<Scp<Integer, String>>> treeMonad = MkM(t);
		
		Tr<Scp<Integer, String>> result = treeMonad.s2scp(new Integer(0)).content;

		result.show(2);
	}

	private static StateMonad<Integer, Tr<Scp<Integer, String>>> MkM(
			Tr<String> t) {

		/**
		 * n -> (n+1,n) : Integer -> (Integer,Integer)
		 * It may be bound to famb :
		 * Integer -> StateMonad<Integer,B>
		 */
		StateMonad<Integer, Integer> updateState = new StateMonad<Integer, Integer>(
				n -> new Scp<Integer, Integer>(n + 1, n));

		if (t instanceof Lf<?>) {

			Lf<String> leaf = (Lf<String>) t;
			
			return

			updateState.bind((Integer state) -> new StateMonad<Integer, Tr<Scp<Integer, String>>>((
						Integer s) -> new Scp<Integer, Tr<Scp<Integer, String>>>(s,
							new Lf<Scp<Integer, String>>(
									new Scp<Integer, String>(state,
											leaf.contents)))));

		} else if (t instanceof Br<?>) {
			/**
			 * do
			 *  leftSM <- MkM(t.left)
			 *  rightSM <- MkM(t.right) 
			 * return (Br leftSM rightSM)
			 */
			Br<String> br = (Br<String>) t;
			Tr<String> oldLeft = br.left;
			Tr<String> oldRight = br.right;
			
			return

			MkM(oldLeft)
					.bind((Tr<Scp<Integer, String>> leftSM) -> MkM(oldRight)
							.bind((Tr<Scp<Integer, String>> rightSM) -> new StateMonad<Integer, Tr<Scp<Integer, String>>>(
										(Integer s) -> new Scp<Integer, Tr<Scp<Integer, String>>>(
													s,
													new Br<Scp<Integer, String>>(
															leftSM, rightSM)))));

		} else {
			throw new RuntimeException("Lab/Label: impossible tree subtype");
		}
	}
}
