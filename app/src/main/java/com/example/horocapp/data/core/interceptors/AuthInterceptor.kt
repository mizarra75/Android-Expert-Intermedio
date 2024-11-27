package com.example.horocapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor():Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request:Request= chain.request().newBuilder().header("Authorization","algo").build()
        return chain.proceed(request)
    }
}

