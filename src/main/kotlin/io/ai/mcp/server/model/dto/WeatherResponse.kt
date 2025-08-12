package io.ai.mcp.server.model.dto

data class WeatherResponse(
    val location: Location,
    val current: Current
)