package com.sahar.marvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.sahar.marvel.databinding.ActivityMainBinding
import com.sahar.marvel.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(){

    override val theme = R.style.Theme_Marvel
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
}