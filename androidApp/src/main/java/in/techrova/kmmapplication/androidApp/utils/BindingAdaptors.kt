package `in`.techrova.kmmapplication.androidApp.utils

import `in`.techrova.kmmapplication.androidApp.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdaptors {

    companion object {
        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun bindImage(imageView: ImageView,url: String?)
        {
            Glide.with(imageView)
                .load(url)
                .error(R.drawable.profile)
                .into(imageView)
        }
    }
}

class Click
{

}