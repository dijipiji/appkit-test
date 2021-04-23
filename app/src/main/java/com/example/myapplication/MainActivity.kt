package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.view.MenuItem
import android.net.Uri
import android.os.Environment
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import java.io.File

import com.artifex.sonui.editor.DocumentView
import com.artifex.solib.FileUtils
import com.artifex.solib.ArDkLib
import com.artifex.solib.ConfigOptions
import com.artifex.sonui.editor.Utilities

class MainActivity : AppCompatActivity() {
    var isSetup : Boolean = false

    private val REQUEST_EXTERNAL_STORAGE = 1

    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // 1.
        // Ask permission - make sure your manifest has:
        /*
        <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
         */
        var askPermission:Boolean = false

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            ) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            askPermission = true
        }

        if (askPermission) {
            // Not immediately granted, so ask.
            // We'll return in onRequestPermissionsResult()
            ActivityCompat.requestPermissions(
                this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE
            )
            return
        }

        gotPermission()


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_EXTERNAL_STORAGE -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    // Permission was granted.
                    gotPermission()
                } else {
                    // Permission denied.
                    finish()
                }
                return
            }
        }
    }

    fun gotPermission() {

        // 2. Ensure to set the basic configuration options for ArDkLib
        val configOptions = ConfigOptions()
        ArDkLib.setAppConfigOptions(configOptions)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            if (!isSetup) {
                Snackbar.make(view, "Setting up!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

                Utilities.setDataLeakHandlers(DataLeakHandlers())
                Utilities.setPersistentStorage(PersistentStorage())
                ArDkLib.setClipboardHandler(ClipboardHandler())
                //ArDkLib.setSecureFS(SecureFS()) // Let's talk about SecureFS another day ...
                FileUtils.init(this)
                isSetup = true
            }
            else {
                Snackbar.make(view, "Already set up!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

            var dirpath : String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()

            // 3. Ensure that test.pdf exists in "Files/Downloads" on you device or emulator
            var filepath : String = dirpath + File.separator + "test.pdf"

            val documentView : DocumentView = findViewById<View>(R.id.doc_view) as DocumentView
            // 4. Ensure to set the configuration options and data leak handler on the documentView
            documentView.setDocConfigOptions(ArDkLib.getAppConfigOptions())
            documentView.setDocDataLeakHandler(Utilities.getDataLeakHandlers())

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