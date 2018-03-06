package app.kotlin.com.domain.mapper


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */

import app.kotlin.com.domain.model.FriendWebsite as FriendWebsiteModel
import app.kotlin.com.domain.model.FriendWebsiteItem as FriendWebsiteItemModel
import app.kotlin.com.response.FriendWebsiteItem as FriendWebsiteItemData
import app.kotlin.com.response.FriendWebsiteResponse as FriendWebsiteData

class FriendWebsiteDataMapper {

    fun convertDataListToModelList(dataList: List<FriendWebsiteItemData>): List<FriendWebsiteItemModel> =
            dataList.map {
                FriendWebsiteItemModel(it.name, it.link)
            }

    fun convertResponseDataToModel(responseData: FriendWebsiteData)
            = FriendWebsiteModel(convertDataListToModelList(responseData.data))

}