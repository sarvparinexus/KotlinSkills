package kotlins.skills.remember.api.models.users

import com.google.gson.annotations.SerializedName

data class UsersBaseResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String? = null,
    @SerializedName("username") val username: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("address") val address: Address,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("website") val website: String? = null,
    @SerializedName("company") val company: Company
)

data class Geo(

    @SerializedName("lat") val lat: Double? = null,
    @SerializedName("lng") val lng: Double? = null
)

data class Company(

    @SerializedName("name") val name: String? = null,
    @SerializedName("catchPhrase") val catchPhrase: String? = null,
    @SerializedName("bs") val bs: String? = null
)

data class Address(

    @SerializedName("street") val street: String? = null,
    @SerializedName("suite") val suite: String? = null,
    @SerializedName("city") val city: String? = null,
    @SerializedName("zipcode") val zipcode: String? = null,
    @SerializedName("geo") val geo: Geo
)


//data class UserData(
//    @SerializedName("login") val login: String?,
//    @SerializedName("id") val id: Int?,
//    @SerializedName("node_id") val nodeId: String?,
//    @SerializedName("avatar_url") val avatarUrl: String?,
//    @SerializedName("gravatar_id") val gravatarId: String?,
//    @SerializedName("url") val url: String?,
//    @SerializedName("html_url") val htmlUrl: String?,
//    @SerializedName("followers_url") val followersUrl: String?,
//    @SerializedName("following_url") val followingUrl: String?,
//    @SerializedName("gists_url") val gistsUrl: String?,
//    @SerializedName("starred_url") val starredUrl: String?,
//    @SerializedName("subscriptions_url") val subscriptionsUrl: String?,
//    @SerializedName("organizations_url") val organizationsUrl: String?,
//    @SerializedName("repos_url") val reposUrl: String?,
//    @SerializedName("events_url") val eventsUrl: String?,
//    @SerializedName("received_events_url") val receivedEventsUrl: String?,
//    @SerializedName("type") val type: String?,
//    @SerializedName("site_admin") val siteAdmin: Boolean?,
//    @SerializedName("name") val name: String?,
//    @SerializedName("company") val company: String?,
//    @SerializedName("blog") val blog: String?,
//    @SerializedName("location") val location: String?,
//    @SerializedName("email") val email: String?,
//    @SerializedName("hireable") val hireable: String?,
//    @SerializedName("bio") val bio: String?,
//    @SerializedName("twitter_username") val twitterUsername: String?,
//    @SerializedName("public_repos") val publicRepos: Int?,
//    @SerializedName("public_gists") val publicGists: Int?,
//    @SerializedName("followers") val followers: Int?,
//    @SerializedName("following") val following: Int?,
//    @SerializedName("created_at") val createdAt: String?,
//    @SerializedName("updated_at") val updatedAt: String?
//)