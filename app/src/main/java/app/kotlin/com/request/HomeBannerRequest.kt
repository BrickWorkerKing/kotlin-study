package app.kotlin.com.request

import app.kotlin.com.response.HomeBannerResponse
import com.google.gson.Gson
import java.net.URL


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
class HomeBannerRequest : BaseRequest<HomeBannerResponse> {

    companion object {
        private val BANNER_URL: String = "http://www.wanandroid.com/banner/json"
    }

    override fun execute(): HomeBannerResponse {
        val jsonStr = URL(BANNER_URL).readText()
        return Gson().fromJson(jsonStr, HomeBannerResponse::class.java)
    }
}