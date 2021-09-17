package com.antmoney.kmm_services.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.HttpNetworkTransport

object API {

    val apolloClient = ApolloClient(
        networkTransport = HttpNetworkTransport(
            serverUrl = "https://api.dev.learnandearn.com/graphql",
            headers = mapOf(
                "Accept" to "application/json",
                "Authorization" to "auth-token",
                "AuthorizationToken" to "yK9FCnr45BCRfF3vWsbZNoSg",
                "X-CLIENT-PLATFORM" to "android",
                "X-CLIENT-APP" to "com.antmoney.learnandearn",
                "X-VERSION" to "v1",
                "X-CLIENT-UDID" to "a0edba6545a579d9",
                "User-Agent" to "IGAndroid/1.11.1",
                "X-CLIENT-BUILD" to "1.11.1",
                "X-CLIENT-DEVICEADID" to "969d3040-0820-4f6a-99ac-f5638695dc32"
            )
        )
    )
}
