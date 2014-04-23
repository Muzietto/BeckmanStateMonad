package net.faustinelli.monad.state.beckman;

@FunctionalInterface
public interface State<S, A> {

	public Scp<S, A> s2scp(S state);
}
