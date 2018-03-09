package app.kotlin.com.domain.mapper


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */

import app.kotlin.com.domain.model.HotKey as HotKeyModel
import app.kotlin.com.domain.model.HotKeyItem as HotKeyItemModel
import app.kotlin.com.response.HotKeyItem as HotKeyItemData
import app.kotlin.com.response.HotKeyResponse as HotKeyData

class HotKeyDataMapper {

    fun convertDataListToModelList(dataList: List<HotKeyItemData>) : List<HotKeyItemModel> =
            dataList.map {
                HotKeyItemModel(it.name)
            }

    fun convertDataToModel(responseData : HotKeyData) : HotKeyModel
            = HotKeyModel(convertDataListToModelList(responseData.data))
}