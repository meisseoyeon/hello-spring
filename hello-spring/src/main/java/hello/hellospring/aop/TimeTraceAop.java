package hello.hellospring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //어디에 적용할건지 hellopspring 패키지 안에는 다 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString()); //()안에 어떤 메소드를 콜하는지 이름을 다 얻을 수 있다
        try {
            return joinPoint.proceed(); // 진짜 클래스를 가져오는 것
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms"); //()안에 어떤 메소드를 콜하는지 이름을 다 얻을 수 있다
        }


    }
}
