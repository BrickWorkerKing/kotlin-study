package app.kotlin.com.response


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */
data class HotKeyResponse(val data: List<HotKeyItem>,
                          val errorCode: Int,
                          val errorMsg: String)
    : ResponseData(errorCode, errorMsg)


data class HotKeyItem(val id: Int,
                      val link: String,
                      val name: String,
                      val order: Int,
                      val visible: Int)