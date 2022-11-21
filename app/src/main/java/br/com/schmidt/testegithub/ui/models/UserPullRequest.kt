package br.com.schmidt.testegithub.ui.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserPullRequest(
    @SerializedName("login") val userName: String?,
    @SerializedName("avatar_url") val avatar: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserPullRequest> {
        override fun createFromParcel(parcel: Parcel): UserPullRequest {
            return UserPullRequest(parcel)
        }

        override fun newArray(size: Int): Array<UserPullRequest?> {
            return arrayOfNulls(size)
        }
    }
}
