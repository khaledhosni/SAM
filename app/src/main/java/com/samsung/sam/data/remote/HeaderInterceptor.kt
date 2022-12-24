package com.samsung.sam.data.remote

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("headerKey0", "HeaderVal0")
            .addHeader("headerKey0", "HeaderVal0--NotReplaced/NorUpdated") //new header added
            .build()

        println(request.url())

        //alternative
        val moreHeaders: Headers = request.headers().newBuilder()
            .add("headerKey1", "HeaderVal1")
            .add("headerKey2", "HeaderVal2")
            .set(
                "headerKey2",
                "HeaderVal2--UpdatedHere"
            ) // existing header UPDATED if available, else added.
            .add("headerKey3", "HeaderKey3")
            .add("headerLine4 : headerLine4Val") //line with `:`, spaces doesn't matter.
            .removeAll("headerKey3") //Oops, remove this.
            .build()
        request = request.newBuilder().headers(moreHeaders).build()

        /* ##### List of headers ##### */
        // headerKey0: HeaderVal0
        // headerKey0: HeaderVal0--NotReplaced/NorUpdated
        // headerKey1: HeaderVal1
        // headerKey2: HeaderVal2--UpdatedHere
        // headerLine4: headerLine4Val
        return chain.proceed(request)
    }

}