# TelegramBotAPI

[![Release](https://jitpack.io/v/mobile-development-group/TelegramBotApi.svg)]
(https://jitpack.io/#mobile-development-group/TelegramBotApi)

This is clone telegrambotlibrary from ajts.
(com.ajts.library.telegrambot:telegrambotlibrary:1.0.0)
It stopped connecting through dependencies, and we also couldn’t find the source code on GitHub, so we created a clone.

To add library to your own project:
###### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```
###### Step 2. Add the dependency
```
dependencies {
    implementation 'com.github.mobile-development-group:TelegramBotApi:1.0.0'
}
```
###### Step 3. Usage

```
// For send message
val telegram = Telegram(BOT_TOKEN)
telegram.sendMessage(CHAT_ID, message, object : TelegramCallback<Message> {
    override fun onResponse(call: Call?, response: Message?) {
        // Successful block
    }

    override fun onFailure(call: Call?, e: Exception?) {
        // Error block
    }
})

// For send message
telegram.sendLocation(CHAT_ID, latitude, longitude, telegramCallback)

// For send photo
telegram.sendPhoto(CHAT_ID, mediaType, file, caption, telegramCallback)

// For send document
telegram.sendDocument(CHAT_ID, mediaType, file, caption, telegramCallback)
...

```