package com.liuying.jacokebase.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liuying.jacokebase.api.ProjectApi
import com.liuying.jacokebase.http.RetrofitManager
import com.liuying.jacokebase.info.ProjectTree
import com.liuying.jacokebase.repository.LYRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 项目viewModel
 * Created by liuying on 6/10/21 15:56.
 * Email: ly1203575492@163.com
 */
class ProjectViewModel : ViewModel() {
  val projectViewModel = StateLiveData<List<ProjectTree>>()
  private val service = RetrofitManager.initRetrofit().getService(ProjectApi::class.java)
  private val repository = LYRepository(service)

  //直接发起请求
  fun loadProjectTree() {
    viewModelScope.launch(Dispatchers.IO) {
      repository.loadPeojectTree(projectViewModel)
    }
  }
}