package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MyMovieAdapter(
  private val context: Context,
  private val movieList: MutableList<Movie>
) :
  RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

  class MyViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    val image: ImageView = binding.imageMovie
    val txt_name: TextView = binding.txtName
    val txt_team: TextView = binding.txtTeam
    val txt_createdby: TextView = binding.txtCreatedby

    fun bind(listItem: Movie) {
      image.setOnClickListener {
        Toast.makeText(it.context, "нажал на ${image}", Toast.LENGTH_SHORT)
          .show()
      }
      itemView.setOnClickListener {
        Toast.makeText(it.context, "нажал на ${txt_name.text}", Toast.LENGTH_SHORT).show()
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return MyViewHolder(ItemLayoutBinding.inflate(inflater, parent, false))
  }

  override fun getItemCount() = movieList.size

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val listItem = movieList[position]
    holder.bind(listItem)

    Picasso.get().load(movieList[position].imageurl).into(holder.image)
    holder.txt_name.text = movieList[position].name
    holder.txt_team.text = movieList[position].team
    holder.txt_createdby.text = movieList[position].createdby
  }

}
