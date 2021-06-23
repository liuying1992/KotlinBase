package com.liuying.jacokebase.utils

import android.util.Log

/**
 * Created by liuying on 6/22/21 15:48.
 * Email: ly1203575492@163.com
 */
object LYLog {
  val TAG = "jacoke_log"
  fun log(msg: String) {
    Log.e(TAG, msg)
  }

  fun log(tag: String? = TAG, msg: String) {
    Log.e(tag, msg)
  }
}