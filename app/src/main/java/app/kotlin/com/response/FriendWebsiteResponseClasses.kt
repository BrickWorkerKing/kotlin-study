package app.kotlin.com.response


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
data class FriendWebsiteResponse(
        val data: List<FriendWebsiteItem>,
        val errorCode: Int,
        val errorMsg: String)
    : ResponseData(errorCode, errorMsg)

data class FriendWebsiteItem(
        val icon: String,
        val id: Int,
        val link: String,
        val name: String,
        val order: Int,
        val visible: Int)