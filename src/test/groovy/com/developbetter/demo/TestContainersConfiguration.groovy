package com.developbetter.demo

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.DynamicPropertyRegistrar
import org.testcontainers.ollama.OllamaContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestContainersConfiguration {

    @Bean
    OllamaContainer ollamaContainer() {
        return new OllamaContainer(DockerImageName.parse("ollama/ollama:latest"))
                .withExposedPorts(11434)

    }

    @Bean
    DynamicPropertyRegistrar dynamicPropertyRegistrar(OllamaContainer ollamaContainer) {
        return (registry) -> {
            registry.add("spring.ai.ollama.base-url", () -> "http://${ollamaContainer.host}:${ollamaContainer.port}")
        }
    }
}
