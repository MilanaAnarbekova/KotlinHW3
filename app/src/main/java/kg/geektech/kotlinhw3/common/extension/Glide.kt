package kg.geektech.kotlinhw3.common.extension

import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.bumptech.glide.Glide

fun ImageView.loadWithGlide(url: String) {
    Glide.with(this).load(url).into(this)
}
