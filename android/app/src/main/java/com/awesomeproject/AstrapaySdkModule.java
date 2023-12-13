package com.awesomeproject;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.astrapay.qrissdk.AstraPaySdkApplication;
import com.astrapay.qrissdk.helper.AstraPayQris;
import com.astrapay.qrissdk.helper.AstraPayQrisListener;
import com.astrapay.qrissdk.helper.EventType;
import com.astrapay.qrissdk.helper.data.AstraPayQrisAuth;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.function.Function;

public class AstrapaySdkModule extends ReactContextBaseJavaModule implements AstraPayQrisListener {

    private final ReactApplicationContext reactContext;

    private AstrapayCallback reactOnComplete;


    public AstrapaySdkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    interface AstrapayCallback {
        void onSuccess();
        void onError();
    }

    @NonNull
    @Override
    public String getName() {
        return "AstrapaySdkModule";
    }

    @ReactMethod
    public void setupAstrapaySdk(String token) {
        System.out.println("berhasil memasukan token");
    }

    @ReactMethod
    public String getSdkToken(String token) {
        return token;
    }

    @ReactMethod
    public void setUpQris(){
        AstraPayQris.INSTANCE.setup("XTOKEN", AstraPayQris.Build.UAT, true, true);
    }

    @ReactMethod
    public void navigateToQris(String token){
        final Activity activity = getCurrentActivity();
        if(activity != null){
            AstraPayQrisAuth astraPayAuth = new AstraPayQrisAuth(
                    activity,
                    //userToken = "saBJVbaPuaOI7YkW/15WyceKAEAOU0178AAmZmj3FdfkXq6tZlDZNFogkoGzGfzg",
                    token,
                    this,
                    false
            );
            System.out.println(token);
            AstraPayQris.INSTANCE.execute(astraPayAuth);
        }


        System.out.println(activity);

    }

    @Override
    public void onComplete(@NonNull EventType eventType) {
        this.reactOnComplete.onSuccess();
    }

    @Override
    public void onFailed() {
        this.reactOnComplete.onError();

    }

    @Override
    public void onForbidden() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onProcessing() {

    }

    @Override
    public void onShowHistory() {

    }

    @Override
    public void onUnregisteredPaylaterAccount() {

    }

    @Override
    public void onPaylaterWrongPinAccountLocked() {

    }
}
