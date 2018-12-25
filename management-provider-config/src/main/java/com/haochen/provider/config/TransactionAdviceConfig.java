package com.haochen.provider.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @author YangChao
 */
@Aspect
@Configuration
public class TransactionAdviceConfig {

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com..service..*.*(..)))";

    private final PlatformTransactionManager transactionManager;

    @Autowired
    public TransactionAdviceConfig(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean
    public TransactionInterceptor txadvice() {

        DefaultTransactionAttribute txattrRequired = new DefaultTransactionAttribute();
        txattrRequired.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txattrRequiredReadonly = new DefaultTransactionAttribute();
        txattrRequiredReadonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txattrRequiredReadonly.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("insert*", txattrRequired);
        source.addTransactionalMethod("create*", txattrRequired);
        source.addTransactionalMethod("add*", txattrRequired);
        source.addTransactionalMethod("edit*", txattrRequired);
        source.addTransactionalMethod("save*", txattrRequired);
        source.addTransactionalMethod("del*", txattrRequired);
        source.addTransactionalMethod("update*", txattrRequired);
        source.addTransactionalMethod("exec*", txattrRequired);
        source.addTransactionalMethod("set*", txattrRequired);
        source.addTransactionalMethod("get*", txattrRequiredReadonly);
        source.addTransactionalMethod("query*", txattrRequiredReadonly);
        source.addTransactionalMethod("find*", txattrRequiredReadonly);
        source.addTransactionalMethod("list*", txattrRequiredReadonly);
        source.addTransactionalMethod("count*", txattrRequiredReadonly);
        source.addTransactionalMethod("is*", txattrRequiredReadonly);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txadvice());
    }
}
