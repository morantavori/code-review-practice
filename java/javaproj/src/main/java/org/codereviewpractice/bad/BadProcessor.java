package org.codereviewpractice.bad;

import java.util.*;

public class BadProcessor {

    private final BadFilter f = new BadFilter();
    private final BadAggregator a = new BadAggregator();
    private final BadCounter c = new BadCounter();
    private final BadEnricher e = new BadEnricher();

    public Map<String, Integer> process(
            List<String> l,
            boolean flag,
            Set<String> known,
            List<String> add1,
            Set<String> add2,
            boolean log,
            String user
    ) {
        List<String> filtered = f.doFilter(l, known, flag);
        a.add(filtered, BadGlobals.results);
        c.count(filtered);
        maybeLog(filtered, log); // now part of this class
        e.doStuff(add1, add2, flag, user);
        return BadGlobals.results;
    }

    private void maybeLog(List<String> stuff, boolean should) {
        if (should == true) {
            System.out.println("Did stuff with: " + stuff);
        }
    }
}
