# verylargenumber
The library to support of arithmetics for very big numbers

[![Build Status](https://secure.travis-ci.org/javadev/verylargenumber.png)](https://travis-ci.org/javadev/verylargenumber)
[![Coverage Status](https://coveralls.io/repos/javadev/verylargenumber/badge.png?branch=master)](https://coveralls.io/r/javadev/verylargenumber)

This library theoretically may support arithmetics for numbers with any number of digits, even thousands or millions (the number of digits is limited by abilities of client's JVM). This is simple implementation of school arithmetics rules and nothing more.

This library is named "Slowpoke" in honor of famous pokemon and because it's implementation is really slow and ugly, because author have not mattered about performance, memory consumption and multithreading in the 1st version. But real problem will be exposed by future stress tests.

How to use it?

Very simple:

String addResultStr = VeryLargeNumber.add(arg1Str, arg2Str);

String subResultStr = VeryLargeNumber.sub(arg1Str, arg2Str);

String mulResultStr = VeryLargeNumber.mul(arg1Str, arg2Str);

String divResultStr = VeryLargeNumber.div(arg1Str, arg2Str);

int compareResult = VeryLargeNumber.compareAbs(arg1Str, arg2Str);

If compareResult is zero, then numbers are equal. If compareResult is less than zero, the 1st number is less then 2nd. If compareResult is greater than zero, the 1st number is greater then 2nd.

In every case if argument is not parsable decimal number, it is treated as zero. If you try to divide by zero, method throws an exception.
