package com.example.orderpay.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderpay.R
import com.example.orderpay.model.Character
import com.squareup.picasso.Picasso

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<Character>()
    var onItemClick: ((Character) -> Unit)?  = null
    private var itemPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        itemPosition = position
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setUpdatedData(items: ArrayList<Character>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val tvName: TextView = view.findViewById(R.id.tvName)
        private val imageThumb: ImageView = view.findViewById(R.id.imageThumb)

        init {
            view.setOnClickListener {
                Log.d("adapter", "item clicked")
                onItemClick?.invoke(items[this.layoutPosition])
            }
        }

        fun bind(data: Character) {
            tvName.text = data.name

            Picasso.get()
                .load(data.img)
                .into(imageThumb)
        }
    }
}