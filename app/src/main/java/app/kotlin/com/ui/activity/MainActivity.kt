package app.kotlin.com.ui.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import app.kotlin.com.R
import app.kotlin.com.domain.command.RequestHomeBannerCommand
import app.kotlin.com.domain.command.RequestHomePageCommand
import app.kotlin.com.domain.mapper.HomeBannerDataMapper
import app.kotlin.com.domain.model.HomeBanner
import app.kotlin.com.domain.model.HomeBannerImageItem
import app.kotlin.com.domain.model.HomePage
import app.kotlin.com.domain.model.HomePageItem
import app.kotlin.com.ui.adapter.HomePageRecyclerAdapter
import app.kotlin.com.util.BannerImageLoader
import app.kotlin.com.util.consume
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.common_title_view.*
import org.jetbrains.anko.appcompat.v7.navigationIconResource
import org.jetbrains.anko.ctx
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {

    override fun getContentView(): Int = R.layout.activity_main

    override fun initView() {
        toolbar.title = getString(R.string.app_name)
        toolbar.navigationIconResource = R.mipmap.ic_home_nav
        toolbar.inflateMenu(R.menu.home_menu)
        homePageRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun initData() {
        doAsync {
            val homePageModel: HomePage = RequestHomePageCommand(0).execute()
            val items: List<HomePageItem>? = homePageModel.items
            uiThread {
                homePageRecyclerView.adapter = HomePageRecyclerAdapter(items) {
                    toast("link == " + it)
                }
            }
        }
        doAsync {
            val homeBannerModel: HomeBanner = RequestHomeBannerCommand().execute()
            val titles: List<String> = HomeBannerDataMapper().convertBannerTitles(homeBannerModel)
            val images: List<HomeBannerImageItem> = HomeBannerDataMapper().convertBannerImages(homeBannerModel)
            uiThread {
                homeBanner
                        .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                        .setImages(images)
                        .setBannerTitles(titles)
                        .setImageLoader(BannerImageLoader())
                        .setOnBannerListener {
                            toast("url == " + images[it].url)
                        }
                        .start()

            }
        }
    }

    override fun initEvent() {
        toolbar.setNavigationOnClickListener { toast("导航") }
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_search -> {
                    consume { toast("搜索") }
                }
                R.id.action_hot -> {
                    consume {
                        val intent = Intent(ctx, HotActivity::class.java)
                        startActivity(intent)
                    }
                }
                else -> {
                    consume { }
                }

            }
        }
    }

    override fun onStart() {
        super.onStart()
        homeBanner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        homeBanner.stopAutoPlay()
    }
}
