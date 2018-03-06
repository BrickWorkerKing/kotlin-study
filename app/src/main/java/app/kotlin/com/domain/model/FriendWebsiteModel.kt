package app.kotlin.com.domain.model


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
data class FriendWebsiteItem(val name: String, val link: String)

data class FriendWebsite(val items: List<FriendWebsiteItem>)