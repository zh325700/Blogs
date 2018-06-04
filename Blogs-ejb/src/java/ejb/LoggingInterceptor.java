/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

/**
 *
 * @author zhanghan
 */
import java.io.Serializable;
import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor implements Serializable{

    @AroundInvoke
    public Object logMethodCall (
            InvocationContext invocationContext)
            throws Exception {
        Object interceptedObject
                = invocationContext.getTarget();
        Method interceptedMethod
                = invocationContext.getMethod();
        System.out.println("Entering "
                + interceptedObject.getClass().getName() + "."
                + interceptedMethod.getName() + "()");
        Object o = invocationContext.proceed();
        System.out.println("Leaving "
                + interceptedObject.getClass().getName() + "."
                + interceptedMethod.getName() + "()");
        return o;
    }
}
