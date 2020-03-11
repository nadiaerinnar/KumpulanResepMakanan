package com.example.kumpulanresepmakanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.contact_list_item.view.*

class ResepAdapter(
    private val phoneItemList: List<ResepData>,
    private val clickListener: (ResepData) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(phoneItemList[position], clickListener)
    }

    override fun getItemCount() = phoneItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(phone: ResepData, clickListener: (ResepData) -> Unit) {

            Glide.with(itemView).load(phone.poster).into(itemView.img_poster)
            itemView.tv_part_item_name.text = phone.foodName
            itemView.tv_part_id.text = phone.jenis

            itemView.setOnClickListener { clickListener(phone) }
        }
    }
}
