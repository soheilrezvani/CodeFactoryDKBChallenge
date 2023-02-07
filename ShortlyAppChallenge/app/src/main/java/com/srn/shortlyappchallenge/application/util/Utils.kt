package com.srn.shortlyappchallenge.application.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Created by SoheilR .
 */

fun Context.copyToClipboard(text: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
}