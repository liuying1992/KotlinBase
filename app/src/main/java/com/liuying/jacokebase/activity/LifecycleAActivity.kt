package com.liuying.jacokebase.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.liuying.jacokebase.R
import com.liuying.jacokebase.utils.LYLog
import kotlinx.android.synthetic.main.activity_lifecycle_a.*

/**
 * Created by liuying on 6/22/21 15:44.
 * Email: ly1203575492@163.com
 */
class LifecycleAActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_lifecycle_a)
    LYLog.log("A onCreate")
    btn_a.setOnClickListener {
      startActivity(Intent(this, LifecycleBActivity::class.java))
    }
  }

  override fun onStart() {
    super.onStart()
    LYLog.log("A onStart")
  }

  override fun onResume() {
    super.onResume()
    LYLog.log("A onResume")
  }

  override fun onPause() {
    super.onPause()
    LYLog.log("A onPause")
  }

  override fun onStop() {
    super.onStop()
    LYLog.log("A onStop")
  }


  override fun onDestroy() {
    super.onDestroy()
    LYLog.log("A onDestroy")
  }
}