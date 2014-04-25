package net.faustinelli.monad.state;

import java.text.MessageFormat;

public class Scp<S, A> {

	public S state;
	public A content;

	public Scp(S state, A content) {
		this.state = state;
		this.content = content;
	}

	@Override
	public String toString() {

		String template = "State: {0}, Content: {1}";
		return MessageFormat.format(template, state, content.toString());
	}
}
