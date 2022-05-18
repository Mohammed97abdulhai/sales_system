package application.aspect;


import application.dtos.response.DetailedResponse;
import application.exceptions.ResourceNotFound;
import application.exceptions.ValidationError;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class ResponseAspect {

    @Around("execution(* application.controllers.*.*(..))")
    public ResponseEntity logController(ProceedingJoinPoint jp) {
        long start = System.currentTimeMillis();
        ResponseEntity res;
        try {
            res = ResponseEntity.ok(jp.proceed());
        } catch (ResourceNotFound e) {
            res = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }  catch (ValidationError e) {
            res = ResponseEntity.badRequest().body(e.getErrors());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            res = new ResponseEntity(throwable.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity(new DetailedResponse(res, start), res.getStatusCode());

    }
}
