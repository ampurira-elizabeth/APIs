package dev.liz.myhosts


import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
  @GET("/posts")
    fun  getPosts():Call<List<post>>
  @GET("/posts/{postId}")
  fun getPostById(@Path("postId")postId:Int):Call<post>

  @GET("/comments")
     fun getcomments():Call<List<comment>>
     @GET("/comments/{commentId}")
     fun getCommentById(@Path("commentId")commentId:Int):Call<comment>
}