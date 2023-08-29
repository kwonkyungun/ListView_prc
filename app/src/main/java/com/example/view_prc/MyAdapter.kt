package com.android.customitemview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.view_prc.MyItem
import com.example.view_prc.MyItem.Companion.VIEW_TYPE_LEFT
import com.example.view_prc.MyItem.Companion.VIEW_TYPE_RIGHT
import com.example.view_prc.databinding.Item1Binding
import com.example.view_prc.databinding.Item2Binding
import java.lang.RuntimeException


class MyAdapter(val mItems: MutableList<MyItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val adapterLayout: View?
        // 뷰 타입을 추가
        return when (viewType) {
            VIEW_TYPE_LEFT -> {
                val binding =
                    Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Holder1(binding)
            }

            VIEW_TYPE_RIGHT -> {
                val binding =
                    Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return Holder2(binding)
            }

            else -> throw RuntimeException("알수 없는 뷰 타입")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        val contact = mItems[position]

        when (contact.Favorites) {
            VIEW_TYPE_LEFT -> {
                if (holder is Holder1) {
                    holder.iconImageView1.setImageResource(mItems[position].aIcon)
                    holder.name1.text = mItems[position].aName
                    holder.pone1.text = mItems[position].aPhone
                    holder.setIsRecyclable(false)
                }
            }

            VIEW_TYPE_RIGHT -> {
                if (holder is Holder2) {
                    holder.iconImageView2.setImageResource(mItems[position].aIcon)
                    holder.name2.text = mItems[position].aName
                    holder.pone2.text = mItems[position].aPhone
                    holder.setIsRecyclable(false)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (mItems[position].Favorites == 1) {
            return VIEW_TYPE_LEFT
        }else
            return VIEW_TYPE_RIGHT

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder1(val binding: Item1Binding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView1 = binding.imageView1
        val name1 = binding.nameText1
        val pone1 = binding.poneNumber1
    }

    inner class Holder2(val binding: Item2Binding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView2 = binding.imageView2
        val name2 = binding.nameText2
        val pone2 = binding.poneNumber2
    }
}