package app.kotlin.com.domain.command


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
interface BaseCommand<out T> {
    fun execute(): T
}