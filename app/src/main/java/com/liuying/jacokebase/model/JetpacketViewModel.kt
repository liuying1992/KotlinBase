package com.liuying.jacokebase.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by liuying on 6/9/21 17:38.
 * Email: ly1203575492@163.com
 */
class JetpacketViewModel : ViewModel() {

  fun launchData() {
    viewModelScope.launch {
      //TODO 在后台执行获取数据
      val result = getNetData()
      // TODO: 6/9/21
      Log.e("123456", result)
    }
  }

  private suspend fun getNetData() = withContext(Dispatchers.IO) {
    delay(1000)
    "{'name':'like'}"
  }
}