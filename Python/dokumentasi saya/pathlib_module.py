from pathlib import Path
import time
path = Path('ecomers')

print(path.exists())          # <-- memriksa apakah folder ada atau tidak

path.mkdir()                  # <-- membuat direktory

print(path.exists())

time.sleep(3)
path.rmdir()                   # <-- menghapus directory

print(path.exists())

path_glob = Path()

print(path_glob.glob('*.py'))

for file in path_glob.glob('*.py'):
    print(file)
    

for file in path_glob.glob('*'):
    print(file)