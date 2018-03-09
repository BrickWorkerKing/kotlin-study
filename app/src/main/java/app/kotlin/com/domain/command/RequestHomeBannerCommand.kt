package app.kotlin.com.domain.command

import app.kotlin.com.domain.mapper.HomeBannerDataMapper
import app.kotlin.com.domain.model.HomeBanner
import app.kotlin.com.request.HomeBannerRequest


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
class RequestHomeBannerCommand : BaseCommand<HomeBanner> {

    override fun execute(): HomeBanner {
        val responseData = HomeBannerRequest().execute()
        return HomeBannerDataMapper().convertDataToModel(responseData)
    }

}