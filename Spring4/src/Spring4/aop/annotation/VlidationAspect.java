package Spring4.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lhang
 * @create 2020-07-08 19:20
 */

/**
 * 使用@order 指定切面的优先级 ，值越小，优先级有高。
 */
@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("Spring4.aop.annotation.LoggingAspect.declareJoinPointExpression()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("validate: " + Arrays.asList(joinPoint.getArgs()));

    }
}
