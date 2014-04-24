package net.faustinelli.monad.state;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonadLawsForStateMonad {

	/**
	 * left identity: \x -> unit(x) bind k = k
	 * or unit(x) bind k = k(x)
	 */
	@Test
	public void testLeftIdentity() {
		fail("Not yet implemented");
	}

	/**
	 * right identity: m bind unit = m
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRightIdentity() {

		StateMonad<Integer, Integer> ma = new StateMonad<Integer, Integer>(
				n -> new Scp<Integer, Integer>(n + 1, n));
		
		// The type of unit(Integer) from the type StateMonad is StateMonad<Object,Integer>, 
		// this is incompatible with the descriptor's return type: StateMonad<Integer,B>
		//StateMonad<Integer, Integer> result = ma.bind(StateMonad::unit);
	}

	/**
	 * associativity: (m bind h) bind k = m bind (\x -> h(x) bind k)
	 */
	@Test
	public void testAssociativity() {
		fail("Not yet implemented");
	}
}
