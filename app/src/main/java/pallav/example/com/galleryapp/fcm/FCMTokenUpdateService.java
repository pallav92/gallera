package pallav.example.com.galleryapp.fcm;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import pallav.example.com.galleryapp.utils.GalleraConstant;

public class FCMTokenUpdateService extends FirebaseInstanceIdService {

    private static final String TAG = "FCMTokenUpdateService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
      /*  // Get updated InstanceID token.
        String refreshedToken = Utils.getFireBaseToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);*/
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        if(refreshedToken == null) {
            onTokenRefresh();
        }else {
            final Intent intent = new Intent("tokenReceiver");
            // You can also include some extra data.
            final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
            intent.putExtra(GalleraConstant.PreferenceKeeperNames.FIREBASE_TOKEN,refreshedToken);
            broadcastManager.sendBroadcast(intent);
        }
        Log.d("FCM TOKEN GET", "Refreshed token: " + refreshedToken);
/*
        final Intent intent = new Intent("tokenReceiver");
        // You can also include some extra data.
        final LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        intent.putExtra(PlecoConstants.PreferenceKeeperNames.FIREBASE_TOKEN,refreshedToken);
        if(refreshedToken!=null) {
            broadcastManager.sendBroadcast(intent);
        }else{
            DialogManager.showCustomDialog(getApplicationContext(),"Check Your internet connection");
        }*/
        // TODO: Implement this method to send any registration to your app's servers.
       // sendRegistrationToServer(refreshedToken);
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // Add custom implementation, as needed.
    }
}
