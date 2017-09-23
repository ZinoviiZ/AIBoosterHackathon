import os
import binascii
with open('test.bmp', 'rb') as f:
    data = bytearray(f.read())
    print(data)