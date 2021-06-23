package com.liuying.jacokebase.api

import com.liuying.jacokebase.info.BaseResp
import com.liuying.jacokebase.info.ProjectTree
import retrofit2.http.GET

/**
 * Created by liuying on 6/10/21 14:51.
 * Email: ly1203575492@163.com
 */
interface ProjectApi {
  @GET("project/tree/json")
  suspend fun loadProjectTree(): BaseResp<List<ProjectTree>>
}