package org.example;

// 메서드를 하나 가진 Functional Interface
// 사실 구현체를 직접 만들 필요가 없음
// 아래 어노테이션을 사용해서 람다로 처리
@FunctionalInterface
public interface PasswordGenerator {

    String generatePassword();
}
