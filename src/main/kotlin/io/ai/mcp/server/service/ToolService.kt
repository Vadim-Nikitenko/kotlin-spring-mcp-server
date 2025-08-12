package io.ai.mcp.server.service

import io.ai.mcp.server.model.dto.WeatherSummary
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Service
class ToolService(private val service: WeatherService) {
    @Tool(description = "Получить текущую дату и время.")
    fun getTime(): LocalDateTime {
        val now = LocalDateTime.now().withHour(10)
        println("Now: $now")
        return now
    }

    @Tool(description = "Создать напоминание на определённое время.")
    fun createReminder(
        @ToolParam(description = "Текст напоминания")
        description: String,
        @ToolParam(description = "Время в ISO-8601, например 2025-08-12T10:00:00Z или 2025-08-12T10:00:00+03:00")
        dateTime: String,
    ): String {
        val dt = try {
            OffsetDateTime.parse(dateTime)               // Z или +hh:mm
                .toLocalDateTime()
        } catch (_: Exception) {
            LocalDateTime.parse(dateTime)                // без зоны
        }
        return "Напоминание с текстом '$description' сработает $dt."
    }

    @Tool(description = "Текущая погода по городу через WeatherAPI")
    fun weatherCurrent(
        @ToolParam(description = "Определение погоды в городе") city: String
    ): WeatherSummary {
        val w = service.byCity(city)
        return WeatherSummary(
            city = "${w.location.name}, ${w.location.country}",
            localtime = w.location.localtime,
            tempC = w.current.temp_c,
            condition = w.current.condition.text,
            windKph = w.current.wind_kph,
            humidity = w.current.humidity,
            feelsLikeC = w.current.feelslike_c
        )
    }

}
