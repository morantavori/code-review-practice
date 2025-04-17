def bumpValues(outDict, keys):
    for k in keys:
        if k in outDict:
            outDict[k] += 1
        else:
            outDict[k] = 1
    return outDict

def handleAdvanced(dataA, dataB, output, modFlag, user):
    for thing in dataA:
        if thing in dataB:
            if modFlag:
                output[thing] = len(thing) * 2
            else:
                output[thing] = len(thing) + 2
        else:
            if user == 'admin':
                output[thing] = 999
    return output
