package app.kotlin.com.domain.model


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */
data class HotKeyItem(val name: String)

data class HotKey(val items: List<HotKeyItem>)