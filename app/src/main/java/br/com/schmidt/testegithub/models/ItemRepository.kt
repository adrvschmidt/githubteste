package br.com.schmidt.testegithub.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ItemRepository(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stargazers_count: Long,
    @SerializedName("score") val score: Double,
    @SerializedName("owner") val owner: OwnerRepositoryObject?,
    @SerializedName("url") val url: String,
    @SerializedName("forks_count") val forks_count: Long,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readDouble(),
        parcel.readTypedObject(OwnerRepositoryObject.CREATOR),
        parcel.readString()!!,
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(full_name)
        parcel.writeString(description)
        parcel.writeLong(stargazers_count)
        parcel.writeDouble(score)
        parcel.writeTypedObject(owner!!, Parcelable.PARCELABLE_WRITE_RETURN_VALUE)
        parcel.writeString(url)
        parcel.writeLong(forks_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemRepository> {
        override fun createFromParcel(parcel: Parcel): ItemRepository {
            return ItemRepository(parcel)
        }

        override fun newArray(size: Int): Array<ItemRepository?> {
            return arrayOfNulls(size)
        }
    }
}
