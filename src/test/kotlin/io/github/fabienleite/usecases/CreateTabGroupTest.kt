package io.github.fabienleite.usecases

import io.github.fabienleite.domain.TabGroup
import io.github.fabienleite.domain.TabGroupRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.*
import java.net.URL

class CreateTabGroupTest : StringSpec({
    val tabGroupRepository = mockk<TabGroupRepository>()
    val createTabGroup = CreateTabGroup(tabGroupRepository)

    every { tabGroupRepository.saveTabGroup(any()) } just runs

    "should create a TabGroup containing all necessary tabs" {
        // Given
        val urlList = """
            https://github.com/fabienleite/cross-browser-tab-transfers
            https://www.youtube.com/watch?v=qUqsLXyED5g
            https://jwt.io/
        """.trimIndent()

        // When
        val tabGroup = createTabGroup.execute(urlList)

        // Then
        tabGroup.tabs shouldHaveSize 3
        tabGroup.tabs.map { it.value } shouldContainExactly listOf(
            URL("https://github.com/fabienleite/cross-browser-tab-transfers"),
            URL("https://www.youtube.com/watch?v=qUqsLXyED5g"),
            URL("https://jwt.io/"),
        )
    }

    "should exclude incorrect URLs and keep the rest" {
        // Given
        val urlList = """
            https://github.com/fabienleite/cross-browser-tab-transfers
            fzfhzeguhufzeo
        """.trimIndent()

        // When
        val tabGroup = createTabGroup.execute(urlList)

        // Then
        tabGroup.tabs shouldHaveSize 1
        tabGroup.tabs.first().value shouldBe URL("https://github.com/fabienleite/cross-browser-tab-transfers")
    }

    "should save the Tab Group" {
        // Given
        val urlList = """
            https://github.com/fabienleite/cross-browser-tab-transfers
        """.trimIndent()

        // When
        val tabGroup = createTabGroup.execute(urlList)

        // Then
        val expectedTabGroup = TabGroup(urlList)
        verify { tabGroupRepository.saveTabGroup(tabGroup) }
    }

})