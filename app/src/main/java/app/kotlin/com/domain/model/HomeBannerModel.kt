package app.kotlin.com.domain.model


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
data class HomeBannerItem(val title: String, val url: String, val imagePath: String)

data class HomeBannerImageItem(val url: String, val imagePath: String)

data class HomeBanner(val items: List<HomeBannerItem>)