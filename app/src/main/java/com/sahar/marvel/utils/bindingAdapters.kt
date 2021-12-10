package com.sahar.marvel.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sahar.marvel.R
import com.sahar.marvel.ui.base.BaseAdapter

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}
@BindingAdapter(value = ["app:image"])
fun setImage(view: ImageView?, imagePath: String?) {
    view?.let {
        Glide.with(view)
            .load(imagePath)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_outline_24)
            .centerCrop()
            .into(view)
    }
}