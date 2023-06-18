"""
ID: anandme1
LANG: PYTHON3
TASK: gift1
"""

with open('gift1.in', 'r') as fin:
     res = fin.read().splitlines()
i: int = 0
n: int = int(res[i])

gift_map = {}
i += 1
name_idx = []
while i <= n:
     gift_map[res[i]] = 0
     name_idx.append(res[i])
     i+= 1


while i < len(res):
    giver_idx = i
    i+= 1
    amts = list(map(int, res[i].split(" ")))
    money_dist = (amts[0] // amts[1] if amts[1] > 0 else amts[0])
    rem = money_dist * amts[1]
    gift_map[res[giver_idx]] = gift_map[res[giver_idx]] - rem 
    last_idx = i + amts[1]
    i += 1
   
    while i <= last_idx:
        gift_map[res[i]] = gift_map[res[i]] + money_dist
        i += 1

with open('gift1.out', 'w') as fout:
    for i in range(0, len(name_idx)):
        fout.writelines(f"{name_idx[i]} {gift_map[name_idx[i]]}\n")