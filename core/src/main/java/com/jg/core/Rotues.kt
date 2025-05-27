package com.jg.core

import kotlinx.serialization.Serializable


sealed interface Route{
    @Serializable
    data object HomeScreen : Route

    @Serializable
    data object Detail: Route
}
