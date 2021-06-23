package com.liuying.jacokebase.info

/**
 * Created by liuying on 6/10/21 14:56.
 * Email: ly1203575492@163.com
 */
class ProjectTree(
    var children: List<Any>,
    var courseId: Int,
    var id: Int,
    var name: String,
    var order: Int,
    var parentChapterId: Int,
    var userControlSetTop: Boolean,
    var visible: Int
)