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
        dataList.add(MyItem(R.drawable.accessibility, "지윤", "010-7236-4625",1))
        dataList.add(MyItem(R.drawable.account_circle, "태윤", "010-6947-3562",1))
        dataList.add(MyItem(R.drawable.alarm, "민규", "010-6992-1262",1))
        dataList.add(MyItem(R.drawable.all_out, "윤재", "010-4164-7948",0))
        dataList.add(MyItem(R.drawable.anchor, "연우", "010-7495-1435",1))
        dataList.add(MyItem(R.drawable.android, "정민", "010-7254-1826",0))
        dataList.add(MyItem(R.drawable.assignment_ind, "주안", "010-4836-2585",1))
        dataList.add(MyItem(R.drawable.build, "성현", "010-5286-4852",0))
        dataList.add(MyItem(R.drawable.credit_card, "준수", "010-7681-4275",1))
        dataList.add(MyItem(R.drawable.language, "지훈", "010-4715-1825",1))

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