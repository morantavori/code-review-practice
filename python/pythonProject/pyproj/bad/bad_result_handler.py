def bumpValues(out_dict, keys):
    for k in keys:
        if k in out_dict:
            out_dict[k] += 1
        else:
            out_dict[k] = 1
    return out_dict


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
