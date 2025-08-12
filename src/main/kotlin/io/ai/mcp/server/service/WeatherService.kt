package io.ai.mcp.server.service

import io.ai.mcp.server.config.WeatherClient
import io.ai.mcp.server.model.dto.WeatherResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class WeatherService(
    private val weatherClient: WeatherClient,
    @Value("\${weather.api.key}") private val apiKey: String
) {
    fun byCity(city: String): WeatherResponse {
        return weatherClient.getCurrentWeather(apiKey, city)
    }
}