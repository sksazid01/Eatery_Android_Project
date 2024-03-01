package com.example.eateryapp.Data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.io.FileOutputStream


@Composable
fun WriteToFile(fileName: String, content: String) {
    val context = LocalContext.current
    try {
        Log.d("FileWriting", "File path: ${context.filesDir.absolutePath}/$fileName")

        val openFileOutput = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        openFileOutput.use {
            it.write(content.toByteArray())
        }
        Log.d("FileWriting", "Data written to file successfully!")
    } catch (e: Exception) {
        Log.e("FileWriting", "Error writing to file: $e")
    }
}