package io.github.fabienleite.usecases

import io.github.fabienleite.domain.TabGroup
import io.github.fabienleite.domain.TabGroupRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreateTabGroup(private val tabGroupRepository: TabGroupRepository) {
    fun execute(allTabsUrlAsString: String): TabGroup {
        val tabGroup = TabGroup(allTabsUrlAsString)
        tabGroupRepository.saveTabGroup(tabGroup)
        return tabGroup
    }
}