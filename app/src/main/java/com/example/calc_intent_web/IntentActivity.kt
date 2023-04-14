package com.example.calc_intent_web

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var smsbutton: Button
    lateinit var callbutton: Button
    lateinit var camerabutton: Button
    lateinit var stkbutton: Button
    lateinit var dialbutton: Button
    lateinit var sharebutton: Button
    lateinit var emailbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        smsbutton = findViewById(R.id.Btn_Sms)
        callbutton = findViewById(R.id.Btn_Call)
        camerabutton = findViewById(R.id.Btn_Camera)
        stkbutton = findViewById(R.id.Btn_Stk)
        dialbutton = findViewById(R.id.Btn_Dial)
        sharebutton = findViewById(R.id.Btn_Share)
        emailbutton = findViewById(R.id.Btn_Email)

        smsbutton.setOnClickListener {
            val uri = Uri.parse("smsto:0706845000")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "Good morning")
            startActivity(intent)
        }

        callbutton.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }


        }

        emailbutton.setOnClickListener {
            val emailintent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "malutibethuel@gmail.com", null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailintent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailintent,"send email...."))
        }

        camerabutton.setOnClickListener {
            val takepic = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic, 1)
        }

        stkbutton.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        dialbutton.setOnClickListener {
            val nambari = "+254767456756"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", nambari, null))
            startActivity(intent)
        }

        sharebutton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hi, click to download")
            startActivity(shareIntent)
        }

    }
}