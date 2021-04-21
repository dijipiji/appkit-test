package com.example.myapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.view.MenuItem
import android.net.Uri
import android.os.Environment

import java.io.File

import com.artifex.sonui.editor.DocumentView
import com.artifex.solib.FileUtils
import com.artifex.solib.ArDkLib
import com.artifex.sonui.editor.Utilities

class MainActivity : AppCompatActivity() {
    var isSetup : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            if (!isSetup) {
                Snackbar.make(view, "Setting up!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

                Utilities.setDataLeakHandlers(DataLeakHandlers())
                Utilities.setPersistentStorage(PersistentStorage())
                ArDkLib.setClipboardHandler(ClipboardHandler())
                ArDkLib.setSecureFS(SecureFS())
                FileUtils.init(this)
                isSetup = true
            }
            else {
                Snackbar.make(view, "Already set up!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }

            var dirpath : String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
            var filepath : String = dirpath + File.separator + "test.pdf"

            val documentView : DocumentView = findViewById<View>(R.id.doc_view) as DocumentView
            documentView.start(Uri.fromFile(File(filepath)), 0, true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}