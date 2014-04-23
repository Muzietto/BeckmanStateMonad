package net.faustinelli.monad.state.beckman;

public class MonadicLabeling {

	public static void main(String[] args) {

		System.out.println("unlabeled tree");

		Tr<String> t = new Br<String>(new Lf<String>("a"), new Br<String>(
				new Br<String>(new Lf<String>("b"), new Lf<String>("c")),
				new Lf<String>("d")));

		t.show(2);

		Tr<Scp<Integer, String>> result = xxx(t);

		result.show(2);
	}

	private static Tr<Scp<Integer, String>> xxx(Tr<String> t) {

		StateMonad<Integer, Scp<Integer, Tr<String>>> stateTree = StateMonad
				.unit(new Scp<Integer, Tr<String>>(0, t));

		
		
		return null;
	}

}
