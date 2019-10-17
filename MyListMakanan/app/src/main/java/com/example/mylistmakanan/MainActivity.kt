package com.example.mylistmakanan

import android.R
import android.os.Bundle
import android.app.Activity
import java.util.ArrayList
import java.util.HashMap
import android.widget.ListView
import android.widget.ListAdapter
import android.widget.SimpleAdapter

class MainActivity : Activity() {

    protected var lv: ListView
    protected var adapter: ListAdapter? = null
    internal var Adapter: SimpleAdapter
    internal var map: HashMap<String, String>
    internal var mylist: ArrayList<HashMap<String, String>>
    internal var Pil: Array<String>
    internal var Ltn: Array<String>
    internal var Gbr: Array<String>

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.lv) as ListView

        Pil = arrayOf("Steak", "Ramen", "Takoyaki", "Sushi", "Fried Chicken")
        Ltn =
            arrayOf("Steak adalah daging sirloin", "Ramen adalah makanan yang berasal dari Jepang", "Takoyaki adalah makanan yang berasal dari Korea", "Sushi adalah makanan yang berasal dari Jepang", "Fried Chicken adalah ayam yang di goreng")
        Gbr = arrayOf(
            Integer.toString(R.drawable.1),
            Integer.toString(R.drawable.2),
            Integer.toString(R.drawable.3),
            Integer.toString(R.drawable.4),
            Integer.toString(R.drawable.5)
        )

        mylist = ArrayList()

        for (i in Pil.indices) {
            map = HashMap()
            map["list"] = Pil[i]
            map["latin"] = Ltn[i]
            map["gbr"] = Gbr[i]
            mylist.add(map)
        }

        Adapter = SimpleAdapter(
            this, mylist, R.layout.layout_isi_lv,
            arrayOf("list", "latin", "gbr"), intArrayOf(R.id.tv_nama, R.id.tv_ltn, R.id.imV)
        )
        lv.adapter = Adapter
    }

}
