package com.example.myapplication

import android.content.Context
import com.artifex.sonui.editor.SOPersistentStorage;

class PersistentStorage : SOPersistentStorage {
    override fun getStorageObject(p0: Context?, p1: String?): Any? {
        return null
    }

    override fun setStringPreference(p0: Any?, p1: String?, p2: String?) {
    }

    override fun getStringPreference(p0: Any?, p1: String?, p2: String?): String? {
        return null
    }

    override fun getAllStringPreferences(p0: Any?): MutableMap<String, *>? {
        return null
    }

    override fun removePreference(p0: Any?, p1: String?) {
    }

}