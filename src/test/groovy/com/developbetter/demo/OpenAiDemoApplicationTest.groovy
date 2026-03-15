package com.developbetter.demo

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@Import(TestContainersConfiguration.class)
class OpenAiDemoApplicationTest extends Specification {

    void "context loads"() {
        expect:
        true
    }
}
