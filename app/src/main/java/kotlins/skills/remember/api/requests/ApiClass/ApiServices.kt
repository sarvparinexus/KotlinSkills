package kotlins.skills.remember.api.requests.ApiClass

import io.reactivex.Single
import kotlins.skills.remember.api.models.product.Product
import kotlins.skills.remember.api.models.users.UserData
import kotlins.skills.remember.api.models.users.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("/api/users?page=2")
    suspend fun listUsers(): Response<UserResponse>

//    @GET("api/ecommerce/v1/allProducts")
//    suspend fun fetchAllProducts(): Response<List<Product>>

    @GET("/api/unknown/{apiLevel}")
    suspend fun fetchDataUserId(@Path("apiLevel") apiLevel: Int):  Response<UserData>
}