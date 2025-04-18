def collectRelevant(things, known, reverse_flag):
    t_list = []
    for t in things:
        if t not in known:
            if reverse_flag:
                t_list.append(t)
            else:
                t_list.append(t[::-1])
    return t_list
