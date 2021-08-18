package com.atm.codechallenge.network

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.cache.http.HttpCachePolicy
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object API {

    private val interceptor = Interceptor {
        val original = it.request()
        val request = original.newBuilder()
            .header("Accept", "application/json")
            .header("Authorization", "auth-token")
            .header("AuthorizationToken", "yK9FCnr45BCRfF3vWsbZNoSg")
            .header("X-CLIENT-PLATFORM", "android")
            .header("X-CLIENT-APP", "com.antmoney.learnandearn")
            .header("X-VERSION", "v1")
            .header("X-CLIENT-UDID", "a0edba6545a579d9")
            .header("User-Agent", "IGAndroid/1.11.1")
            .header("X-CLIENT-BUILD", "1.11.1")
            .header("X-CLIENT-DEVICEADID", "969d3040-0820-4f6a-99ac-f5638695dc32")
            .method(original.method, original.body)

        it.proceed(request.build())
    }

    private val okHttpClient = OkHttpClient.Builder()
        .apply {
            readTimeout(30000, TimeUnit.MILLISECONDS)
            writeTimeout(30000, TimeUnit.MILLISECONDS)
            connectTimeout(15000, TimeUnit.MILLISECONDS)

            addInterceptor(interceptor)

            addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
            )
        }
        .build()

    val apolloClient = ApolloClient.builder()
        .serverUrl("https://api.dev.learnandearn.com/graphql")
        .okHttpClient(okHttpClient)
        .defaultHttpCachePolicy(HttpCachePolicy.NETWORK_ONLY)
        .defaultResponseFetcher(ApolloResponseFetchers.NETWORK_ONLY)
        .build()
}