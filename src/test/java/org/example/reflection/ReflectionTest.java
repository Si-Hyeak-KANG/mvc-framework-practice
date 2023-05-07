package org.example.reflection;

import org.example.reflection.annotation.Controller;
import org.example.reflection.annotation.Service;
import org.example.reflection.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력한다.
 */
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);
    @Test
    void controllerScan() throws Exception {
        Set<Class<?>> beans = getTypesAnnotatedWith(
                List.of(Controller.class, Service.class));

        logger.debug("beans: [{}]", beans);
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));

        return beans;
    }

    @DisplayName("클래스의 모든 정보 출력")
    @Test
    void showClass() throws Exception {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared method: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @DisplayName("클래스 타입의 객체를 갖고오는 방법")
    @Test
    void load() throws Exception {
        // 힙 영역에 로드되어 있는 클래스 타입 객체를 갖고오는 방법
        // 1 번째 방법
        Class<User> clazz = User.class;

        // 2 번째 방법
        User user = new User("serverserver", "제임스");
        Class<? extends User> clazz2 = user.getClass();

        // 3 번째 방법
        Class<?> clazz3 = Class.forName("org.example.reflection.model.User");

        logger.debug("clazz: [{}]", clazz);
        logger.debug("clazz2: [{}]", clazz2);
        logger.debug("clazz3: [{}]", clazz3);

        assertThat(clazz == clazz2).isTrue();
        assertThat(clazz2 == clazz3).isTrue();
        assertThat(clazz3 == clazz).isTrue();
    }
}
