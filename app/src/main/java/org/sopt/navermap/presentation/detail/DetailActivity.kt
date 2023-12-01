package org.sopt.navermap.presentation.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import org.sopt.dosopttemplate.util.binding.DataBindingActivity
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityDetailBinding
import org.sopt.navermap.presentation.route.RouteActivity

class DetailActivity :
    DataBindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    var intColorCode = 255
    private val viewModel: DetailViewModel by viewModels { DetailViewModelFactory() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getDetail(1)
        binding.ivDetailArrive.setOnClickListener {
            val intent = Intent(this, RouteActivity::class.java)
            startActivity(intent)
        }
        initGetDetailResultObserver()
        initAppbarOffsetChangedListener()
    }

    private fun initGetDetailResultObserver() {
        viewModel.getDetailResult.observe(this) {
            binding.data = it
        }
    }

    private fun initAppbarOffsetChangedListener() {
        binding.detailAppbar.addOnOffsetChangedListener { _, verticalOffset ->
            intColorCode = -verticalOffset / 2
            if (intColorCode > 255) {
                intColorCode = 255
            }

            if (intColorCode > 50) {
                binding.ivDetailBack.setColorFilter(getColor(R.color.gray_4))
                binding.ivDetailClose.setColorFilter(getColor(R.color.gray_4))
            } else {
                binding.ivDetailBack.setColorFilter(getColor(R.color.white))
                binding.ivDetailClose.setColorFilter(getColor(R.color.white))
            }
            binding.tbDetailTitle.background.alpha = intColorCode
            binding.tvDetailMain.alpha = intColorCode.toFloat() / 255f
        }
    }
}