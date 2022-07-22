package com.example.bankuishchallenge.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bankuishchallenge.R
import com.example.bankuishchallenge.model.Item
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val mListener: (Item) -> Unit) :
    PagingDataAdapter<Item, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         holder.bind(getItem(position)!!,mListener)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int ): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_repo,parent,false)
        return MyViewHolder(inflater)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val cardView: CardView = view.findViewById(R.id.card_view)
        private val imageView: ImageView = view.findViewById(R.id.imageView)
        private val title: TextView = view.findViewById(R.id.title)
        private val subtitle:TextView = view.findViewById(R.id.subtitle)
        fun bind(data: Item, mListener: (Item) -> Unit){
            try {
                Picasso.get().load(data.owner.avatar_url).into(imageView)
            } catch (e:Exception){
                println("IMAGE" + e.message)
            }
            title.text = data.name
            subtitle.text = data.description

            cardView.setOnClickListener { mListener(data)}
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }


}