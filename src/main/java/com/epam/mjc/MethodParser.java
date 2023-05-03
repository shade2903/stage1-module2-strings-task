package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String[] signatureArr;
        String[] arguments;
        MethodSignature methodSignature = null;
        List<MethodSignature.Argument> argumentList = new ArrayList<>();
        String[] elements = signatureString.replace(")", "").split("\\(");
        if (elements.length != 0) {
            if (elements.length == 2) {
                arguments = elements[1].split(",");
                for (String arg : arguments) {
                    String[] argArr = arg.trim().split(" ");
                    MethodSignature.Argument argument = new MethodSignature.Argument(argArr[0], argArr[1]);
                    argumentList.add(argument);
                }
            }
            signatureArr = elements[0].split(" ");
            methodSignature = new MethodSignature(signatureArr[signatureArr.length - 1], argumentList);
            methodSignature.setReturnType(signatureArr[signatureArr.length - 2]);
            if (signatureArr.length == 3) methodSignature.setAccessModifier(signatureArr[0]);
        }
        return methodSignature;
    }
}
