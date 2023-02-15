package org.example;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String className = "CuteVidya";
        MethodSpec main = MethodSpec.methodBuilder("main")
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        MethodSpec.Builder main1 = MethodSpec.methodBuilder("getVidya")
                .returns(boolean.class)
                .addParameter(String.class, "hatti");
        main1.addStatement("$T.out.println($S)", System.class, "Vidya khup hattii aahe!");
        main1.addStatement("$T.out.println($S)", System.class, "Sohil khup aikto! To khadus nai ahe.");
        main1.addStatement("$T.out.println($S)", System.class, "Vidya needs sleep, ti aikat nai, jhopat nai");

        main1.addStatement("return true");

        MethodSpec vidyaMethod = main1.build();
        TypeSpec helloWorld = TypeSpec.classBuilder(className + "Dao")
                .addSuperinterface(CrudDao.class)
                .addMethod(main)
                .addMethod(vidyaMethod)
                .build();
        JavaFile javaFile = JavaFile.builder("org.example", helloWorld).build();

        String code = javaFile.toString();
        System.out.println(code);
        FileWriter writer = new FileWriter("C:/Users/Altres/IdeaProjects/hrs-template-javaPOET/src/main/java/org/example/" + className + "Dao.java");
        writer.write(code);
        writer.close();
    }

}