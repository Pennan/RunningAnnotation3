package com.np.ioc;

import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

@AutoService(Processor.class)
public class MyProcesser extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>();
        annotationTypes.add(MyAnnotation.class.getCanonicalName());
        return annotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(MyAnnotation.class)) {
            System.out.println("-----------------------------");
            // 如果被注解的元素为 成员变量
            if (element.getKind() == ElementKind.FIELD) {
                VariableElement variableElement = (VariableElement) element;
                System.out.println("成员变量：" + variableElement.getSimpleName());
                System.out.println("成员变量注解值："
                        + variableElement.getAnnotation(MyAnnotation.class).value());
            } else if (element.getKind() == ElementKind.CLASS) {
                // 如果被注解的元素为 类
                TypeElement typeElement = (TypeElement) element;
                System.out.println("类：" + typeElement.getSimpleName());
                System.out.println("类上的注解值："
                        + typeElement.getAnnotation(MyAnnotation.class).value());
            }
            System.out.println("-----------------------------");
        }
        return false;
    }
}
