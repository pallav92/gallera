package pallav.example.com.galleryapp.fcm;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import pallav.example.com.galleryapp.utils.GalleraConstant;

public class FCMMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCMMessagingService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getData());
        String msg = remoteMessage.getNotification().getBody();
        Log.d("notificationType : ", String.valueOf(remoteMessage.getMessageType()));
        sendNotification(msg);

    }
    // [END receive_message]

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param notificationType FCM message body received.
     */
    private void sendNotification(String notificationType) {
        Intent intent = null;
        switch (Integer.parseInt(notificationType)) {
            case 0:

                break;

            case 1:
                intent = new Intent(GalleraConstant.BroadcastNames.MSG_NOTIFICATION_BROADCAST);
                intent.putExtra(GalleraConstant.NOTIFICATION_MSG_TYPE, notificationType);
                break;
        }
        //send broadcast
        getApplicationContext().sendBroadcast(intent);

    }
}