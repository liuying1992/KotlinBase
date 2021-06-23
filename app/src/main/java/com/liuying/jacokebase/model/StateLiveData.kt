package com.liuying.jacokebase.model

import androidx.lifecycle.MutableLiveData
import com.liuying.jacokebase.info.BaseResp

/**
 * Created by liuying on 6/10/21 16:52.
 * Email: ly1203575492@163.com
 */
class StateLiveData<T> : MutableLiveData<BaseResp<T>>() {
}