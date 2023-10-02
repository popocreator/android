package com.uxmonster.template.model

import android.os.Parcel
import android.os.Parcelable

class User() : Parcelable {
    var id: Int = 0
    var username: String? = ""
    var password: String? = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        username = parcel.readString()
        password = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(username)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}