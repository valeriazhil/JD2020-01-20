package by.it.zhuravaskarabahataya.jd01_10;
//у всех надо RetentionPolicy??

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Param {
    int a();
    int b();
}
