package kotlins.skills.remember

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlins.skills.remember.navigation.TabManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val tabManager: TabManager by lazy { TabManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            tabManager.currentController = tabManager.navHomeController
            if (intent.containsDeepLink()) {
                handleDeepLink()
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        tabManager.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tabManager.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        tabManager.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        tabManager.onBackPressed()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        tabManager.switchTab(menuItem.itemId)
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        if (this.intent.containsDeepLink()) {
            handleDeepLink()
        }
    }

    private fun handleDeepLink() {
        intent.data?.pathSegments?.also { deepLinkPathSegments ->
            when (deepLinkPathSegments.firstOrNull()?.trim()) {
                "dashboard" -> R.id.navigation_dashboard
                "home" -> R.id.navigation_home
                "notifications" -> R.id.navigation_notifications
                "pages" -> {
                    tabManager.currentController?.navigate(
                        NavigationGraphMainDirections.actionGlobalPageFragment(
                            getPageNumberFromSegments(deepLinkPathSegments),
                            "PageFragment"
                        )
                    )
                    null
                }
                else -> null
            }?.also {
                tabManager.switchTab(it)
                bottomNavigationView.menu.findItem(it).isChecked = true
            }
        }
    }

    private fun getPageNumberFromSegments(deepLinkPathSegments: List<String>): Int =
        if (deepLinkPathSegments.size < 2) 0 else deepLinkPathSegments[1].toIntOrNull() ?: 0

    private fun Intent.containsDeepLink(): Boolean = action == Intent.ACTION_VIEW && data != null

    override fun androidInjector() = dispatchingAndroidInjector
}
