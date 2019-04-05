#!/usr/bin/env python3
from Crypto.Cipher import AES


def xor_bytes(a1, b1):
    encrypted = [ (a ^ b) for (a,b) in zip(a1, b1) ]
    return bytes(encrypted)


def chunk(input_data, size):
    return [input_data[i:i + size] for i in range(0, len(input_data), size)]

flag = ""
plaintext = """The Song of the Count

You know that I am called the Count
Because I really love to count
I could sit and count all day
Sometimes I get carried away
I count slowly, slowly, slowly getting faster
Once I've started counting it's really hard to stop
Faster, faster. It is so exciting!
I could count forever, count until I drop
1! 2! 3! 4!
1-2-3-4, 1-2-3-4,
1-2, i love couning whatever the ammount haha!
1-2-3-4, heyyayayay heyayayay that's the sound of the count
I count the spiders on the wall...
I count the cobwebs in the hall...
I count the candles on the shelf...
When I'm alone, I count myself!
I count slowly, slowly, slowly getting faster
Once I've started counting it's really hard to stop
Faster, faster. It is so exciting!
I could count forever, count until I drop
1! 2! 3! 4!
1-2-3-4, 1-2-3-4, 1,
2 I love counting whatever the
ammount! 1-2-3-4 heyayayay heayayay 1-2-3-4
That's the song of the Count!
""" + flag


with open('output.txt') as f:
    enc_file = f.read()
    enc = bytes.fromhex(enc_file)

plaintext = plaintext.encode()

chunk_pt = chunk(plaintext, 16)
chunk_ct = chunk(enc, 16)

keystreams = []
for i, (pt, ct) in enumerate(zip(chunk_pt, chunk_ct)):
    keystream = xor_bytes(pt, ct)
    print(f'chunk {i}: keystream', keystream)

    if keystream not in keystreams:
        keystreams.append(keystream)

for ks_i, keystream in enumerate(keystreams):
    for dc_i in range(1, 5):
        dec = xor_bytes(keystream, chunk_ct[-dc_i])
        print(f'keystream {ks_i} -> decode index {dc_i}:', dec)
    


