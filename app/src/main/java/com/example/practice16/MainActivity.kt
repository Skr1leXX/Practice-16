package com.example.practice16

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val themeKey = "theme"
    private lateinit var switchThemeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setAppTheme()

        setContentView(R.layout.activity_main)


        sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)


        switchThemeButton = findViewById(R.id.switchThemeButton)


        switchThemeButton.setOnClickListener {
            toggleTheme()
        }
    }

    private fun setAppTheme() {

        val theme = sharedPreferences.getString(themeKey, "light")


        if (theme == "dark") {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun toggleTheme() {

        val currentTheme = sharedPreferences.getString(themeKey, "light")
        val newTheme = if (currentTheme == "light") "dark" else "light"

        sharedPreferences.edit().putString(themeKey, newTheme).apply()


        recreate()
    }
}