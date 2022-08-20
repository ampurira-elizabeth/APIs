package dev.liz.myhosts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.liz.myhosts.databinding.ListPostItemsBinding

class PostAdapter(var post: List<post>) : RecyclerView.Adapter<RetrofitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =
            ListPostItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var current = post.get(position)
        with(holder.binding) {
            tvId.text = current.id.toString()
            tvUserId.text = current.userId.toString()
            tvBody.text = current.body
            tvTitle.text = current.title
            holder.binding.cvPosts.setOnClickListener {
                var context = holder.itemView.context
                val intent = Intent(context, CommentsActivity::class.java)
                intent.putExtra("POST_ID", current.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return post.size
    }
}

class RetrofitViewHolder(var binding: ListPostItemsBinding) :
    RecyclerView.ViewHolder(binding.root)