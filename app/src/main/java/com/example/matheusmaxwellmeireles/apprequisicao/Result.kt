package com.example.matheusmaxwellmeireles.apprequisicao

import com.google.gson.annotations.SerializedName

class Result {
    constructor(id:Int, name: String?, description: String?, path: String?, extension: String?) {
        this.id = id
        this.name = name
        this.description = description
        this.path = path
        this.extension = extension
    }

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("path")
    var path: String? = null
    @SerializedName("extension")
    var extension: String? = null
}