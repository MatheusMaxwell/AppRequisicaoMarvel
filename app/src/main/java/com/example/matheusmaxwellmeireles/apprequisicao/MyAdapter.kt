package com.example.matheusmaxwellmeireles.apprequisicao

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MyAdapter(val activity: Activity, val heroes : ArrayList<MainActivity.Hero>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = LayoutInflater.from(activity).inflate(R.layout.listview_layout, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.image) as ImageView
        val textView = view.findViewById<TextView>(R.id.txtName) as TextView


        Glide.with(activity).load("${heroes[position].path.toString()}.${heroes[position].extension.toString()}").into(imageView)
        //Glide.with(activity).load("https://ichef.bbci.co.uk/news/ws/660/amz/worldservice/live/assets/images/2015/09/02/150902033128_google_624x351_google_nocredit.jpg").into(imageView)
        textView.text = heroes[position].name.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return heroes.get(position).id
    }

    override fun getCount(): Int {
        return heroes.size
    }


}