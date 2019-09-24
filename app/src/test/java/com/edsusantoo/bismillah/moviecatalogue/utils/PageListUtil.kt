package com.edsusantoo.bismillah.moviecatalogue.utils

import androidx.paging.PagedList
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class PageListUtil {
    companion object {
        fun <T> mockPageList(list: List<T>): PagedList<T> {
            val pagedList = mock(PagedList::class.java) as PagedList<T>
            `when`(pagedList[ArgumentMatchers.anyInt()]).then { invocation ->
                val index = invocation.arguments.first() as Int
                list[index]
            }

            `when`(pagedList.size).thenReturn(list.size)
            return pagedList
        }
    }
}