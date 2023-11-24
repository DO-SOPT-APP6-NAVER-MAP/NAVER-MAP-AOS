package org.sopt.navermap.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.navermap.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main_search_result)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_main_search_result, MainsearchFragment())       // 흠...
                .commit()
        }
    }
}