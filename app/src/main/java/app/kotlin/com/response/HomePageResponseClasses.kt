package app.kotlin.com.response


/**
 * 首页列表
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
data class HomePageResponse(
        val data: PageInfo<HomePageItem>,
        val errorCode: Int,
        val errorMsg: String)
    : ResponseData(errorCode, errorMsg)

data class HomePageItem(
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
        val zan: String)

