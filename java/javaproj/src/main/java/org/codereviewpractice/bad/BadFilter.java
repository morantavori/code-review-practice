package org.codereviewpractice.bad;

import java.util.*;

public class BadFilter {
    public List<String> doFilter(List<String> l, Set<String> known, boolean flag) {
        List<String> temp = new ArrayList<>();
        for (String t : l) {
            if (!known.contains(t)) {
                if (flag) {
                    temp.add(t);
                } else {
                    temp.add(new StringBuilder(t).reverse().toString());
                }
            }
        }
        maybeLog(l, true);
        return temp;
    }

    private void maybeLog(List<String> stuff, boolean should) {
        if (should == true) {
            System.out.println("Did stuff with: " + stuff);
        }
    }
}
