package cn.edu.usst.competitionweb.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义一个注解
@Retention(RetentionPolicy.RUNTIME)//描述此注解何时生效(运行时生效)
@Target(ElementType.METHOD)//指定当前注解可以作用在什么地方（方法上）
public @interface PrintOperateLog {
}
