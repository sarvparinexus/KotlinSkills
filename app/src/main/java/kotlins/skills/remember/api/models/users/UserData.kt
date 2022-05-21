package kotlins.skills.remember.api.models.users

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class UserData(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("support")
	val support: Support? = null
)

data class Data(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("pantone_value")
	val pantoneValue: String? = null
)


