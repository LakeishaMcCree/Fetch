package com.example.fetch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch.adapter.RewardAdapter
import com.example.fetch.api.ApiInterface
import com.example.fetch.model.FetchDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var rewardAdapter: RewardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        rewardAdapter = RewardAdapter(this)

        val layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false).apply {
                recyclerView.layoutManager = this
        }
        DividerItemDecoration(
            this, layoutManager.orientation).apply {
            recyclerView.addItemDecoration(this)
        }
       // recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = rewardAdapter

        val apiInterface = ApiInterface.create().getReward()

        apiInterface.enqueue(object : Callback<List<FetchDataItem>?> {
            override fun onResponse(
                call: Call<List<FetchDataItem>?>,
                response: Response<List<FetchDataItem>?>
            ) {
                if (response.isSuccessful) {
                    rewardAdapter.setFetchData(response.body()!!)
                }

                //if (response.body() !=null)
                    //rewardAdapter.setFetchData(response.body()!!)
            }

            override fun onFailure(call: Call<List<FetchDataItem>?>, t: Throwable) {

            }
        })
    }



}