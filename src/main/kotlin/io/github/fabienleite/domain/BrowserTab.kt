package io.github.fabienleite.domain

import java.net.URL

class BrowserTab(valueAsString: String) {
    val value: URL = URL(valueAsString)
}
