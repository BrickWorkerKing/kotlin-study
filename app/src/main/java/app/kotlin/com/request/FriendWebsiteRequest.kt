package app.kotlin.com.request

import app.kotlin.com.response.FriendWebsiteResponse
import app.kotlin.com.util.log
import com.google.gson.Gson
import java.net.URL


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
class FriendWebsiteRequest : BaseRequest<FriendWebsiteResponse> {

    companion object {
        private val FRIEND_URL = "http://www.wanandroid.com/friend/json"
    }

    override fun execute(): FriendWebsiteResponse {
        val jsonStr = URL(FRIEND_URL).readText()
        log("friend == " + jsonStr)
        return Gson().fromJson(jsonStr, FriendWebsiteResponse::class.java)
    }

}