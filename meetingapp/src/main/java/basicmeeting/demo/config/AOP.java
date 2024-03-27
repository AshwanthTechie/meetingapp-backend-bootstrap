package basicmeeting.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@Aspect
public class AOP {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Before(value = "execution(* basicmeeting.demo.controller.*.*(..)) ")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info("AOP executed before controller");
    }
    @After(value = "execution(* basicmeeting.demo.controller.*.*(..)) ")
    public void afterAdvice(JoinPoint joinPoint){
        logger.info("AOP executed after controller");
    }
    @Before(value = "execution(* basicmeeting.demo.controller.*.*(..)) and args(objects)")
    public void beforeparamAdvice(JoinPoint joinPoint,int objects){
        //System.out.println("id : ",objects);
        logger.info("AOP executed before controller with parameter");
    }
    @AfterReturning(value = "execution(* basicmeeting.demo.controller.HostController.getinfoid(..)) ")
    public void AfterReturningAdvice(JoinPoint joinPoint){
        logger.info("AOP executed after returning controller");
    }
    @Around(value = "execution(* basicmeeting.demo.controller.*.*(..))")
    public Object AroundAdvice(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("Before Executing controller(Around): "+joinPoint.getSignature().toString());
        Object result=joinPoint.proceed();
        System.out.println("After Executing Controller(Around): "+joinPoint.getSignature().toString());    
        return result;

    }
}
