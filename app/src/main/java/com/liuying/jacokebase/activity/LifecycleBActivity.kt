package com.liuying.jacokebase.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liuying.jacokebase.R
import com.liuying.jacokebase.fragment.AFragment
import com.liuying.jacokebase.fragment.BFragment
import com.liuying.jacokebase.utils.LYLog
import kotlinx.android.synthetic.main.activity_lifecycle_a.*
import kotlinx.android.synthetic.main.activity_lifecycle_b.*

/**
 * Created by liuying on 6/22/21 15:44.
 * Email: ly1203575492@163.com
 */
class LifecycleBActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_lifecycle_b)
    LYLog.log("B onCreate")
    val fm = supportFragmentManager.beginTransaction()
    val aFragment = AFragment()
    val bFragment = BFragment()
    fm.add(R.id.fm_content, aFragment)
    fm.commit()
  }

  override fun onStart() {
    super.onStart()
    LYLog.log("B onStart")
  }

  override fun onResume() {
    super.onResume()
    LYLog.log("B onResume")
  }

  override fun onPause() {
    super.onPause()
    LYLog.log("B onPause")
  }

  override fun onStop() {
    super.onStop()
    LYLog.log("B onStop")
  }


  override fun onDestroy() {
    super.onDestroy()
    LYLog.log("B onDestroy")
  }
}