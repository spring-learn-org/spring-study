package com.example.hellokopring.repository

import com.example.hellokopring.domain.Member
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import java.sql.ResultSet
import javax.sql.DataSource

class JdbcTemplateMemberRepository(private val dataSource: DataSource) : MemberRepository {
    private val jdbcTemplate: JdbcTemplate = JdbcTemplate(dataSource)

    override fun save(member: Member): Member {
        val jdbcInsert: SimpleJdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")

        val parameters: MutableMap<String, Any> = mutableMapOf<String, Any>()
        parameters.put("name", member.name)

        val key: Number = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        member.id = key.toLong()

        return member
    }

    override fun findById(id: Long): Member? =
        jdbcTemplate
            .query("select * from member where id = ?", memberRowMapper(), id)
            .firstOrNull()

    override fun findByName(name: String): Member? =
        jdbcTemplate
            .query("select * from member where name = ?", memberRowMapper(), name)
            .firstOrNull()

    override fun findAll(): List<Member> =
        jdbcTemplate
            .query("select * from member", memberRowMapper())

    private fun memberRowMapper(): RowMapper<Member> {
        return RowMapper { rs: ResultSet, rowNum: Int ->
            Member(id = rs.getLong("id"), name = rs.getString("name"))
        }
    }
}
