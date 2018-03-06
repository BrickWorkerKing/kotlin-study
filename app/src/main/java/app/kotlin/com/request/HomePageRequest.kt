package app.kotlin.com.request

import app.kotlin.com.response.HomePageResponse
import app.kotlin.com.util.log
import com.google.gson.Gson
import java.net.URL


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
class HomePageRequest(val curPage: Int) : BaseRequest<HomePageResponse> {

    companion object {
        private val HTTP_URL = "http://www.wanandroid.com/article/list/"
        private val URL_END = "/json"
    }

    override fun execute(): HomePageResponse {
        val jsonStr: String = URL(HTTP_URL + curPage + URL_END).readText()
        log("home page json: " + jsonStr)
        return Gson().fromJson(jsonStr, HomePageResponse::class.java)
    }

}