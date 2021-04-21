package com.example.myapplication

import android.app.Activity
import com.artifex.solib.SOClipboardHandler

class ClipboardHandler : SOClipboardHandler {
    override fun putPlainTextToClipboard(p0: String?) {
    }

    override fun getPlainTextFromClipoard(): String? {
        return null
    }

    override fun clipboardHasPlaintext(): Boolean {
        return false
    }

    override fun initClipboardHandler(p0: Activity?) {
    }
}