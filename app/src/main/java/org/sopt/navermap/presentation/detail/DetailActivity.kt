package org.sopt.navermap.presentation.detail

import android.os.Bundle
import org.sopt.navermap.R
import org.sopt.navermap.databinding.ActivityDetailBinding
import org.sopt.navermap.util.binding.ViewBindingActivity

class DetailActivity :
    ViewBindingActivity<ActivityDetailBinding>({ ActivityDetailBinding.inflate(it) }) {
    var intColorCode = 255
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.detailAppbar.addOnOffsetChangedListener{ _, verticalOffset ->
            intColorCode = -verticalOffset/2
            if (intColorCode > 255) {
                intColorCode = 255
            }

            if(intColorCode > 50) {
                binding.ivDetailBack.setColorFilter(getColor(R.color.gray_4))
                binding.ivDetailClose.setColorFilter(getColor(R.color.gray_4))
            } else {
                binding.ivDetailBack.setColorFilter(getColor(R.color.white))
                binding.ivDetailClose.setColorFilter(getColor(R.color.white))
            }
            binding.tbDetailTitle.background.alpha = intColorCode
            binding.tvDetailMain.alpha = intColorCode.toFloat()/255f
        }
    }
}