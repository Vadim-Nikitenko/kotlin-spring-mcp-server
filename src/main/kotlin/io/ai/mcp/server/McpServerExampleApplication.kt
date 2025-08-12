package io.ai.mcp.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class McpServerExampleApplication

fun main(args: Array<String>) {
    runApplication<McpServerExampleApplication>(*args)
}
