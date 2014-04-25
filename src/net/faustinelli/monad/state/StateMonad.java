package net.faustinelli.monad.state;

import java.util.function.Function;

public class StateMonad<S, A> {

	private Function<S, Scp<S, A>> s2scp;

	public StateMonad(Function<S, Scp<S, A>> s2scp) {
		this.s2scp = s2scp;
	}

	public Scp<S, A> s2scp(S state) {
		return this.s2scp.apply(state);
	}

	/**
	 * UNIT
	 */
	public static <S, A> StateMonad<S, A> UNIT(A a) {

		return new StateMonad<S, A>((S s) -> new Scp<S, A>(s, a));
	}

	/**
	 * BIND
	 * 
	 * @param <B>
	 */
	public <B> StateMonad<S, B> bind(final Function<A, StateMonad<S, B>> famb) {

		return new StateMonad<S, B>((S s) -> {

			Scp<S, A> xxx = this.s2scp(s);

			StateMonad<S, B> yyy = famb.apply(xxx.content);

			return yyy.s2scp(xxx.state);
		});
	}

}
