//package org.sopt.navermap.presentation.main
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import org.sopt.navermap.R
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//    }
//}
//

package org.sopt.navermap.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        commitMainSearchFragment()
    }

    private fun commitMainSearchFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_search_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_search_main, MainsearchFragment())
                .commit()
        }
    }
}