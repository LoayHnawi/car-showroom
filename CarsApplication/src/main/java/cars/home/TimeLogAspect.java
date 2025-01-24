package cars.home;

import org.aspectj.lang.ProceedingJoinPoint;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Slf4j
public class TimeLogAspect {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());
    @Around("@annotation(cars.home.Timed) && execution(public * *(..))")
    public Object time(final ProceedingJoinPoint ProceedingJoinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        Object value;

        try {
            value =ProceedingJoinPoint.proceed();
        }
        catch(Throwable throwable) {
            throw throwable;
        }
        finally {

            long duration = System.currentTimeMillis() - start;
            logger.log(Level.INFO,"{}.{} took {} ms"
                    + "ProceedingJoinPoint.getSignature().getDeclaringType().getSimpleName()"
                    +"ProceedingJoinPoint.getSignature().getName()" + duration);
        }
        return value;
    }
}
