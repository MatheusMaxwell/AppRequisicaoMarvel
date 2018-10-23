package com.example.matheusmaxwellmeireles.apprequisicao

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listview_layout.*
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import java.io.Serializable
import java.lang.reflect.Type
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : Activity() {

    var stringJson = ""
    var heroes = emptyArray<Hero>()


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayListHero = ArrayList<Hero>()
        var arrayListHeroBusca = ArrayList<Hero>()

        val url = "https://gateway.marvel.com/v1/public/characters?series=24229%2C%203621&ts=2&orderBy=name&limit=100&apikey=31a48619c2630212ff85b83ab88f105e&hash=2c9d1a72e792157752cb49d482e0e49a"
        getHeroes(url, arrayListHero)





        btnBusca.setOnClickListener({
            if(edtBusca.text.isEmpty()){
                getHeroes(url, arrayListHero)
            }
            else{
                val urlBusca = "https://gateway.marvel.com/v1/public/characters?series=24229%2C%203621&ts=2&orderBy=name&nameStartsWith=${edtBusca.text.toString()}&limit=100&apikey=31a48619c2630212ff85b83ab88f105e&hash=2c9d1a72e792157752cb49d482e0e49a"

                getHeroes(urlBusca, arrayListHeroBusca)
            }

            arrayListHeroBusca.clear()

        })

        list.setOnItemClickListener{
            parent: AdapterView<*>?, view: View?, position: Int, id: Long ->

            for(i in arrayListHero){
                if(i.id == id){
                    val intent = Intent(this, Main2Activity::class.java)
                    intent.putExtra("hero", i)
                    startActivity(intent)
                }
            }

        }

    }

    fun getHeroes (url: String, arrayListHeroes:ArrayList<Hero>){
        val que = Volley.newRequestQueue(this@MainActivity)
        val req = StringRequest(Request.Method.GET, url, Response.Listener { response ->
            val getArray = JSONObject(response).get("data")
            val getArray2 = JSONObject(getArray.toString()).getJSONArray("results")
            // val getName = JSONObject(getArray2.toString()).getString("name")

            //Toast.makeText(this, getName, Toast.LENGTH_LONG).show()

            for(i in 0..(getArray2.length()-1)){
                var hero = Hero(getArray2.getJSONObject(i).getLong("id"), getArray2.getJSONObject(i).getString("name"),
                        getArray2.getJSONObject(i).getString("description"), getArray2.getJSONObject(i).getJSONObject("thumbnail").getString("path"),
                        getArray2.getJSONObject(i).getJSONObject("thumbnail").getString("extension"))

                arrayListHeroes.add(hero)
            }


            val adapter = MyAdapter(this, arrayListHeroes)

            list.adapter = adapter



        }, Response.ErrorListener {
            Toast.makeText(this, "Não foi possivel conectar com o servidor.", Toast.LENGTH_LONG).show()
        })
        que.add(req)
    }



    data class Hero (val id: Long, val name: String, val description: String, val path: String, val extension: String): Serializable{}

}



