package com.orangebook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

  public void runTests(Class<?>[] classes) {
    for(Class<?> clazz : classes) {
      Method[] methods = clazz.getDeclaredMethods();
      for (Method method : methods) {
        if (method.isAnnotationPresent(Test.class)) {
          try {
            method.invoke(clazz.newInstance());
          } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException occurred");
          } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException occurred");
          } catch (InstantiationException e) {
            System.out.println("InstantiationException occurred");
          }
        }
      }
    }
  }

}
