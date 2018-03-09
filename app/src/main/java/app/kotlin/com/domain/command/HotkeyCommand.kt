package app.kotlin.com.domain.command

import app.kotlin.com.domain.mapper.HotKeyDataMapper
import app.kotlin.com.domain.model.HotKey
import app.kotlin.com.request.HotKeyRequest


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/7 0007
 */
class HotkeyCommand : BaseCommand<HotKey> {

    override fun execute(): HotKey =
            HotKeyDataMapper().convertDataToModel(HotKeyRequest().execute())

}