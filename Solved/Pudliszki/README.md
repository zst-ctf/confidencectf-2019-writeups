# Pudliszki
RE

## Challenge 

For those who don't like all those pesky low-level reversing problems.

pudliszki-1.0-SNAPSHOT-jar-with-dependencies.zip

## Solution

Decompiled using CFR
https://www.benf.org/other/cfr/

	$ java -jar cfr-0.140.jar pudliszki-1.0-SNAPSHOT-jar-with-dependencies.jar --outputdir decompiled

We are faced with kotlin codes

Take a look at FlagCheckerKt.class

    public static final void main(@NotNull String[] args) {
    	//...
    	SizeResult sizeResult = SizeResultFactory.Companion.check($receiver.length, A.class);
        if (!(sizeResult instanceof Correct)) {
            if (!(sizeResult instanceof Incorrect)) return;
            String string = "Failed";
            System.out.print((Object)string);
            int n2 = -1;
            System.exit(n2);
            throw (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        if (FlagCheckerKt.validateFlag($receiver[0]) == 0) {
            String string = "Nice!";
            System.out.print((Object)string);
            return;
        }
        //...
    }

We notice that it calls `validateFlag()`. Furthermore, it checks for the correct number of arguments using SizeResultFactory.java

	public final <T> SizeResult check(int i2, @NotNull Class<T> c2) {
            Intrinsics.checkParameterIsNotNull(c2, "c");
            return i2 == c2.getSimpleName().length() ? (SizeResult)Correct.INSTANCE : (SizeResult)Incorrect.INSTANCE;
    }

From here, we know that SizeResultFactory equates the input number to the length of the simple name of the class.

---

Likewise in validateFlag(), it checks for the flag length

    public static final int validateFlag(@NotNull String flag) {
    	//...
    	SizeResult sizeResult = SizeResultFactory.Companion.check(flag.length(), IllegalMonitorStateException.class);
        if (sizeResult instanceof Correct) {
            void $receiver$iv$iv;
            Sequence $receiver$iv22 = SequencesKt.mapIndexed(SequencesKt.filter(SequencesKt.map(StringsKt.asSequence(flag), validateFlag.1.INSTANCE), validateFlag.2.INSTANCE), validateFlag.3.INSTANCE);
            // ...
        }
        //...
    }

Hence:

- number of args == length of 'A' == 1
- flag.length == length of 'IllegalMonitorStateException' == 28

---

Under checksum() we see that it creates some classes.

    serializable = new Pair(Class.forName("team.p4.pudliszki." + String.valueOf(((Character)entry.getKey()).charValue())).newInstance(), FlagCheckerKt.compress((List)entry.getValue()));

Look at the decompilation, we see a few classes which extends Letter.java

	_.java
	{.java
	}.java
	0.java
	1.java
	4.java
	5.java
	7.java
	c.java
	e.java
	h.java
	i.java
	k.java
	l.java
	n.java
	p.java
	s.java
	t.java
	u.java

Those are the only possible characters of the flag

Let's verify it...

	$ java -jar pudliszki-1.0-SNAPSHOT-jar-with-dependencies.jar IllegalMonitorStateException
	Failed

	
	$ java -jar pudliszki-1.0-SNAPSHOT-jar-with-dependencies.jar p4{________________________}
	Not today

By trying `IllegalMonitorStateException` which has 28 chars, it shows us a `Failed`, but if we use 28 chars of the only possibble chars, we see that it falls through to `Not today`

Lastly, we are left to reverse the checksum function()

---

These are the observations so far.

1. validateFlag()
	- first, convert to Pairs of (Char, Index)
	- second, convert to (ASCII value, ArrayList of indices)
	- pass the list to checksum()

2. checksum()
	- first, convert to (Class instance of `team.p4.pudliszki.?`, FlagCheckerKt.compress(ArrayList of indices))
		+ FlagCheckerKt.compress will sum the array indices together
		+ and for each iteration multiply it by 32 first...
	- lastly, the following check is done

The final check simply does a sum of all the multiplication values of the `FlagCheckerKt.compress`-ed list.
 
	// ...
	serializable = 
	 bl2 instanceof p ? ((Number)entry.getSecond()).intValue() - 27040 : 
	(bl2 instanceof 4 ? ((Number)entry.getSecond()).intValue() - 1 : 
	(bl2 instanceof { ? ((Number)entry.getSecond()).intValue() - 2 :
	(bl2 instanceof 0 ? ((Number)entry.getSecond()).intValue() - 452 :
	(bl2 instanceof 1 ? ((Number)entry.getSecond()).intValue() - 327 : 
	(bl2 instanceof 5 ? ((Number)entry.getSecond()).intValue() - 17 : 
	(bl2 instanceof 7 ? ((Number)entry.getSecond()).intValue() - 22 : 
	(bl2 instanceof c ? ((Number)entry.getSecond()).intValue() - 23 : 
	(bl2 instanceof e ? ((Number)entry.getSecond()).intValue() - 21 : 
	(bl2 instanceof h ? ((Number)entry.getSecond()).intValue() - 786 : 
	(bl2 instanceof i ? ((Number)entry.getSecond()).intValue() - 16 : 
	(bl2 instanceof k ? ((Number)entry.getSecond()).intValue() - 643 : 
	(bl2 instanceof l ? ((Number)entry.getSecond()).intValue() - 486 : 
	(bl2 instanceof n ? ((Number)entry.getSecond()).intValue() - 8 : 
	(bl2 instanceof s ? ((Number)entry.getSecond()).intValue() - 11 : 
	(bl2 instanceof t ? ((Number)entry.getSecond()).intValue() - 5 : 
	(bl2 instanceof u ? ((Number)entry.getSecond()).intValue() - 25 : 
	(bl2 instanceof _ ? ((Number)entry.getSecond()).intValue() - 19849 : 
	(bl2 instanceof } ? ((Number)entry.getSecond()).intValue() - 27 :
	-1337))))))))))))))))));

	//...
	return CollectionsKt.sumOfInt((List)destination$iv$iv);

The return value must be equal to zero as seen in main()

	// return value of checksum() is passed to validateFlag()
	// and then returned to main()
	if (FlagCheckerKt.validateFlag($receiver[0]) == 0) {
        String string = "Nice!";
        System.out.print((Object)string);
        return;
    }

So this means I can simply condense the list and do some reverse multiplications

---

Start with the original values

	char | values
	p | 27040
	4 | 1   * simple
	{ | 2   * simple
	0 | 452
	1 | 327
	5 | 17  * simple
	7 | 22  * simple
	c | 23  * simple
	e | 21  * simple
	h | 786
	i | 16  * simple
	k | 643
	l | 486
	n | 8   * simple
	s | 11  * simple
	t | 5   * simple
	u | 25  * simple
	_ | 19849
	} | 27  * simple

Since length is 28 (index 0 through 27), I marked extracted "simple" chars out. [ie. chars that are used only once]

	Index Tens: 0000000000111111111122222222
	Index Ones: 0123456789012345678901234567
	Flag      : p4{  t  n  s    i5   e7c u }

	Empty Index: [3, 4, 6, 7, 9, 10, 12, 13, 14, 15, 18, 19, 20, 24, 26]

We are left with these

	char | values
	p | 27040
	0 | 452    *Two chars
	1 | 327    *Two chars
	h | 786    *Two chars
	k | 643    *Two chars
	l | 486    *Two chars
	_ | 19849

I assume that those with 3 digits are corresponding to 2 char positions.

Using python script to bruteforce the 2 char position. I couldn't get the 3 position ones to work so I didn't bother

	# as inside the compress() function
	# eqn: p1 + 32 * p2

```python
def find(val):
	pos = [3, 4, 6, 7, 9, 10, 12, 13, 14, 15, 18, 19, 20, 24, 26]
	for p1 in pos:
		for p2 in pos:
			if val == (p1 + p2*32):
				return (p1,p2)

>>> find(452) # 0
(4, 14)
>>> find(327) # 1
(7, 10)
>>> find(786) # h
(18, 24)
>>> find(643) # k
(3, 20)
>>> find(486) # l
(6, 15)

```

So now fill it in

	Index Tens: 0000000000111111111122222222
	Index Ones: 0123456789012345678901234567
	Flag      : p4{k0tl1n 1s  0li5h ke7chu }

	Empty Index: [9, 12, 13, 26]

--- 

Let's simply make an intelligent guess

- Last one, 3 positions of p and underscore

This leaves us with the flag

	p4{k0tl1n 1s  0li5h ke7chu }
	p4{k0tl1n_1s_p0li5h_ke7chup}

## Flag

	p4{k0tl1n_1s_p0li5h_ke7chup}
