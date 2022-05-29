package kotlins.skills.remember.di.dagger.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlins.skills.remember.di.dagger.FragmentScope
import kotlins.skills.remember.useCase.Dashborad.RequestConcurrentlyFragment
import kotlins.skills.remember.useCase.Home.HomeFragment
import kotlins.skills.remember.useCase.Notification.NotificationsFragment
import kotlins.skills.remember.useCase.Register.RegisterFragment

@Module
internal class MainActivityModule

@Module
internal interface MainFragmentBuilder {

    @ContributesAndroidInjector()
    @FragmentScope
    fun homeFragment(): HomeFragment

    @ContributesAndroidInjector()
    @FragmentScope
    fun registerFragment(): RegisterFragment

    @ContributesAndroidInjector()
    @FragmentScope
    fun requestConcurrentFragment(): RequestConcurrentlyFragment

    @ContributesAndroidInjector()
    @FragmentScope
    fun notificationFragment(): NotificationsFragment
}
