package app.kotlin.com.domain.command


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
interface Command<out T> {
    fun excute(): T
}