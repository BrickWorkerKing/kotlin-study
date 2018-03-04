package app.kotlin.com.domain.model


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */

data class HomePageItem(val title: String, val key: String, val link: String, val dateTime: String)

data class HomePage(val items : List<HomePageItem>)