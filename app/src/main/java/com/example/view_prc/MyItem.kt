package com.example.view_prc

data class MyItem(val aIcon:Int, val aName:String, val aPhone:String, val Favorites:Int ) {
        companion object {
               const val VIEW_TYPE_LEFT = 0
               const val VIEW_TYPE_RIGHT = 1
        }
}