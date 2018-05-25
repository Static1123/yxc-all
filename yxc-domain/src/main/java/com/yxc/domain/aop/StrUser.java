package com.yxc.domain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Static
 */
@Aspect
public class StrUser {
    @Before(value = "execution(* com.yxc.domain.pojo.User.*(..))")
    public void strBefore() {
        System.out.println("------Before Strength UserClass------");
    }

    @After(value = "execution(* com.yxc.domain.pojo.User.*(..))")
    public void strAfter() {
        System.out.println("------After Strength UserClass------");
    }

    public void strAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("------Before around------");
        proceedingJoinPoint.proceed();
        System.out.println("------After around------");
    }
}