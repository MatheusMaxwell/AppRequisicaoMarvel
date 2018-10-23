package com.example.matheusmaxwellmeireles.apprequisicao

import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class JsonParser {

    companion object {

        var jsonArray = JSONArray()

        fun getJsonArrayFromJson (jsonObject : JSONObject, param : String) : JSONArray{
            var msg = jsonObject.getJSONArray(param)
            return msg
        }

        fun getJsonObjectFromResponse (response : String) : JSONObject {
            val jsonObject = JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1))

            return jsonObject
        }

        fun convertJsonToObject (jsonString : String) : Array<Any> {
            val jsonObject = getJsonObjectFromResponse(jsonString)


            var gson = Gson()

            return gson.fromJson(jsonObject.toString(), Array<MainActivity.Hero>::class.java) as Array<Any>
        }
    }


}