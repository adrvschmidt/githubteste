package br.com.schmidt.testegithub.ui.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class OwnerRepositoryObject(
    @SerializedName("id") val id: Long,
    @SerializedName("avatar_url") val avatar: String,
    @SerializedName("login") val login: String,
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(avatar)
        parcel.writeString(login)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OwnerRepositoryObject> {
        override fun createFromParcel(parcel: Parcel): OwnerRepositoryObject {
            return OwnerRepositoryObject(parcel)
        }

        override fun newArray(size: Int): Array<OwnerRepositoryObject?> {
            return arrayOfNulls(size)
        }
    }
}
