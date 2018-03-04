package app.kotlin.com.domain.command

import app.kotlin.com.domain.mapper.HomePageDataMapper
import app.kotlin.com.domain.model.HomePage
import app.kotlin.com.request.HomePageRequest

/**
 * Created by lzrui on 18-3-3.
 */
class RequestHomePageCommand(val curPage : Int) : Command<HomePage>{
    override fun excute(): HomePage {
        return HomePageDataMapper()
                .convertResponseDataToModel(HomePageRequest(curPage).excute())
    }
}