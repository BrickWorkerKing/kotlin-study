package app.kotlin.com.domain.mapper

/**
 * @author ZXW_LZR
 * @date 2018/3/2 0002
 */
import app.kotlin.com.response.HomePageResponse
import app.kotlin.com.domain.model.HomePage as HomePageModel
import app.kotlin.com.domain.model.HomePageItem as HomePageItemModel
import app.kotlin.com.response.HomePageItem as HomePageItemData

class HomePageDataMapper {

    private fun convertDataListToModelList(dataList: List<HomePageItemData>): List<HomePageItemModel>
            = dataList.map {
        HomePageItemModel(it.title, it.chapterName, it.link, it.niceDate)
    }

    fun convertResponseDataToModel(responseData: HomePageResponse): HomePageModel {
        return HomePageModel(convertDataListToModelList(responseData.data.datas))
    }
}
