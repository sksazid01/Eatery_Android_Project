package com.example.eateryapp.Login

import android.content.Context

object FlagManager {
    private const val PREF_NAME = "MyPrefs"
    private const val FLAG_KEY = "flag"
    fun saveFlag(context: Context, flag: Int) {
        val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.putInt(FLAG_KEY, flag)
        editor.apply()
    }

    fun getFlag(context: Context): Int {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getInt(FLAG_KEY, 0) // Default value is false if flag is not found
    }
}




