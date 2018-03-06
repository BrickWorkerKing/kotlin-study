package app.kotlin.com.domain.command

import app.kotlin.com.domain.mapper.FriendWebsiteDataMapper
import app.kotlin.com.domain.model.FriendWebsite
import app.kotlin.com.request.FriendWebsiteRequest


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
class FriendWebsiteCommand : Command<FriendWebsite> {

    override fun execute(): FriendWebsite {
        return FriendWebsiteDataMapper().convertResponseDataToModel(FriendWebsiteRequest().execute())
    }
}