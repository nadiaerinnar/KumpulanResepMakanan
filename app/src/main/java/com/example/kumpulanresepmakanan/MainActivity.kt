package com.example.kumpulanresepmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_phone_detail.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ResepAdapter(textData, { phoneItem : ResepData -> phoneItemClicked(phoneItem) })
    }

    private fun phoneItemClicked(phoneItem : ResepData) {
        val showDetailActivityIntent = Intent(this, ResepDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.jenis)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, phoneItem.foodName)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, phoneItem.penjelasan)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData() : List<ResepData> {
        val partList = ArrayList<ResepData> ()
        partList.add(ResepData("Menu Special Sayuran", "PECEL", "Pecel merupakan bahan utama makanan menggunakan jenis sayur " +
                                                                                        "yaitu kangkung, kacang panjang, kol, irisan timun, dan tauge"))

        partList.add(ResepData("Menu Special Goreng", "NASI GORENG JAWA", "Nasi Goreng adalah makanan khas Jawa, yang nasinya digoreng menggunakan kecap manis" +
                "serta yang isinya terdiri dari ikan teri atau ayam kampung suwir, tauge, babat goreng, serta irisan kol, dan sawi hijau ditambah Telur Mata Sapi/ Dadar"))

        partList.add(ResepData("Menu Special Berkuah", "RUJAK SOTO", "Rujak Soto merupakan makanan khas dari Banyuwangi yang menggabungkan" +
                                                                                                "2 jenis makanan yakni soto kuning dengan rujak"))

        partList.add(ResepData("Menu Special Sayuran", "TAHU CAMPUR", "Tahu Campur merupakan makanan khas Surabaya yang terdiri dari selada" +
                "tauge, lontong, mie kuning, tahu goreng, dan potongan lentho singkong yang menyatu kedalam kuah kaldu tetelan sapi yang gurih"))

        partList.add(ResepData("Menu Special Buah", "RUJAK CINGUR", "Rujak Cingur merupakan makanan khas Surabaya yang terdiri dari irisan " +
                "beberapa jenis buah seperti timun, bengkuang, nanas yang dipadukan dengan lontong/nasi, tahu, tempe, cingur, sayuran, dan disiram saus petis udang "))
        return partList
    }
}
