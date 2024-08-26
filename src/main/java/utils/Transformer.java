package main.java.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transformer implements IAnnotationTransformer {


   public void transform(ITestAnnotation annotation, Class testClass, Constructor testClassConstructor, Method testMethod)
   {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
   }
}
