package com.example.ddd.ordering.api.queries

import com.example.ddd.ordering.api.dtos.BuyerDto
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class BuyerQuery(val jdbcTemplate: NamedParameterJdbcTemplate) {
    fun getBuyer(id: Int): BuyerDto? {
        val sql = """
            SELECT * FROM buyer
            WHERE id = :id
        """.trimIndent()

        val result = jdbcTemplate.query(sql, mapOf("id" to id)) { rs, _ ->
            BuyerDto(
                    id = rs.getInt("id"),
                    name = rs.getString("first_name") + " " + rs.getString("last_name"),
                    email = rs.getString("email"))
        }
        return if (result.isEmpty()) null else result[0]
    }
}
