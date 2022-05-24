package kotlins.skills.remember

import android.content.Context
import com.example.template.di.ApplicationContext
import com.example.template.di.modules.ActivityBuilder
import com.example.template.di.modules.RepositoryModule
import com.example.template.di.modules.RetrofitModule
import com.example.template.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kotlins.skills.remember.api.requests.repository.UsersRepository
import kotlins.skills.remember.di.dagger.KotlinSkillsModules
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, KotlinSkillsModules::class, RetrofitModule::class,
        ViewModelModule::class, ActivityBuilder::class, RetrofitModule.ApiHelperModule::class, RepositoryModule::class
    ]
)
interface KotlinSkillsComponent {
    fun inject(application: MainApp)

    //New code for retrofit injection
    fun inject(repository: UsersRepository)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder
        fun build(): KotlinSkillsComponent
    }
}
