package com.mdgroup.telegrambotapiexample

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.mdgroup.telegrambotapi.Telegram
import com.mdgroup.telegrambotapi.models.Message
import com.mdgroup.telegrambotapi.utils.TelegramCallback
import okhttp3.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botToken = findViewById<TextInputEditText>(R.id.botToken)
        val chatId = findViewById<TextInputEditText>(R.id.chatId)
        val message = findViewById<TextInputEditText>(R.id.message)

        findViewById<Button>(R.id.button).setOnClickListener {
            val telegram = Telegram(botToken.text.toString())

            telegram.sendMessage(
                chatId.text.toString(),
                message.text.toString(),
                object : TelegramCallback<Message> {
                    override fun onResponse(call: Call?, response: Message?) {
                        Toast.makeText(this@MainActivity, "Successful", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call?, e: Exception?) {
                        Toast.makeText(this@MainActivity, "Error\n${e?.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}