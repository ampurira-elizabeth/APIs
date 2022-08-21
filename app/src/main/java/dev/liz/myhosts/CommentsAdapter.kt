package dev.liz.myhosts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.liz.myhosts.databinding.ListCommentsItemsBinding
import dev.liz.myhosts.databinding.ListPostItemsBinding

class CommentsAdapter(var comment: List<comment>) : RecyclerView.Adapter<RetrofitViewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewsHolder {
      var binding=ListCommentsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  RetrofitViewsHolder(binding)
    }
    override fun onBindViewHolder(holder: RetrofitViewsHolder, position: Int) {
       var currentcomment=comment.get(position)
    with(holder.binding){
        tvCName.text=currentcomment.name.toString()
        tvCbody.text=currentcomment.body.toString()

    }
    }

    override fun getItemCount(): Int {
        return comment.size
    }

}

class RetrofitViewsHolder(var binding: ListCommentsItemsBinding) :
    RecyclerView.ViewHolder(binding.root)