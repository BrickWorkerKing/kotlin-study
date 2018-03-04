package app.kotlin.com.response


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */

open class ResponseData(errorCode: Int, errorMsg: String)

data class PageInfo<out T>(
        val curPage: Int,
        val datas: List<T>,
        val offset: Int,
        val over: Boolean,
        val pageCount: Int,
        val size: Int,
        val total: Int)