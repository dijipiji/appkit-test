package com.example.myapplication

import com.artifex.solib.SOSecureFS

class SecureFS : SOSecureFS {
    override fun isSecurePath(p0: String?): Boolean {
        return false
    }

    override fun getTempPath(): String? {
        return null
    }

    override fun getFileAttributes(p0: String?): SOSecureFS.FileAttributes? {
        return null
    }

    override fun renameFile(p0: String?, p1: String?): Boolean {
        return false
    }

    override fun copyFile(p0: String?, p1: String?): Boolean {
        return false
    }

    override fun deleteFile(p0: String?): Boolean {
        return false
    }

    override fun fileExists(p0: String?): Boolean {
        return false
    }

    override fun recursivelyRemoveDirectory(p0: String?): Boolean {
        return false
    }

    override fun createDirectory(p0: String?): Boolean {
        return false
    }

    override fun createFile(p0: String?): Boolean {
        return false
    }

    override fun getFileHandleForReading(p0: String?): Any {
        TODO("Not yet implemented")
    }

    override fun getFileHandleForWriting(p0: String?): Any {
        TODO("Not yet implemented")
    }

    override fun getFileHandleForUpdating(p0: String?): Any {
        TODO("Not yet implemented")
    }

    override fun closeFile(p0: Any?): Boolean {
        return true
    }

    override fun setFileLength(p0: Any?, p1: Long): Boolean {
        return false
    }

    override fun readFromFile(p0: Any?, p1: ByteArray?): Int {
        TODO("Not yet implemented")
    }

    override fun writeToFile(p0: Any?, p1: ByteArray?): Int {
        TODO("Not yet implemented")
    }

    override fun syncFile(p0: Any?): Boolean {
        return false
    }

    override fun getFileLength(p0: Any?): Long {
        TODO("Not yet implemented")
    }

    override fun getFileOffset(p0: Any?): Long {
        TODO("Not yet implemented")
    }

    override fun seekToFileOffset(p0: Any?, p1: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun getSecurePath(): String? {
        return null
    }

    override fun getSecurePrefix(): String? {
        return null
    }
}