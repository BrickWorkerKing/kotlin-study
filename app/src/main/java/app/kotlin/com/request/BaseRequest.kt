package app.kotlin.com.request


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
interface BaseRequest<out T> {
    fun excute(): T
}