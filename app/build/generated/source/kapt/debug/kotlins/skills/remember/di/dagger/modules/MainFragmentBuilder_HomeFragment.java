package kotlins.skills.remember.di.dagger.modules;

import com.example.template.di.modules.HomeFragmentModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlins.skills.remember.di.dagger.FragmentScope;
import kotlins.skills.remember.useCase.Home.HomeFragment;

@Module(subcomponents = MainFragmentBuilder_HomeFragment.HomeFragmentSubcomponent.class)
public abstract class MainFragmentBuilder_HomeFragment {
  private MainFragmentBuilder_HomeFragment() {}

  @Binds
  @IntoMap
  @ClassKey(HomeFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      HomeFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = HomeFragmentModule.class)
  @FragmentScope
  public interface HomeFragmentSubcomponent extends AndroidInjector<HomeFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<HomeFragment> {}
  }
}
