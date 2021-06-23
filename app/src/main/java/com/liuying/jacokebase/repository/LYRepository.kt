package com.liuying.jacokebase.repository

import com.liuying.jacokebase.api.ProjectApi
import com.liuying.jacokebase.info.ProjectTree
import com.liuying.jacokebase.model.StateLiveData

/**
 * 数据仓库
 * Created by liuying on 6/10/21 14:50.
 * Email: ly1203575492@163.com
 */
class LYRepository(private val service: ProjectApi) : BaseRepository() {
  suspend fun loadPeojectTree(stateLiveData: StateLiveData<List<ProjectTree>>) {
    executeResp({ service.loadProjectTree() }, stateLiveData)
  }

}