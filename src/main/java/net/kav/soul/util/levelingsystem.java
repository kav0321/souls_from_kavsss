package net.kav.soul.util;

import static java.lang.Math.pow;

public class levelingsystem {


    private static long req;

    public static long reqcal(int level)
    {
        req= (long) (3.2961*pow(level,2.2139));
        return req;
    }
}
