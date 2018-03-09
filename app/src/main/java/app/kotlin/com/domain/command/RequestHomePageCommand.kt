package app.kotlin.com.domain.command

import app.kotlin.com.domain.mapper.HomePageDataMapper
import app.kotlin.com.domain.model.HomePage
import app.kotlin.com.request.HomePageRequest

/**
 * Created by lzrui on 18-3-3.
 */
class RequestHomePageCommand(private val curPage : Int) : BaseCommand<HomePage>{
    override fun execute(): HomePage {
        return HomePageDataMapper()
                .convertResponseDataToModel(HomePageRequest(curPage).execute())
    }
}