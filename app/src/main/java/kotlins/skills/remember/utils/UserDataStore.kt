package kotlins.skills.remember.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import com.example.template.di.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStore @Inject constructor(@ApplicationContext context: Context) {

    // Create the dataStore
    private val dataStore = context.createDataStore(name = "user_prefs")

    // Create some keys
    companion object {
        val USER_AGE_KEY = preferencesKey<Int>("USER_AGE")
        val USER_NAME_KEY = preferencesKey<String>("USER_NAME")
        val USER_INTRO_KEY = preferencesKey<Boolean>("USER_INTRO")
        val USER_PASSWORD_KEY = preferencesKey<String>("USER_PASSWORD")
        val USER_GENDER_KEY = preferencesKey<Boolean>("USER_GENDER")
    }

    // Store user data
    suspend fun storeUser(
        age: Int,
        name: String,
        password: String,
        intro: Boolean,
        isMale: Boolean
    ) {
        dataStore.edit {
            it[USER_AGE_KEY] = age
            it[USER_NAME_KEY] = name
            it[USER_PASSWORD_KEY] = password
            it[USER_INTRO_KEY] = intro
            it[USER_GENDER_KEY] = isMale
        }
    }

    // Store user data
    suspend fun storeIntro(intro: Boolean) {
        dataStore.edit {
            Log.d("Intro", "storeIntro: " + intro)
            it[USER_INTRO_KEY] = intro
        }
    }

    fun loginUser(username: String, password: String): Flow<Boolean> = dataStore.data.map {
        if (it[USER_NAME_KEY].equals(username) && it[USER_PASSWORD_KEY].equals(password))
            true else false
    }

    // Create an age flow
    val userAgeFlow: Flow<Int> = dataStore.data.map {
        val age = it[USER_AGE_KEY] ?: 0

        if (age < 18) {
            Toast.makeText(context, "The user is under 18", Toast.LENGTH_SHORT).show()
        }
        age
    }

    // Create a name flow
    val userNameFlow: Flow<String> = dataStore.data.map {
        it[USER_NAME_KEY] ?: ""
    }

    // Create a gender flow
    val userGenderFlow: Flow<Boolean> = dataStore.data.map {
        it[USER_GENDER_KEY] ?: false
    }

    // Create a gender flow
    val userIntroFlow: Flow<Boolean> = dataStore.data.map {
        it[USER_INTRO_KEY] ?: false
    }
}
