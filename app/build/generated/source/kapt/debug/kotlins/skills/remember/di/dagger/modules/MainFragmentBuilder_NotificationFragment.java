package kotlins.skills.remember.di.dagger.modules;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlins.skills.remember.di.dagger.FragmentScope;
import kotlins.skills.remember.useCase.Notification.NotificationsFragment;

@Module(
  subcomponents = MainFragmentBuilder_NotificationFragment.NotificationsFragmentSubcomponent.class
)
public abstract class MainFragmentBuilder_NotificationFragment {
  private MainFragmentBuilder_NotificationFragment() {}

  @Binds
  @IntoMap
  @ClassKey(NotificationsFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      NotificationsFragmentSubcomponent.Factory builder);

  @Subcomponent
  @FragmentScope
  public interface NotificationsFragmentSubcomponent
      extends AndroidInjector<NotificationsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<NotificationsFragment> {}
  }
}
