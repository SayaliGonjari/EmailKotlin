package com.project.emailkotlin

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.LiveFolders.INTENT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_send.setOnClickListener {
            val mailBody = edit_mailBody.text.toString()!!
            sendEmail(mailBody);
        }

    }

    private fun sendEmail(mailBody: String) {
        val eIntent = Intent(Intent.ACTION_SEND, Uri.fromParts("mailTo", mailBody, null))
        eIntent.putExtra(Intent.EXTRA_SUBJECT, "Mail send from kotlin Project")
        eIntent.putExtra(Intent.EXTRA_TEXT, "Hello from kotlin")
        startActivity(Intent.createChooser(eIntent, "Send Email !!"))
    }
}