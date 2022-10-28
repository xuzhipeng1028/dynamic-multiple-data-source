package com.xzp.dynamic.multiple.data.source.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description
 * @Author xzp
 * @Date 2022/10/28 15:22
 */
@Aspect
@Component
public class MultipleDataSourceAspect {

    @Pointcut("@annotation(com.xzp.dynamic.multiple.data.source.config.MultipleDataSource)"
            + "||@within(com.xzp.dynamic.multiple.data.source.config.MultipleDataSource)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        MultipleDataSource multipleDataSource = AnnotationUtils.findAnnotation(signature.getMethod(), MultipleDataSource.class);
        if (Objects.isNull(multipleDataSource)) {
            multipleDataSource = AnnotationUtils.findAnnotation(signature.getDeclaringType(), MultipleDataSource.class);
        }
        if (Objects.nonNull(multipleDataSource)) {
            DynamicMultipleDataSourceContextHolder.setDataSourceName(multipleDataSource.value());
        }
        try {
            return point.proceed();
        } finally {
            DynamicMultipleDataSourceContextHolder.clearDataSourceName();
        }
    }
}
