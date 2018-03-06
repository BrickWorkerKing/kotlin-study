package app.kotlin.com.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homePageRecyclerView.layoutManager = LinearLayoutManager(this)
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

    override fun onStart() {
        super.onStart()
        homeBanner.startAutoPlay()
    }

    override fun onStop() {
        super.onStop()
        homeBanner.stopAutoPlay()
    }
}
