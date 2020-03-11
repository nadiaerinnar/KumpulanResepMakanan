package com.example.kumpulanresepmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone_detail.*


class ResepDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)
        var intentThatStartedThisActivity = getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var jenis = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var nama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
            var penjelasan = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)

            tv_jenis_makanan.text = jenis
            tv_nama_Makanan.text = nama
            tv_penjelasan_makanan.text = penjelasan
        }
    }
}