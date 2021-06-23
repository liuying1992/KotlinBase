package com.liuying.jacokebase.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.liuying.jacokebase.R
import com.liuying.jacokebase.base.BaseFragment
import com.liuying.jacokebase.utils.LYLog

/**
 * Created by liuying on 6/22/21 16:20.
 * Email: ly1203575492@163.com
 */
class BFragment : BaseFragment() {
  override fun onAttach(context: Context) {
    super.onAttach(context)
    LYLog.log("BF onAttach")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    LYLog.log("BF onCreate")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    LYLog.log("BF onCreateView")
    return inflater.inflate(R.layout.fragment_b, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    LYLog.log("BF onActivityCreated")
  }

  override fun onStart() {
    super.onStart()
    LYLog.log("BF onStart")
  }

  override fun onResume() {
    super.onResume()
    LYLog.log("BF onResume")
  }

  override fun onPause() {
    super.onPause()
    LYLog.log("BF onPause")
  }

  override fun onStop() {
    super.onStop()
    LYLog.log("BF onStop")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    LYLog.log("BF onDestroyView")
  }

  override fun onDestroy() {
    super.onDestroy()
    LYLog.log("BF onDestroy")
  }


}