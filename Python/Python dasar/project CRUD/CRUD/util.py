import random
import string

def randomString(panjang:int)->str:
    hasilString = "".join(random.choice(string.ascii_letters) for i in range(panjang))
    return hasilString