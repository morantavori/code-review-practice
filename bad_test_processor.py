from pyproj.bad.bad_filtering import collectRelevant
from pyproj.bad.bad_result_handler import bumpValues, handleAdvanced

globCounter = 0


def runProcess(items, flag1, knownSet, addl1, addl2, doPrint, resultsDict, usr):
    stage1 = collectRelevant(items, knownSet, flag1)
    bumpValues(resultsDict, stage1)

    if doPrint == True:
        print("Items Processed >>>", stage1)

    if len(addl1) > 0:
        handleAdvanced(addl1, addl2, resultsDict, flag1, usr)

    global globCounter
    globCounter += len(stage1)

    return resultsDict
