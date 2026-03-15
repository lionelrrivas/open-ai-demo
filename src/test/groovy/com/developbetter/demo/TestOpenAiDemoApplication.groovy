package com.developbetter.demo

import org.springframework.boot.SpringApplication


class TestOpenAiDemoApplication {

    static void main(String[] args) {
        SpringApplication.from(OpenAiDemoApplication::main)
                .with(TestContainersConfiguration.class)
                .run(args)
    }
}
