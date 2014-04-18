package net.faustinelli.monad.state.beckman;

import java.text.MessageFormat;

public class Scp<A> {

	public int label;
	public A lcpContents;

	public Scp(int i,A t) {
		this.label = i;
		this.lcpContents = t;
	}

	@Override
	public String toString() {

		String template = "Label: {0}, Contents: {1}";
		return MessageFormat.format(template, label, lcpContents.toString());
	}
}
