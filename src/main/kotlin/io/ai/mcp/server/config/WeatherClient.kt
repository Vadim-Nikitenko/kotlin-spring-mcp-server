package io.ai.mcp.server.config

import io.ai.mcp.server.model.dto.WeatherResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "weatherClient",
    url = "http://api.weatherapi.com/v1"
)
interface WeatherClient {

    @GetMapping("/current.json")
    fun getCurrentWeather(
        @RequestParam("key") apiKey: String,
        @RequestParam("q") location: String,
        @RequestParam("aqi") aqi: String = "no"
    ): WeatherResponse
}