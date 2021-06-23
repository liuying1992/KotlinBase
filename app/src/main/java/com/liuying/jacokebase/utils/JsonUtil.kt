package com.liuying.jacokebase.utils

import com.google.gson.Gson
import java.util.*

/**
 * Created by liuying on 6/11/21 09:59.
 * Email: ly1203575492@163.com
 */
object JsonUtil {
  fun json2string(objects: Any): String {
    return Gson().toJson(objects)
  }
}