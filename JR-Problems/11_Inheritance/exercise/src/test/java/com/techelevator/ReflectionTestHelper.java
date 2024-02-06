package com.techelevator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
public class ReflectionTestHelper {

    public enum AccessModifier {
        None,
        Private,
        Public
    }

    public static String checkField(Class<?> classType, String fieldName, Class<?> fieldType, AccessModifier accessModifier)
    {
        // Assert field exists, is of correct type and access
        Field field = SafeReflection.getDeclaredField(classType, fieldName);
        if (field == null) { return classType.getSimpleName() + " does not have the required field " + fieldName + "."; }

        if (field.getType() != fieldType) { return classType.getSimpleName() + " field " + fieldName + " must be type " + fieldType.getSimpleName() + "."; }

        return "";
    }

    public static String checkMethod(Class<?> classType, String methodName, Class<?> returnType, boolean isPublic, Class<?>[] parameters) {
        Method methodInfo = SafeReflection.getMethod(classType, methodName, parameters);
        if (methodInfo == null) {
            return classType.getSimpleName() + " does not have the method " + methodName + " with the parameters " + Arrays.toString(parameters) + ".";
        }

        if (!methodInfo.getReturnType().equals(returnType)) {
            return classType.getSimpleName() + " method " + methodName + " must return type " + returnType.getSimpleName() + ".";
        }

        if (isPublic && !Modifier.isPublic(methodInfo.getModifiers())) {
            return classType.getSimpleName() + " method " + methodName + " must be public.";
        }
        if (!isPublic && Modifier.isPublic(methodInfo.getModifiers())) {
            return classType.getSimpleName() + " method " + methodName + " must NOT be public.";
        }

        Parameter[] parameterInfo = methodInfo.getParameters();

        if (parameterInfo.length != parameters.length) {
            return classType.getSimpleName() + " method " + methodName + " must accept exactly " + parameters.length + " parameter" + (parameters.length == 1 ? "" : "s") + ".";
        }

        for (int i = 0; i < parameters.length; i++) {
            if (!parameterInfo[i].getType().equals(parameters[i])) {
                return classType.getSimpleName() + " method " + methodName + " parameter " + i + " must be of type " + parameters[i].getSimpleName() + ".";
            }
        }
        return "";
    }
}
