package javax.jdo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for a method on a persistence capable object to be used just as
 * {@link javax.jdo.listener.AttachCallback#jdoPreAttach()}.
 * 
 * @see javax.jdo.listener.AttachCallback#jdoPreAttach()
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PreAttach 
{
	/**
	 * The order of execution of this method relative to other annotated callback methods. 
	 * A lower order value means that the annotated method has a higher precedence among annotated methods, and a higher order, a lower precedence. 
	 * Order values need not be contiguous among annotated methods.
	 * Methods that are implementations of the corresponding callback interface method are always called first. 
	 * The order value {@link Integer#MAX_VALUE}, the default, signifies that the order is undefined among annotated methods. 
	 * If other annotated methods define an order, those methods will be called before annotated methods with an undefined order. 
	 * If other annotated methods define equal order values, then methods annotated with lower order values will be called before them, 
	 * the methods with equal order values will be called in an undefined order, and then any methods with higher order values will be called 
	 * after the methods with equal order values have been called. 
	 * If a method that represents an implementation of the corresponding interface method carries this annotation, the annotation and its 
	 * order are ignored, and the interface method is called first. 
	 * If a subclass annotates a method with the same order as an annotated method in its superclass hierarchy, then the subclass's method 
	 * is called first, otherwise the order values among all annotated methods in the class and its superclass hierarchy determine call order.
	 */
	int order() default Integer.MAX_VALUE;
}