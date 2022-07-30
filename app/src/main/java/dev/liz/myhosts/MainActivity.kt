package dev.liz.myhosts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            }
            }
            override fun onFailure(call: Call<List<post>>, t: Throwable) {

            }
        })
    }
}