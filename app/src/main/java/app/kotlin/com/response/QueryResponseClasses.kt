package app.kotlin.com.response


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */
data class QueryResponse(val data: PageInfo<QueryItem>, val errorCode: Int, val errorMsg: String)
    : ResponseData(errorCode, errorMsg)

data class QueryItem(
        val apkLink: String,
        val author: String,
        val chapterId: Int,
        val chapterName: String,
        val collect: Boolean,
        val courseId: Int,
        val desc: String,
        val envelopePic: String,
        val id: Int,
        val link: String,
        val niceDate: String,
        val origin: String,
        val projectLink: String,
        val publishTime: Long,
        val title: String,
        val visible: Int,
        val zan: Int
)