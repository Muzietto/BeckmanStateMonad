package net.faustinelli.monad.state.beckman;

/**
 * Pair<Label,LabeledTree> - label is the state
 * 
 * this class is necessary for explicit (non-monadic) tree labeling
 */
public class LLtP<S, A> {

	public S lltplabel;
	public Tr<Scp<S, A>> lltpTree;

	public LLtP(S lltplabel, Tr<Scp<S, A>> lltpTree) {
		this.lltplabel = lltplabel;
		this.lltpTree = lltpTree;
	}

}
