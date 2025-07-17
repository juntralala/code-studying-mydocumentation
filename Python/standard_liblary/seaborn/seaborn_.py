'''
=> Terakhir adalah library seaborn yang termasuk jenis library dengan tujuan untuk visualisasi data sama
   seperti matplotlib. Bahkan library seaborn dibangun berdasarkan pada library matplotlib.
'''

import seaborn as sns
import matplotlib.pyplot as plt

tips = sns.load_dataset('tips')

# contoh plot histogram
sns.histplot(tips['total_bill'], kde=True)
plt.title("Histogram Total Bill")
plt.xlabel('Total Label')
plt.ylabel('Frequency')
plt.show()
