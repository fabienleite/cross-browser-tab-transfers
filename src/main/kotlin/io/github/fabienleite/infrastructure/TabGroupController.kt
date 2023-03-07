package io.github.fabienleite.infrastructure

import io.github.fabienleite.usecases.CreateTabGroup
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response

@Path("/tab-group")
class TabGroupController(private val createTabGroup: CreateTabGroup) {
    @POST
    @Produces
    fun create(urls: String): Response {
        createTabGroup.execute(urls)
        return Response.ok().build()
    }
}