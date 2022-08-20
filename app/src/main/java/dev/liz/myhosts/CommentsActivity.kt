package dev.liz.myhosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.liz.myhosts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding: ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainpostId()
        fetchpostById()
        setuptoolBar()
    }

    fun obtainpostId(){
        postId=intent.extras?.getInt("POST_ID",)?: 0
    }
    fun fetchpostById(){
        val apiclient=APIClient.buildAPIClient(ApiInterface::class.java)
        var request=apiclient.getPostById(postId)
        request.enqueue(object: Callback<post> {
            override fun onResponse(call: Call<post>, response: Response<post>) {
               if (response.isSuccessful){
                   var post=response.body()
                   binding.tvPostTitle.text=post?.title
                   binding.tvPostBody.text=post?.body
               }
            }

            override fun onFailure(call: Call<post>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setuptoolBar(){
       setSupportActionBar(binding.toolbarComments)
       supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}