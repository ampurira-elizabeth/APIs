package dev.liz.myhosts

import org.w3c.dom.Comment

data class post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)

data class  comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body:String
)
