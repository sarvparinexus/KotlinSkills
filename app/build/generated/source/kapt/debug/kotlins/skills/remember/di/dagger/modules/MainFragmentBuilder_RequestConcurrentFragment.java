package kotlins.skills.remember.di.dagger.modules;

import com.example.template.di.modules.RequestConcurrentFragmentModule;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlins.skills.remember.di.dagger.FragmentScope;
import kotlins.skills.remember.useCase.Dashborad.RequestConcurrentlyFragment;

@Module(
  subcomponents =
      MainFragmentBuilder_RequestConcurrentFragment.RequestConcurrentlyFragmentSubcomponent.class
)
public abstract class MainFragmentBuilder_RequestConcurrentFragment {
  private MainFragmentBuilder_RequestConcurrentFragment() {}

  @Binds
  @IntoMap
  @ClassKey(RequestConcurrentlyFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      RequestConcurrentlyFragmentSubcomponent.Factory builder);

  @Subcomponent(modules = RequestConcurrentFragmentModule.class)
  @FragmentScope
  public interface RequestConcurrentlyFragmentSubcomponent
      extends AndroidInjector<RequestConcurrentlyFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<RequestConcurrentlyFragment> {}
  }
}
