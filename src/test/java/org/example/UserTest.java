package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 하기 쉬운 코드를 작성하다 보면,
 * 더 낮은 결합도를 가진 설계를 얻을 수 있음
 */
class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() throws Exception {
        // given
        User user = new User();

        // when
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() throws Exception {
        // given
        User user = new User();

        // when
        user.initPassword(() -> "ab");

        // then
        assertThat(user.getPassword()).isNull();
    }
}