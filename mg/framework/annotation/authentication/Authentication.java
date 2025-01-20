package mg.framework.annotation.authentication;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {
    int level() default 0;
}