package kotlins.skills.remember.di.dagger.modules

import com.example.template.di.modules.HomeFragmentModule
import com.example.template.di.modules.RequestConcurrentFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlins.skills.remember.di.dagger.FragmentScope
import kotlins.skills.remember.useCase.Dashborad.RequestConcurrentlyFragment
import kotlins.skills.remember.useCase.Home.HomeFragment
import kotlins.skills.remember.useCase.Notification.NotificationsFragment

@Module
internal class MainActivityModule

@Module
internal interface MainFragmentBuilder {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @FragmentScope
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [RequestConcurrentFragmentModule::class])
    @FragmentScope
    fun RequestConcurrentFragment(): RequestConcurrentlyFragment


    @ContributesAndroidInjector()
    @FragmentScope
    fun notificationFragment(): NotificationsFragment
}
