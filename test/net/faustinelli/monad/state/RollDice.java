package net.faustinelli.monad.state;

import java.util.function.Function;

/**
 * 
 * @author Marco Faustinelli <contacts@faustinelli.net>
 *
 */
public class RollDice {

	public static void main(String[] args) {

		// A = Integer
		Function<Integer, StateMonad<Integer, Integer>> f0ma = (Integer x) -> StateMonad
				.UNIT(x + 1);

		// B = Scp<Integer,Integer>
		Function<Integer, StateMonad<Integer, Scp<Integer, Integer>>> famb = (
				Integer x) -> StateMonad.UNIT(new Scp<Integer, Integer>(x, x + 1));

		StateMonad<Integer, Integer> firstMonad = f0ma.apply(0);

		StateMonad<Integer, Scp<Integer, Integer>> secondMonad = firstMonad.bind(famb);

		System.out.println(secondMonad.s2scp(0));
	}
}
