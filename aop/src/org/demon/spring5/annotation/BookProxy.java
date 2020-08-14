package org.demon.spring5.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookProxy {

    // 抽取公共切入点
    @Pointcut(value = "execution(* org.demon.spring5.annotation.Book.add(..))")
    public void pointCut(){

    }

    /**
     * 前置通知，在目标方法执行之前执行。
     */
    @Before(value = "pointCut()")
    public void before(){
        System.out.println("before ...");
    }

    /**
     * 最终通知，无论目标方法是否正常结束，都会执行该方法。
     */
    @After(value = "pointCut()")
    public void after(){
        System.out.println("after ... ");
    }

    /**
     * 后置通知，目标方法正常结束，执行该方法。
     */
    @AfterReturning(value = "pointCut()")
    public void afterReturning(){
        System.out.println("after returning ... ");
    }

    /**
     * 异常通知，目标方法抛出异常，执行该方法。
     */
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(){
        System.out.println("after throwing ... ");
    }

    /**
     * 环绕通知，即在目标方法前后的增强都可以写在该方法中
     * 目标方法发生异常不会继续执行，即 proceed 方法后的代码不会执行。
     * @param proceedingJoinPoint 用于执行目标方法
     * @throws Throwable
     */
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before ... ");
        proceedingJoinPoint.proceed();
        System.out.println("around after ...");
    }
}
