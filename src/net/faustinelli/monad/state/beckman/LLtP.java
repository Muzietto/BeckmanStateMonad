package net.faustinelli.monad.state.beckman;

/**
 * Pair<Label,LabeledTree>
 */
public class LLtP<A> {

	public int lltplabel;
	public Tr<Scp<A>> lltpTree;

	public LLtP(int lltplabel, Tr<Scp<A>> lltpTree) {
		this.lltplabel = lltplabel;
		this.lltpTree = lltpTree;
	}

}
