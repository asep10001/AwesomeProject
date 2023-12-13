package com.awesomeproject

import com.astrapay.qrissdk.helper.AstraPayQris
import com.astrapay.qrissdk.helper.AstraPayQrisListener
import com.astrapay.qrissdk.helper.EventType
import com.astrapay.qrissdk.helper.data.AstraPayQrisAuth
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class APSdkModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext), AstraPayQrisListener {
    override fun getName(): String {
        return "APSdkModule"
    }

    @ReactMethod
    fun navigateToQris(){
        val astraPayAuth = AstraPayQrisAuth(
            context = reactApplicationContext,
            //userToken = "saBJVbaPuaOI7YkW/15WyceKAEAOU0178AAmZmj3FdfkXq6tZlDZNFogkoGzGfzg",
            authorizationToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiIwODEzOTY0NDExMTUiLCJyb2xlcyI6WyJMT0dJTiJdLCJpc3MiOiJBc3RyYVBheS1EZXYiLCJ0eXBlIjoiQUNDRVNTIiwidXNlcklkIjoyMDAyMzksImRldmljZUlkIjoiMTIzIiwidHJhbnNhY3Rpb25JZCI6IiIsInRyYW5zYWN0aW9uVHlwZSI6IiIsImFjY291bnRJZCI6OTMxLCJhY2NvdW50SWRQb2ludCI6MTYsIm5iZiI6MTY4OTMwNjgwOSwidXNlclR5cGUiOiJDVVNUT01FUiIsImV4cCI6MTY4OTMxMDQwOSwiaWF0IjoxNjg5MzA2ODA5LCJqdGkiOiI5MDMxNjIyZC01YTdhLTRhZmItOTk4NS1hNjQ2Y2U3NjkzMzIiLCJlbWFpbCI6WyJub3ZlbGxpbGluZ2dhQGdtYWlsLmNvbSJdfQ.FOovm3ZpEGHrfXSvY7msngrBBtsXu1iOouEHd1AdXnVt5GG_PAizGQB56j1fo17C2D8g8e0haYsHuBHeETzGrqeVIw1pgHUxO23t4zCvutrNI0ZP8gVit6-R1XSkkc4aTU4_Rm7SOBmQNH3ewmntyC8FfMgfZL41WlZklLny-gPH-ULVUxSDfUMp2kLcACNgsUplfQSpUAn4Ch8J42DYmkJ4VGhjWNzWswfuSGGil-FLY7CTeQtFxHJe7ZUvcp3AXLJE4YqURq3Jv5KuRS-T52e3VjhiCLUx7YQ9lSeOjqeQzHTBauMmC-t-AzcwOjlMF8kQu_pNzNdjQqZ5J6jNJA",
            listener = this,
        )

        AstraPayQris.execute(
            astraPayQrisAuth = astraPayAuth
        )
    }

    override fun onCancel() {
        TODO("Not yet implemented")
    }

    override fun onComplete(type: EventType) {
        TODO("Not yet implemented")
    }

    override fun onFailed() {
        TODO("Not yet implemented")
    }

    override fun onForbidden() {
        TODO("Not yet implemented")
    }

    override fun onPaylaterWrongPinAccountLocked() {
        TODO("Not yet implemented")
    }

    override fun onProcessing() {
        TODO("Not yet implemented")
    }

    override fun onShowHistory() {
        TODO("Not yet implemented")
    }

    override fun onUnregisteredPaylaterAccount() {
        TODO("Not yet implemented")
    }
}