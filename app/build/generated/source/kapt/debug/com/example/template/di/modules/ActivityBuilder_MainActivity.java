package com.example.template.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlins.skills.remember.MainActivity;
import kotlins.skills.remember.di.dagger.ActivityScope;
import kotlins.skills.remember.di.dagger.modules.MainActivityModule;
import kotlins.skills.remember.di.dagger.modules.MainFragmentBuilder;

@Module(subcomponents = ActivityBuilder_MainActivity.MainActivitySubcomponent.class)
public abstract class ActivityBuilder_MainActivity {
  private ActivityBuilder_MainActivity() {}

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = {MainActivityModule.class, MainFragmentBuilder.class})
  @ActivityScope
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
