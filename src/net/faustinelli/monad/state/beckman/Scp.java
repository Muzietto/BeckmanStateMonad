package net.faustinelli.monad.state.beckman;

import java.text.MessageFormat;

public class Scp<S,A> {

	public S state;
	public A content;

	public Scp(S i,A t) {
		this.state = i;
		this.content = t;
	}

	@Override
	public String toString() {

		String template = "State: {0}, Content: {1}";
		return MessageFormat.format(template, state, content.toString());
	}
}
