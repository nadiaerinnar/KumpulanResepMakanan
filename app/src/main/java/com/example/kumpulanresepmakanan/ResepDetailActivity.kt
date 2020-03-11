package com.example.kumpulanresepmakanan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_phone_detail.*

class ResepDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM = "extra_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)

        if (intent.hasExtra(EXTRA_ITEM)) {
            val makanan = intent.getParcelableExtra<ResepData>(EXTRA_ITEM)

            makanan?.let {
                tv_jenis_makanan.text = it.jenis
                tv_nama_Makanan.text = it.foodName
                tv_penjelasan_makanan.text = it.penjelasan
                Glide.with(applicationContext).load(it.poster).into(img_poster)
            }
        }
    }
}