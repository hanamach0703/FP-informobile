package com.example.drawernavi.ui.News

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.drawernavi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class News : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCommentAPI()
    }

    fun getCommentAPI(){
        val retro = Retro().getRetroClientInstance().create(CommentAPI::class.java)
        retro.getComments().enqueue(object : Callback<List<Comment>> {

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                val comment = response.body()
                for (c in comment!!){
                    Log.e("Hasil", c.name.toString())

                }
            }

        })
    }
}