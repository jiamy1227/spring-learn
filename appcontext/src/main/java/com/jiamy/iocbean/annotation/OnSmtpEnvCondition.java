package com.jiamy.iocbean.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @description:
 * @author: jiamy
 * @create: 2024/9/23 15:56
 **/
public class OnSmtpEnvCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
