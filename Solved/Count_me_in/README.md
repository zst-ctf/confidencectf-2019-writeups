# Count me in
Crypto

## Challenge 

I've been lately using this cool AES-CTR, but it was super slow, so I made a parallel version. Now it's blazing fast, but for some reason I have trouble decrypting the data...

count.py
output.txt

## Solution

Observations:

- plaintest is padded until it is multiple of 16 bytes, then split into 16 bytes chunks 

- this means that each counter encryption is 32 bytes, where
	+ `aes_ecb(count) = keystream`
	+ `output = keystream XOR chunk = output`

- since the code is running in parallel, there may be synchronisation issues
	+ keystreams may be reused if count increment is not sycronised


So in my initial test, it works. There are reused keystreams

	$ python3 solve.py 
	chunk 0: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 1: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 2: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 3: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 4: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 5: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 6: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 7: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 8: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 9: keystream b'\xc94\x03\xc6\x0c\xc1\xfc\xc8\xbc\xe53\xf9\xa7\xd7\x01.'
	chunk 10: keystream b'1J\xc7(\x85\xf1y\xd75\x0f\xdf\x0c\xfeAo\x95'
	chunk 11: keystream b'1J\xc7(\x85\xf1y\xd75\x0f\xdf\x0c\xfeAo\x95'
	chunk 12: keystream b'1J\xc7(\x85\xf1y\xd75\x0f\xdf\x0c\xfeAo\x95'
	...

Now, collect all keystreams and then XOR it with the trailing chunks

	keystream 6 -> decode index 1: b'\x97\x97\xfa\xc1k\xc2!\xea%a\xfd\xfc\xc3\xc7\x9c\xe8'
	keystream 6 -> decode index 2: b'\xa7\x8d\xe6\xdew\xf1$\xf8X\x07\x81\xab\xa4\xa1\xcb\x99'
	keystream 6 -> decode index 3: b'_the_day_you_can'
	keystream 6 -> decode index 4: b'p4{at_the_end_of'
	keystream 7 -> decode index 1: b'ourself}\x08\x08\x08\x08\x08\x08\x08\x08'
	keystream 7 -> decode index 2: b'_only_count_on_y'
	keystream 7 -> decode index 3: b'\xa7\x96\xe0\xd7Q\xca&\xeer\x10\x9a\x81\x94\xac\xf5\x8e'
	keystream 7 -> decode index 4: b'\x88\xd6\xf3\xd3z\xf13\xffH6\x90\x9a\xaf\x90\xfb\x86'

And we see the flag at the index

	index [-4]: p4{at_the_end_of
	index [-3]: _the_day_you_can
	index [-2]: _only_count_on_y
	index [-1]: ourself}


## Flag

	p4{at_the_end_of_the_day_you_can_only_count_on_yourself}
