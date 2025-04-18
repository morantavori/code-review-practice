from pyproj.bad.bad_filtering import collectRelevant
from pyproj.bad.bad_result_handler import bumpValues, handleAdvanced

globCounter = 0


def runProcess(items, flag1, known_set, addl1, addl2, do_print, results_dict, usr):
    stage1 = collectRelevant(items, known_set, flag1)
    bumpValues(results_dict, stage1)

    if do_print == True:
        print("Items Processed >>>", stage1)

    if len(addl1) > 0:
        handleAdvanced(addl1, addl2, results_dict, flag1, usr)

    global globCounter
    globCounter += len(stage1)

    return results_dict
