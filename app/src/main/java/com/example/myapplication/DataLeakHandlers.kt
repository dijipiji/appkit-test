package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.artifex.solib.ArDkDoc
import com.artifex.solib.ConfigOptions
import com.artifex.sonui.editor.NUIDocView
import com.artifex.sonui.editor.SOCustomSaveComplete
import com.artifex.sonui.editor.SODataLeakHandlers;
import com.artifex.sonui.editor.SOSaveAsComplete

class DataLeakHandlers : SODataLeakHandlers {

    override fun initDataLeakHandlers(p0: Activity?, p1: ConfigOptions?) {
        Log.e("tjo", "initDataLeakHandlers");
    }

    override fun finaliseDataLeakHandlers() {
        TODO("Not yet implemented")
    }

    override fun onActivityResult(p0: Int, p1: Int, p2: Intent?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun insertImageHandler(p0: NUIDocView?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun insertPhotoHandler(p0: NUIDocView?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun pauseHandler(p0: ArDkDoc?, p1: Boolean, p2: Runnable?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun doInsert() {
        throw UnsupportedOperationException("Not supported")
    }

    override fun printHandler(p0: ArDkDoc?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun launchUrlHandler(p0: String?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun customSaveHandler(p0: String?, p1: ArDkDoc?, p2: String?, p3: SOCustomSaveComplete?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun saveAsHandler(p0: String?, p1: ArDkDoc?, p2: SOSaveAsComplete?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun postSaveHandler(p0: SOSaveAsComplete?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun saveAsPdfHandler(p0: String?, p1: ArDkDoc?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun openInHandler(p0: String?, p1: ArDkDoc?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun openPdfInHandler(p0: String?, p1: ArDkDoc?) {
        throw UnsupportedOperationException("Not supported")
    }

    override fun shareHandler(p0: String?, p1: ArDkDoc?) {
        throw UnsupportedOperationException("Not supported")
    }


}