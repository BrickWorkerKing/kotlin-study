package app.kotlin.com.util

import android.content.Context
import android.widget.ImageView
import app.kotlin.com.domain.model.HomeBannerImageItem
import com.squareup.picasso.Picasso
import com.youth.banner.loader.ImageLoader


/**
 *
 *
 * @author ZXW_LZR
 * @date 2018/3/5 0005
 */
class BannerImageLoader : ImageLoader() {

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        if (path is HomeBannerImageItem) {
            Picasso.with(context).load(path.imagePath).into(imageView)
        }
    }
}