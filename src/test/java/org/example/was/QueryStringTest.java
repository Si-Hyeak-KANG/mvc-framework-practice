package org.example.was;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    // operand1=11
    @Test
    void createTest() throws Exception {
        QueryString queryString = new QueryString("operand", "11");

        assertThat(queryString).isNotNull();
    }
}
