BeckmanStateMonad - RELEASE 1.0
========================
This is a Java 8 porting of the C# code prepared by Brian Beckman for his lesson about the state monad.
The example involves traversing a binary tree with String leaves and substituting each String with an Integer, each time incremented by one.

I have created chainable monads, where each instance is characterised by a s2scp (State to State-Content Pair) java.util.Function and by an instance method bind;
bind chains 'this' with a function which extracts the inner value of the present monad and produces a different StateMonad instance.

The only static method around is StateMonad.UNIT, which fulfills the role of 'return' in Haskell.

The repository features the following applications:
- Manual Labeling of the tree, without use of the monad
- Monadic Labeling of the tree, using the state monad - the attempt at using StateMonad.UNIT failed (*) and StateMonads are created explicitly composing their s2scp functions as lambdas
- RollDice, a simple composition of state monads created from scratch
- attempt at demonstrating the three monad laws in the case of this implementation - some problems still on the way

This repository is presented at:

http://faustinelli.wordpress.com/2014/04/25/the-state-monad-in-java-8-eventually/

STILL TO DO
-----------
- implementation of getState and putState
- further experiences to get a feel of the application of the monad
- (*) SOLVE ALL PROBLEMS WITH UNIT in ManualLabeling.java - apparently the substitution from StateMonad&lt;S,B&gt; into StateMonad&lt;Integer,Tr&lt;Scp&lt;Integer,String&gt;&gt;&gt; can't be managed by the compiler.

DEBITS AND CREDITS
------------------
I am in debt with:
- http://channel9.msdn.com/Shows/Going+Deep/Brian-Beckman-The-Zen-of-Expressing-State-The-State-Monad
- http://www.slideshare.net/dgalichet/scalaio-statemonad

Any feedback is welcome.
