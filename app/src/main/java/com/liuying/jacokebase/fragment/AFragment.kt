package com.liuying.jacokebase.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liuying.jacokebase.R
import com.liuying.jacokebase.info.ProjectTree
import com.liuying.jacokebase.utils.JsonUtil
import com.liuying.jacokebase.utils.LYLog

/**
 * Created by liuying on 6/22/21 16:20.
 * Email: ly1203575492@163.com
 */
class AFragment : Fragment() {
  override fun onAttach(context: Context) {
    super.onAttach(context)
    LYLog.log("AF onAttach")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    LYLog.log("AF onCreate")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    LYLog.log("AF onCreateView")
    initData()
    return inflater.inflate(R.layout.fragment_a, container, false)
  }

  private fun initData() {
    //invoke
    val lambda = { left: Int, right: Int
      ->
      left + right
    }
    println("invoke:" + lambda.invoke(1, 2))


    val student = run {
      mutableListOf<_TestInfo>().apply {
        add(_TestInfo().apply {
          name = "张三"
          sex = 0
          age = 27
        })
        add(_TestInfo().apply {
          name = "李四"
          sex = 1
          age = 21
        })
        add(_TestInfo().apply {
          name = "王五"
          sex = 0
          age = 24
        })
      }
    }

    //作用域方法
    with(student.last()) {
      sayHellow()
    }
    //对象配置
    var testInfo = _TestInfo().apply {
      name = "张三"
      sex = 0
      age = 27
    }
    println("apply:" + JsonUtil.json2string(testInfo))

    //返回值
    val p = _TestInfo().run {
      name = "赵倩"
      sex = 0
      age = 27
      "$name $sex $age"
    }
    println("run:$p")

    //also it
    _TestInfo().apply {
      name = "张三"
      sex = 0
      age = 27
    }.also { i0 ->
      println("also:" + JsonUtil.json2string(i0))
    }
    //let  it
    _TestInfo().apply {
      name = "张三"
      sex = 0
      age = 27
    }.let { i0 ->
      println("let:" + JsonUtil.json2string(i0))
    }
  }

  class _TestInfo {
    var name: String? = null
    var sex: Int? = 0
    var age: Int? = 0

    fun sayHellow() {
      println("with:$name")
    }

  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    LYLog.log("AF onActivityCreated")
  }

  override fun onStart() {
    super.onStart()
    LYLog.log("AF onStart")
  }

  override fun onResume() {
    super.onResume()
    LYLog.log("AF onResume")
  }

  override fun onPause() {
    super.onPause()
    LYLog.log("AF onPause")
  }

  override fun onStop() {
    super.onStop()
    LYLog.log("AF onStop")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    LYLog.log("AF onDestroyView")
  }

  override fun onDestroy() {
    super.onDestroy()
    LYLog.log("AF onDestroy")
  }


}