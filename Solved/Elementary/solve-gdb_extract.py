#!/usr/bin/env python

import string
from pwn import *
context(terminal = ['bash'])

def main():
    elementary = process(['gdb', './elementary'])

    # Break program before it runs, so we can hijack it
    elementary.recvuntil('(gdb)')
    elementary.sendline('break main')
    elementary.recvuntil('(gdb)')
    elementary.sendline('run')

    # Dynamically scan functions
    dictionary = dict()
    for func_num in range(0, 831 + 1):
        elementary.recvuntil('(gdb)')

        func_name = 'function' + str(func_num)
        command = 'printf "%d\\n", (int) FUNC_NAME(0)'.replace('FUNC_NAME', func_name)
        elementary.sendline(command)

        result = elementary.recvuntil('\n').strip()
        print(func_name + ' -> ' + result)

        dictionary[func_num] = int(result)

    print('gdb_dict = ' + str(dictionary).replace(' ', ''))

    elementary.kill()

if __name__ == '__main__':
    main()
