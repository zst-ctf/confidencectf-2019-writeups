# Bro, do you even lift?
Crypto

## Challenge 

So I just rolled out my own crypto...

lift.sage
out.txt

## Solution

Important Code extracted

	p = next_prime(ZZ.random_element(2^15, 2^16))
	k = 100
	N = p^k
	d = 5
	P.<x> = PolynomialRing(Zmod(N), implementation='NTL')
	pol = 0
	for c in range(d):
	    pol += ZZ.random_element(2^ranges, 2^(ranges+1))*x^c
	remainder = pol(flag)
	pol = pol - remainder
	assert pol(flag) == 0

Observations:

- generated prime of 35671
- modulo 35671^100

Note that the printed function is as follows

> f(x) - f(flag) = output function

	12172655049735206766902704703038559858384636896299329359049381021748*x^4 + 11349632906292428218038992315252727065628405382223597973250830870345*x^3 + 9188725924715231519926481580171897766710554662167067944757835186451*x^2 + 8640134917502441100824547249422817926745071806483482930174015978801*x + 170423096151399242531943631075016082117474571389010646663163733960337669863762406085472678450206495375341400002076986312777537466715254543510453341546006440265217992449199424909061809647640636052570307868161063402607743165324091856116789213643943407874991700761651741114881108492638404942954408505222152223605412516092742190317989684590782541294253512675164049148557663016927886803673382663921583479090048005883115303905133335418178354255826423404513286728

And we see that the assertion is a hint

	assert pol(flag) == 0
	# pol is the output function

Log base 2 of the coefficients 

	log base 2 of 12172655049735206766902704703038559858384636896299329359049381021748
	= approx 222 bits

So we simply equate until `x = flag` which occurs when `pol(flag) == 0`


	Let original be pol1(x)
	pol1(x)    = Ex^4 + Dx^3 + Cx^2 + Bx + A 
	pol1(flag) = E*flag^4 + D*flag^3 + C*flag^2 + B*flag + A
	remainder = pol1(flag) 

	Let final be pol2(x)
	pol2(x) = pol1(x) - pol1(flag)
	pol2(x) = Ex^4 + Dx^3 + Cx^2 + Bx - (E*flag^4 + D*flag^3 + C*flag^2 + B*flag)

So we 




print(p)
print(pol)



## Flag

	??