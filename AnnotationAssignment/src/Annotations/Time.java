package Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author twinkle.lahariya
 * 
 *         Annotation for method level implementation
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Time {

	int prepareTime() default 1;

	int cookTime() default 1;

	int sendTime() default 1;
}
