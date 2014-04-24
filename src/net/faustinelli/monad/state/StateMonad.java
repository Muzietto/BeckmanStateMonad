package net.faustinelli.monad.state;

import java.util.function.Function;

public class StateMonad<S, A> implements State<S, A> {

	@SuppressWarnings("unused")
	private Function<S, Scp<S, A>> s2scp;

	public StateMonad(Function<S, Scp<S, A>> s2scp) {
		this.s2scp = s2scp;
	}

	@Override
	public Scp<S, A> s2scp(S state) {
		return this.s2scp(state);
	}

	/**
	 * UNIT
	 */
	public static <S, A> StateMonad<S, A> unit(A a) {
		
		return new StateMonad<S, A>((S s) -> {
			return new Scp<S, A>(s, a);
		});
		
	}

	/**
	 * BIND
	 */
	public <B> StateMonad<S, B> bind(final Function<A, StateMonad<S, B>> famb) {

		return new StateMonad<S, B>((S s) -> {
			
			Scp<S, A> xxx = this.s2scp(s);

			return famb.apply(xxx.content).s2scp(xxx.state);
		});
	}
	
}
