package com.example.kumpulanresepmakanan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textData = createPhoneData()

        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ResepAdapter(textData) { phoneItem: ResepData ->
            phoneItemClicked(phoneItem)
        }
    }

    private fun phoneItemClicked(phoneItem: ResepData) {
        val showDetailActivityIntent = Intent(this, ResepDetailActivity::class.java)
        showDetailActivityIntent.putExtra(ResepDetailActivity.EXTRA_ITEM, phoneItem)
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneData(): List<ResepData> {
        val partList = ArrayList<ResepData>()
        partList.add(
            ResepData(
                "Menu Special Sayuran",
                R.drawable.pecel,
                "PECEL",
                "Pecel merupakan bahan utama makanan menggunakan jenis sayur " +
                        "yaitu kangkung, kacang panjang, kol, irisan timun, dan tauge"
            )
        )

        partList.add(
            ResepData(
                "Menu Special Goreng",
                R.drawable.nasi_goreng,
                "NASI GORENG JAWA",
                "Nasi Goreng adalah makanan khas Jawa, yang nasinya digoreng menggunakan kecap manis" +
                        "serta yang isinya terdiri dari ikan teri atau ayam kampung suwir, tauge, babat goreng, serta irisan kol, dan sawi hijau ditambah Telur Mata Sapi/ Dadar"
            )
        )

        partList.add(
            ResepData(
                "Menu Special Berkuah",
                R.drawable.rujak_soto,
                "RUJAK SOTO",
                "Rujak Soto merupakan makanan khas dari Banyuwangi yang menggabungkan" +
                        "2 jenis makanan yakni soto kuning dengan rujak"
            )
        )

        partList.add(
            ResepData(
                "Menu Special Sayuran",
                R.drawable.tahu_campur,
                "TAHU CAMPUR",
                "Tahu Campur merupakan makanan khas Surabaya yang terdiri dari selada" +
                        "tauge, lontong, mie kuning, tahu goreng, dan potongan lentho singkong yang menyatu kedalam kuah kaldu tetelan sapi yang gurih"
            )
        )

        partList.add(
            ResepData(
                "Menu Special Buah",
                R.drawable.rujak_cingur,
                "RUJAK CINGUR",
                "Rujak Cingur merupakan makanan khas Surabaya yang terdiri dari irisan " +
                        "beberapa jenis buah seperti timun, bengkuang, nanas yang dipadukan dengan lontong/nasi, tahu, tempe, cingur, sayuran, dan disiram saus petis udang "
            )
        )
        return partList
    }
}
