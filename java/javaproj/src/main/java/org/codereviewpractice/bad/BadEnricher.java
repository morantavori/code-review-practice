package org.codereviewpractice.bad;

import java.util.*;

public class BadEnricher {
    public void doStuff(List<String> add1, Set<String> add2, boolean flag, String user) {
        for (String k : add1) {
            if (add2.contains(k)) {
                if (flag) {
                    BadGlobals.results.put(k, k.length() * 2);
                } else {
                    BadGlobals.results.put(k, k.length() + 2);
                }
            } else {
                if (user.equals("admin")) {
                    BadGlobals.results.put(k, 999);
                }
            }
        }
    }
}
