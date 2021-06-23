package com.liuying.jacokebase.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by liuying on 6/10/21 15:10.
 * Email: ly1203575492@163.com
 */
private const val TAG = "RetrofitManager"

object RetrofitManager {
  private val mOkHttpClient = OkHttpClient.Builder()
      .callTimeout(10, TimeUnit.SECONDS)
      .connectTimeout(10, TimeUnit.SECONDS)
      .readTimeout(10, TimeUnit.SECONDS)
      .writeTimeout(10, TimeUnit.SECONDS)
      .retryOnConnectionFailure(true)
      .followRedirects(false)
//      .cookieJar(LocalCookiejar())
      // TODO: 6/10/21  添加自定义 interceptor
      .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
          Log.d(TAG, "log: $message")
        }
      }).setLevel(HttpLoggingInterceptor.Level.BODY))
      .build()


  private var mRetrofit: Retrofit? = null

  fun initRetrofit(): RetrofitManager {
    mRetrofit = Retrofit.Builder()
        .baseUrl("https://www.wanandroid.com")
        .client(mOkHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return this
  }

  fun <T> getService(service: Class<T>): T {
    if (mRetrofit == null) {
      throw  ExceptionInInitializerError("Retrofit必须先初始化")
    } else {
      return mRetrofit!!.create(service)
    }
  }


}