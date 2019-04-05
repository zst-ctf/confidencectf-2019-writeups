# Really Suspicious Acronym
Crypto

## Challenge 

## Solution

https://crypto.stackexchange.com/questions/62904/rsa-deduce-the-public-key-from-message-signed-message


	C1 = M1^e % N
	M1^e - C1 = k1*N

	C2 = M2^e % N
	M2^e - C2 = k2*N

	Find N using GCD(k1*N, k2*N)

gcd 34825223743402829383680359547814183240817664070909938698674658390374124787235739502688056639022131897715513587903467527066065545399622834534513631867145432553730850980331789931667370903396032758515681278057031496814054828419443822343986117760958186984521716807347123949922837482460532728350223473430713058522361175980521908817215812291272284241848086260180382693014713901303747444753828636575351349026883294939561001468099252543181336195746032718177937417431101756313823635150129601855358558635996348271242920308406268552606733676301725088348399264293936151662467456410825402303921583389167882090767423931762347825907802328053



https://github.com/p4-team/ctf/tree/master/2017-09-02-tokyo/crypto_rsa

https://github.com/p4-team/ctf/tree/master/2017-09-02-tokyo/crypto_rsa

	tmp = randint(2**1023, 2**1024)
	e = 65537
	p = next_prime(0xDEAD*tmp+randint(2, 2**500))
	q = next_prime(0xBEEF*tmp+randint(2, 2**500))

Let tmp be r for brevity...

	N = (0xDEAD*r + delta1) * (0xBEEF*r + delta2)

	where deltas are reasonably small since
	1. randint(2, 2**500) is much smaller than tmp
	2. difference to next_prime() is small as well

	Approximate from the high bits point of view
	N = 0xDEAD * 0xBEEF * r * r

Do approximation of r (where high bits are correct)

	r_approx = gmpy2.iroot(N / 0xDEAD / 0xBEEF)


-----

after competition
https://amritabi0s.wordpress.com/2019/03/18/confidence-teaser-ctf-crypto-writeups/
https://github.com/ashutosh1206/Crypton/tree/master/RSA-encryption/Attack-Coppersmith
https://grosquildu.github.io/writeups/2019/03/17/confidence-ReallySuspiciousAcronym/



## Flag

	??