package mg.framework.annotation.servlet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface BaseUrl {
    String value() default "";
}
