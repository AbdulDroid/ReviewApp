package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SampleInteractionCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(sample_rv) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = SampleRecyclerAdapter(setData(), this@MainActivity)
        }
    }

    private fun setData(): List<SampleData> {
        return listOf(
            SampleData("Abdul", R.drawable.image_1, "Lagos"),
            SampleData("Chinedu", R.drawable.image2, "Yaba"),
            SampleData("Azeeza", R.drawable.image3, "Unknown"),
            SampleData("Ikechi", R.drawable.images_4, "Uknown"),
            SampleData("Bukses", R.drawable.image3, "Uknown"),
            SampleData("Dairo", R.drawable.images_4, "Uknown")

        )
    }

    override fun onClick(item: SampleData) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("data", item)
        }
        startActivity(intent)
    }
}
