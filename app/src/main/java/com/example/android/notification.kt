package com.example.android

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.android.databinding.ActivityNotificationBinding

class notification : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding
    lateinit var nm:NotificationManagerCompat
    val CHANNEL_ID = "channel1"
    lateinit var requestLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it){
//                grantetd
//                nm.notify(100,notification)

            }else{
//                denied
            }
        }


        nm= NotificationManagerCompat.from(this)
        var notification: Notification
            if (android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O) {
         notification =  NotificationCompat.Builder(this, CHANNEL_ID)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.icon_android_studio
                    )
                )
                .setSmallIcon(R.drawable.icon_android_studio)
                .setContentText("Content text")
                .setSubText("SubText")
                .setContentTitle("Content Title")
                .setChannelId(CHANNEL_ID)
                .build()
            nm.createNotificationChannel(NotificationChannel(CHANNEL_ID, "Channel1_1", NotificationManager.IMPORTANCE_HIGH))

        }else{
            notification=NotificationCompat.Builder(this, CHANNEL_ID)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.icon_android_studio
                    )
                )
                .setSmallIcon(R.drawable.icon_android_studio)
                .setContentText("Content text")
                .setSubText("SubText")
                .setContentTitle("Content Title")
                .build()
        }
        binding.notificationPush.setOnClickListener(View.OnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                return@OnClickListener
            }
            nm.notify(100,notification)
        })
        binding.notificationDelete.setOnClickListener(View.OnClickListener {
            nm.cancel(100)
        })
    }
}