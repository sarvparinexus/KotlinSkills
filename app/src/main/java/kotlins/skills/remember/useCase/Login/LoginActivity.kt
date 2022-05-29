/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlins.skills.remember.useCase.Login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.R
import kotlins.skills.remember.useCase.Register.RegistrationActivity
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject
import kotlin.error

class LoginActivity : AppCompatActivity() {

    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var loginViewModel: LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        loginViewModel.loginState.observe(this, Observer<LoginViewState> { state ->
            when (state) {
                is LoginViewState.LoginSuccess -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                is LoginViewState.LoginError -> error.visibility = View.VISIBLE
            }
        })


        setupViews()
    }

    private fun setupViews() {
        val usernameEditText = findViewById<EditText>(R.id.username)
        usernameEditText.isEnabled = false
        usernameEditText.setText(loginViewModel.getUsername())

        val passwordEditText = findViewById<EditText>(R.id.password)
        passwordEditText.doOnTextChanged { _, _, _, _ -> error.visibility = View.INVISIBLE }

        findViewById<Button>(R.id.login).setOnClickListener {
            loginViewModel.login(usernameEditText.text.toString(), passwordEditText.text.toString())
        }
        findViewById<Button>(R.id.unregister).setOnClickListener {
            loginViewModel.unregister()
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}

