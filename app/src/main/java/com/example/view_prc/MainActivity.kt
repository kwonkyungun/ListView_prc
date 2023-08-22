package com.example.view_prc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.customitemview.MyAdapter
import com.example.view_prc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.accessibility, "Bella", "1"))
        dataList.add(MyItem(R.drawable.account_circle, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.alarm, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.all_out, "Duke", "1"))
        dataList.add(MyItem(R.drawable.anchor, "Max", "2"))
        dataList.add(MyItem(R.drawable.android, "Happy", "4"))
        dataList.add(MyItem(R.drawable.assignment_ind, "Luna", "3"))
        dataList.add(MyItem(R.drawable.build, "Bob", "2"))


        binding.listView.adapter = MyAdapter(dataList)


        val adapter = MyAdapter(dataList)
        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager(this)


        // 항목 클릭 이벤트 처리
        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}