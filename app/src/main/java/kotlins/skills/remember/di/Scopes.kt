package kotlins.skills.remember.di.dagger

import javax.inject.Scope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
internal annotation class ActivityScope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
internal annotation class FragmentScope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
internal annotation class ChildFragmentScope
