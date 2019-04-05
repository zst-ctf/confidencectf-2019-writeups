flag = int("test_flag".encode("hex"),16)
ranges = int(log(flag,2))
print 'ranges', ranges
p = next_prime(ZZ.random_element(2^15, 2^16))
k = 100
N = p^k
d = 5
P.<x> = PolynomialRing(Zmod(N), implementation='NTL')
pol = 0
for c in range(d):
    pol += ZZ.random_element(2^ranges, 2^(ranges+1))*x^c
print 'pol1', pol
remainder = pol(flag)
pol = pol - remainder

print 'pol2', pol
print 'remainder', remainder

print '---'
constant = pol(0)
print 'N', N
print 'constant + remainder', constant+remainder

assert pol(flag) == 0

print(p)
print(pol)