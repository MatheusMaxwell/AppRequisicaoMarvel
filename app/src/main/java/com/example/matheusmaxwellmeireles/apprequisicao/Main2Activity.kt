package com.example.matheusmaxwellmeireles.apprequisicao

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val hero = intent.getSerializableExtra("hero") as MainActivity.Hero

        Glide.with(this).load("${hero.path.toString()}.${hero.extension.toString()}").into(imageView)
        txtNome.text = "NAME: ${hero.name}"
        txtDesc.text = "DESCRIPTION: ${hero.description}"
    }
}
