def collectRelevant(things, known, reverseFlag):
    tList = []
    for t in things:
        if t not in known:
            if reverseFlag:
                tList.append(t)
            else:
                tList.append(t[::-1])
    return tList
