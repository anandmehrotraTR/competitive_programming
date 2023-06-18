"""
ID: anandme1
LANG: PYTHON3
TASK: ride
"""


# fin = open ('/Users/anandmehrotra/competitive_programming/usaco/ride.in', 'r')
with open('ride.in', 'r') as fin:
     res = fin.readlines()

comet, group  = res[0].rstrip(), res[1].rstrip()
# comet, group = map(str, fin.readline().split())
cometInt: int = 1
for str in comet:
    cometInt *= ord(str) - ord('A') + 1

groupInt: int = 1

for str in group:
     groupInt *= ord(str) - ord('A') + 1

res: str = 'GO' if cometInt % 47 == groupInt % 47 else 'STAY'

with open('ride.out', 'w') as fout:
    fout.writelines(res + '\n')

