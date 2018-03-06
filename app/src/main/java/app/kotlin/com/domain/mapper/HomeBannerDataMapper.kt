package app.kotlin.com.domain.mapper


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */

import app.kotlin.com.domain.model.HomeBannerImageItem
import app.kotlin.com.domain.model.HomeBanner as HomeBannerModel
import app.kotlin.com.domain.model.HomeBannerItem as HomeBannerItemModel
import app.kotlin.com.response.HomeBannerItem as HomeBannerItemData
import app.kotlin.com.response.HomeBannerResponse as HomeBannerData

class HomeBannerDataMapper {

    private fun convertDataListToModelList(dataList: List<HomeBannerItemData>): List<HomeBannerItemModel>
            = dataList.map {
        HomeBannerItemModel(it.title, it.url, it.imagePath)
    }

    fun convertDataToModel(responseData: HomeBannerData): HomeBannerModel
            = HomeBannerModel(convertDataListToModelList(responseData.data))

    fun convertBannerTitles(homeBanner: HomeBannerModel): List<String> {
        val items: List<HomeBannerItemModel> = homeBanner.items
        return items.map { it.title }
    }

    fun convertBannerImages(homeBanner: HomeBannerModel): List<HomeBannerImageItem> {
        val items: List<HomeBannerItemModel> = homeBanner.items
        return items.map { HomeBannerImageItem(it.url, it.imagePath) }
    }
}