package application.aspect;

import application.dtos.UpdateTransactionDTO;
import application.persistence.entities.Transaction;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class loggingAspect {

    @Pointcut("execution(* application.controllers.SaleController.UpdateTransaction(..))")
    public void logSales(){

    }

    @Before(value =  "logSales() && args(saleId,transId,dto)")
    public void getTransactionDateBeforeUpdate(Long saleId, Long transId, UpdateTransactionDTO dto){

    }

    @AfterReturning(value = "logSales() && args(saleId,transId,dto)",
            returning = "res")
    public void getTransactionDataAfterUpdate(Long saleId, Long transId, UpdateTransactionDTO dto, Transaction res){

    }


}
