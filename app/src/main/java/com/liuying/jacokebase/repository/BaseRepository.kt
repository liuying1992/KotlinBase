package com.liuying.jacokebase.repository

import com.liuying.jacokebase.info.BaseResp
import com.liuying.jacokebase.info.DataState
import com.liuying.jacokebase.model.StateLiveData

/**
 * 请求数据公共方法
 * 处理一些公共的错误方法
 * Created by liuying on 6/10/21 16:49.
 * Email: ly1203575492@163.com
 */
open class BaseRepository {
  suspend fun <T : Any> executeResp(
      block: suspend () -> BaseResp<T>,
      stateLiveData: StateLiveData<T>,
  ) {
    var baseResp = BaseResp<T>()
    try {
      baseResp.dataState = DataState.STATE_LOADING
      //开始请求数据
      val invoke = block.invoke()
      //将结果复制给baseResp
      baseResp = invoke
      if (baseResp.errorCode == 0) {
        //请求成功 判断数据是否同为空
        if (baseResp.data == null || baseResp.data is List<*> && (baseResp.data as List<*>).size == 0) {
          //数据为空 结构变化时需要修改判断条件
          baseResp.dataState = DataState.STATE_EMPTY
        } else {
          baseResp.dataState = DataState.STATE_SUCCESS
        }
      } else {
        //服务器请求错误
        baseResp.dataState = DataState.STATE_FAILED
      }
    } catch (e: Exception) {
      //非后台返回错误捕获的异常
      baseResp.dataState = DataState.STATE_ERROR
      baseResp.error = e
    } finally {
      stateLiveData.postValue(baseResp)
    }
  }
}