package project.mc.commons;


import java.lang.reflect.InvocationTargetException;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * 트랜잭션 처리: Advice
 * @author sist
 *
 */
public class TransactionAdvice implements MethodInterceptor {
	private static Logger log = LoggerFactory.getLogger(TransactionAdvice.class);
	PlatformTransactionManager transactionManager;
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		TransactionStatus status=
		this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			log.debug("**********"+invocation.getMethod());
			Object ret = invocation.proceed();
			this.transactionManager.commit(status);
			log.debug("**********"+invocation.getMethod());
			return ret;
		}catch(RuntimeException e) {
			this.transactionManager.rollback(status);
			log.debug("**********111"+status);
			throw e;
		}
	}

}
