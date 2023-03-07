package io.github.fabienleite.infrastructure

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test

@QuarkusTest
class TabGroupControllerTest {
    @Test
    fun `when we post a correct list of url then it is saved and OK`() {
        given()
            .param("urls", """
                https://github.com/fabienleite/cross-browser-tab-transfers
                https://quarkus.io/guides/security-overview-concept
                https://www.wikihow.com/Get-Rich
            """.trimIndent())
        .`when`().post("/tab-group")
        .then()
            .statusCode(200)
    }
}