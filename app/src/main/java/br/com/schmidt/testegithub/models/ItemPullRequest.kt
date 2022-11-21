package br.com.schmidt.testegithub.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ItemPullRequest (
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String?,
    @SerializedName("user") val user: UserPullRequest?,
    @SerializedName("html_url") val webUrl: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readParcelable(UserPullRequest::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeParcelable(user, flags)
        parcel.writeString(webUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemPullRequest> {
        override fun createFromParcel(parcel: Parcel): ItemPullRequest {
            return ItemPullRequest(parcel)
        }

        override fun newArray(size: Int): Array<ItemPullRequest?> {
            return arrayOfNulls(size)
        }
    }
}