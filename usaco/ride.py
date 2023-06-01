"""
ID: your_id_here
LANG: PYTHON3
TASK: ride
"""

fin = open ('ride.in', 'r')
fout = open ('ride.out', 'w')
comet, group = map(str, fin.readline().split())
cometInt: int = 1
for str in comet:
    cometInt *= ord(str) - ord('A')

groupInt: int = 1

for str in group:
     groupInt *= ord(str) - ord('A')
res: str = 'GO' if cometInt % 47 == groupInt % 47 else 'STAY'
fout.write (res + '\n')
fout.close()

