package kotlins.skills.remember.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlins.skills.remember.BaseViewModel
import kotlins.skills.remember.api.requests.UserServices
import kotlins.skills.remember.repository.UsersRepository
import kotlins.skills.remember.userCase.Dashborad.UiState
import kotlins.skills.remember.userCase.Home.HomeViewModel
import kotlins.skills.remember.userCase.Notification.NotificationViewModel
import kotlins.skills.remember.userCase.Dashborad.PerformNetworkRequestsConcurrentlyViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        NotificationViewModel(get())
    }
    viewModel {
        PerformNetworkRequestsConcurrentlyViewModel(get())
    }

    viewModel {
        BaseViewModel<UiState>()
    }
}



val repositoryModule = module {
    single {
        UsersRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }

    single { provideUseApi(get()) }
}

private fun getBaseUrl(): String {
    return "https://reqres.in"
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(factory))
            .baseUrl(getBaseUrl())
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}