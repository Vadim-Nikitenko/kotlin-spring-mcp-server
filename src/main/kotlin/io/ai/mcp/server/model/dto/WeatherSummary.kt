package io.ai.mcp.server.model.dto

data class WeatherSummary(
    val city: String,
    val localtime: String,
    val tempC: Double,
    val condition: String,
    val windKph: Double,
    val humidity: Int,
    val feelsLikeC: Double
)