package io.github.fabienleite.infrastructure

import io.github.fabienleite.domain.TabGroup
import io.github.fabienleite.domain.TabGroupRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TabGroupAdapter: TabGroupRepository {
    private val tabGroupList = ArrayList<TabGroup>()

    override fun saveTabGroup(tabGroup: TabGroup) {
        tabGroupList.add(tabGroup)
    }
}