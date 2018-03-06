package app.kotlin.com.response


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
data class HomeBannerResponse(
        val data: List<HomeBannerItem>,
        val errorCode: Int,
        val errorMsg: String)
    : ResponseData(errorCode, errorMsg)

data class HomeBannerItem(
        val desc: String,
        val id: Int,
        val imagePath: String,
        val isVisible: Int,
        val order: Int,
        val title: String,
        val type: Int,
        val url: String)