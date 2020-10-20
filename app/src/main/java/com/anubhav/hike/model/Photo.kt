package com.anubhav.hike.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Photo {

    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("owner")
    @Expose
    private var owner: String? = null

    @SerializedName("secret")
    @Expose
    private var secret: String? = null

    @SerializedName("server")
    @Expose
    private var server: String? = null

    @SerializedName("farm")
    @Expose
    private var farm: Int? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("ispublic")
    @Expose
    private var ispublic: Int? = null

    @SerializedName("isfriend")
    @Expose
    private var isfriend: Int? = null

    @SerializedName("isfamily")
    @Expose
    private var isfamily: Int? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getOwner(): String? {
        return owner
    }

    fun setOwner(owner: String?) {
        this.owner = owner
    }

    fun getSecret(): String? {
        return secret
    }

    fun setSecret(secret: String?) {
        this.secret = secret
    }

    fun getServer(): String? {
        return server
    }

    fun setServer(server: String?) {
        this.server = server
    }

    fun getFarm(): Int? {
        return farm
    }

    fun setFarm(farm: Int?) {
        this.farm = farm
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getIspublic(): Int? {
        return ispublic
    }

    fun setIspublic(ispublic: Int?) {
        this.ispublic = ispublic
    }

    fun getIsfriend(): Int? {
        return isfriend
    }

    fun setIsfriend(isfriend: Int?) {
        this.isfriend = isfriend
    }

    fun getIsfamily(): Int? {
        return isfamily
    }

    fun setIsfamily(isfamily: Int?) {
        this.isfamily = isfamily
    }
}