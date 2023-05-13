package org.example.di_framework.di;

import org.example.di_framework.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {

    /**
     * 인자로 받은 클래스 타입에서 Inject 어노테이션이 붙은 생성자를 갖고옴
     * @param clazz
     * @return
     */
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {

        Set<Constructor> injectedConstructors =
                ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));

        if (injectedConstructors.isEmpty()) {
            return null;
        }

        // 현재는 첫 번째 요소만 반환
        return injectedConstructors.iterator().next();
    }
}
