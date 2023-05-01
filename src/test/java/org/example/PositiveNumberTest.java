package org.example;

import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class PositiveNumberTest {

    @DisplayName("0 또는 음수를 전달하면 IllegalArgumentException 이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createTest(int value) throws Exception {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }
}
