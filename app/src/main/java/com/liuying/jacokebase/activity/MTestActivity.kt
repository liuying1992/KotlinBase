package com.liuying.jacokebase.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.liuying.jacokebase.R
import com.liuying.jacokebase.base.BaseActivity
import com.liuying.jacokebase.model.ProjectViewModel
import com.liuying.jacokebase.utils.JsonUtil
import kotlinx.android.synthetic.main.activity_test.*

/**
 * 测试类
 * Created by liuying on 6/10/21 17:29.
 * Email: ly1203575492@163.com
 */
class MTestActivity : BaseActivity() {
  private lateinit var prjModel: ProjectViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_test)
    prjModel = ViewModelProvider(this).get(ProjectViewModel::class.java)
    prjModel.loadProjectTree()


    prjModel.projectViewModel.observe(this, {
      Log.e("MTestActivity", JsonUtil.json2string(it))
      tv_request.text = JsonUtil.json2string(it)
      it.data?.get(0)?.name?.let { name -> Log.e("MTestActivity", name) }
    })
  }

}