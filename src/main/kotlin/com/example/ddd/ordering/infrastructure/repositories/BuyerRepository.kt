package com.example.ddd.ordering.infrastructure.repositories

import com.example.ddd.ordering.domain.buyer.Buyer
import com.example.ddd.ordering.domain.buyer.BuyerId
import com.example.ddd.ordering.domain.buyer.IBuyerRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class BuyerRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : IBuyerRepository {
    companion object {
        private const val TABLE_NAME = "buyer"
    }

    override fun existsWithEmail(email: String): Boolean {
        val sql = """
            SELECT COUNT(1) FROM $TABLE_NAME
            WHERE email = :email
        """.trimIndent()

        val numRows = jdbcTemplate.queryForObject(sql, mapOf("email" to email), Integer::class.java)!!.toInt()
        return numRows != 0
    }

    override fun save(buyer: Buyer) {
        val sql = """
            INSERT INTO $TABLE_NAME (first_name, last_name, email)
            VALUES (:firstName, :lastName, :email)
        """.trimIndent()

        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(sql,
                MapSqlParameterSource(mapOf(
                        "firstName" to buyer.name.firstName,
                        "lastName" to buyer.name.lastName,
                        "email" to buyer.email.address
                )),
                keyHolder)
        val id = keyHolder.key!!.toInt()
        buyer.id = BuyerId(id)
    }

    override fun update(buyer: Buyer) {
        val sql = """
            UPDATE $TABLE_NAME
            SET first_name = :firstName, last_name = :lastName, email = :email
            WHERE id = :id
        """.trimIndent()

        jdbcTemplate.update(sql,
                MapSqlParameterSource(mapOf(
                        "id" to buyer.id,
                        "firstName" to buyer.name.firstName,
                        "lastName" to buyer.name.lastName,
                        "email" to buyer.email
                )))
    }
}
