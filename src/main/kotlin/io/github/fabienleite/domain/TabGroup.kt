package io.github.fabienleite.domain

import mu.KotlinLogging
import java.net.MalformedURLException

private val logger = KotlinLogging.logger {}

class TabGroup(tabsAsString: String) {
    val tabs: List<BrowserTab> = tabsAsString.split("\n").mapNotNull {
        try {
            BrowserTab(it)
        } catch (exception: MalformedURLException) {
            logger.info("URL not correctly formatted $it")
            null
        }
    }
}
