package com.itheima.demo02_concurrent_problem;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
@Outcome(id = {"1"}, expect = Expect.ACCEPTABLE, desc = "ok")
@Outcome(id = {"4"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "danger2")
@Outcome(id = "0", expect = Expect.ACCEPTABLE_INTERESTING, desc = "danger")
@State
public class Test03Ordering {
    private Object obj = new Object();
    volatile int num = 0;
    volatile boolean ready = false;
    // 线程1执行的代码
    @Actor
    public void actor1(I_Result r) {
            if (ready) {
                r.r1 = num + num;
            } else {
                r.r1 = 1;
            }
    }

    // 线程2执行的代码
    @Actor
    public void actor2(I_Result r) {
            num = 2;
            ready = true;
    }
}
