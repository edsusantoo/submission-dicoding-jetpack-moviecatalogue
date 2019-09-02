package com.edsusantoo.bismillah.moviecatalogue.utils

import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)