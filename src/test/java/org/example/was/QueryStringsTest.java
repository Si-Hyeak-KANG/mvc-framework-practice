package org.example.was;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// 1급 컬렉션
public class QueryStringsTest {

    @Test
    void createTest() throws Exception {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55"); // List<QueryString>
        assertThat(queryStrings).isNotNull();
    }
}
