package dev.liz.myhosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.liz.myhosts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
    }
    
    fun fetchPosts(){
        var apiClient=APIClient.buildAPIClient(ApiInterface::class.java)
        var request=apiClient.getPosts()
        request.enqueue(object : Callback<List<post>> {
            override fun onResponse(call: Call<List<post>>, response: Response<List<post>>) {
            if (response.isSuccessful){
                var posts=response.body()
                Toast.makeText(baseContext,"fetched ${posts!!.size} posts",Toast.LENGTH_LONG).show()
                var adapter=PostAdapter(baseContext,posts)
                Log.d("Tag",posts.toString())
                binding.rvPosts.adapter=adapter
                binding.rvPosts.layoutManager=LinearLayoutManager(baseContext)

            }
            }
            override fun onFailure(call: Call<List<post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
}