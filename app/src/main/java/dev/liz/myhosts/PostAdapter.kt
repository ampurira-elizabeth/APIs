package dev.liz.myhosts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.liz.myhosts.databinding.ListPostItemsBinding

class PostAdapter(var context:Context, var post: List<post>)
    :RecyclerView.Adapter<RetrofitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding=ListPostItemsBinding.inflate(LayoutInflater.from(context),parent,false)
        return RetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var current=post.get(position)
        with(holder.bindingView){
            tvId.text=current.id.toString()
            tvUserId.text=current.userId.toString()
            tvBody.text=current.body
            tvTitle.text=current.title
        }
    }

    override fun getItemCount(): Int {
  return post.size
    }
}

class RetrofitViewHolder(var bindingView:ListPostItemsBinding):
    RecyclerView.ViewHolder(bindingView.root)