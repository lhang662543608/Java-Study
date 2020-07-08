package Spring4.aop.annotation;

/**
 * @author lhang
 * @create 2020-07-08 10:39
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 使用@order 指定切面的优先级 ，值越小，优先级有高。
 * 把这个类声明为一个切面：需要把该类放到IOC容器中，
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式，一般的，该方法中再不需要填入其他的的代码
     */
    @Pointcut("execution(* Spring4.aop.annotation.*.*(int,int))")
    public void declareJoinPointExpression(){ }
    /**
     * 声明该方法为一个前置通知：在目标方法开始之前执行
     */
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    /**
     * 后置通知；在目标方法执行后（无论是否发生异常），执行的通知。
     * 在后置通知中还不能访问目标方法执行的结果。
     */
    @After("declareJoinPointExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值的！
     */
    @AfterReturning(value = "declareJoinPointExpression()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定在出现特定异常时在执行通知代码
     */
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception: " + ex);
    }

    /**
     * 环绕通知需要携带ProceedingJoinPost类型的参数。
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法。
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值。
     */
    /*@Around("execution(* Spring4.aop.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable ex) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception: " + ex);
            throw new RuntimeException(ex);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");
        return result;
    }*/

}
