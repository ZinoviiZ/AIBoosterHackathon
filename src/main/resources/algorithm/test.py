import os
import binascii
import sys 	
print os.stat(sys.argv[1]).st_size
#with open('test.bmp', 'rb') as f:
#    data = bytearray(f.read())
#    print(data)
