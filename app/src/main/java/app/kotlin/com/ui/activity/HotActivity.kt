package app.kotlin.com.ui.activity

import app.kotlin.com.R
import app.kotlin.com.domain.command.FriendWebsiteCommand
import app.kotlin.com.domain.model.FriendWebsite
import app.kotlin.com.domain.model.FriendWebsiteItem
import app.kotlin.com.ui.adapter.HotTagFlowAdapter
import app.kotlin.com.util.consume
import app.kotlin.com.util.toast
import kotlinx.android.synthetic.main.activity_hot.*
import kotlinx.android.synthetic.main.common_title_view.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/6 0006
 */
class HotActivity : BaseActivity() {

    private var friendList: List<FriendWebsiteItem>? = null

    override fun getContentView(): Int = R.layout.activity_hot

    override fun initView() {
        toolbar.title = getString(R.string.title_hot)
        toolbar.navigationIconResource = R.mipmap.ic_back
        friendFlowLayout.setOnTagClickListener { view, position, parent ->
            consume {
                val link: String? = friendList?.get(position)?.link
                toast("link == " + link)
            }
        }
    }

    override fun initData() {
        doAsync {
            val friendWebsiteModel: FriendWebsite = FriendWebsiteCommand().execute()
            friendList = friendWebsiteModel.items
            uiThread {
                friendFlowLayout.adapter = HotTagFlowAdapter(friendWebsiteModel.items)
            }
        }

        doAsync {

            uiThread {
                //                hotKeyFlowLayout.adapter = HotTagFlowAdapter()
            }
        }
    }

    override fun initEvent() {
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}