package com.raj.search;

import java.math.BigInteger;

class Inverter {

    public final int FUNCTION_VALUE_IS_GREATER_THAN_RESULT = 1;
    public final int FUNCTION_VALUE_IS_LESS_THAN_RESULT = -1;
    public final int FUNCTION_VALUE_IS_EQUAL_TO_RESULT = 0;
    public BigInteger findInverse(Function f, BigInteger y) {
        BigInteger z = f.apply(y);
        BigInteger x = null;
        Limit limit = new Limit();
        if(isYLessThanZ(y,z)) {
            limit.lower = BigInteger.ZERO;
            limit.upper = y;
            x = binarySearch(f, limit, y);
        } else {
            limit = findLimits(f, y);
            x = binarySearch(f, limit, y);
        }
        return x;
    }

    private boolean isYLessThanZ(BigInteger y, BigInteger z) {
        return y.compareTo(z)<0;
    }

    public Limit findLimits(Function f, BigInteger y) {
        Limit limit = new Limit(y, y.multiply(BigInteger.valueOf(2L)));
        while (f.apply(limit.upper).compareTo(y) < 0) {
            limit = new Limit(limit.upper, limit.lower.multiply(BigInteger.valueOf(2L)));
        }
        return limit;
    }


    public BigInteger binarySearch(Function f, Limit limit, BigInteger resultValue) {
        if (limit.isLowerGreaterThanUpper()) {
            return null;
        }
        BigInteger mid = limit.mid();
        int compareToResult = f.apply(mid).compareTo(resultValue);
        if (compareToResult == FUNCTION_VALUE_IS_EQUAL_TO_RESULT) {
            return mid;
        }
        if (FUNCTION_VALUE_IS_GREATER_THAN_RESULT == compareToResult) {
            limit.upper = mid.subtract(BigInteger.ONE);
            return binarySearch(f, limit, resultValue);
        }
        if (FUNCTION_VALUE_IS_LESS_THAN_RESULT == compareToResult) {
            limit.lower = mid.add(BigInteger.ONE);
            return binarySearch(f, limit, resultValue);
        }
        return mid;
    }
}

class Limit {
    BigInteger upper;
    BigInteger lower;

    Limit(BigInteger lower, BigInteger upper) {
        this.lower = lower;
        this.upper = upper;
    }

    Limit() {

    }

    public BigInteger mid(){
        return (upper.add(lower)).divide(BigInteger.valueOf(2L));
    }

    public boolean isLowerGreaterThanUpper() {
        return lower.compareTo(upper)>0;
    }
}

interface Function {

    public BigInteger apply(BigInteger x);

}