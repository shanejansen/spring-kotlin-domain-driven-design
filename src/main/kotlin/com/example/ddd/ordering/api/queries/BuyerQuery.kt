package com.example.ddd.ordering.api.queries

import com.example.ddd.ordering.api.viewmodels.BuyerViewModel
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class BuyerQuery(val jdbcTemplate: NamedParameterJdbcTemplate) {
    fun getAllBuyers(): List<BuyerViewModel> {
        val sql = """
            SELECT * FROM buyer
        """.trimIndent()

        return jdbcTemplate.query(sql, emptyMap<String, String>()) { rs, _ ->
            BuyerViewModel(
                    id = rs.getInt("id"),
                    name = rs.getString("first_name") + " " + rs.getString("last_name"),
                    email = rs.getString("email"))
        }
    }
}
