package app.kotlin.com.request

import app.kotlin.com.response.HotKeyResponse
import com.google.gson.Gson
import java.net.URL


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */
class HotKeyRequest : BaseRequest<HotKeyResponse> {

    companion object {
        private val HOT_KEY_URL = "http://www.wanandroid.com//hotkey/json"
    }

    override fun execute(): HotKeyResponse {
        val jsonStr = URL(HOT_KEY_URL).readText()
        return Gson().fromJson(jsonStr, HotKeyResponse::class.java)
    }


}