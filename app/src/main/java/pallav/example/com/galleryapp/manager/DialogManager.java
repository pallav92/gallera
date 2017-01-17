package pallav.example.com.galleryapp.manager;

import android.app.Activity;
import android.content.Context;

import pallav.example.com.galleryapp.callbacks.ICustomDialogCallBack;
import pallav.example.com.galleryapp.dialog.CustomAlertPopup;
import pallav.example.com.galleryapp.utils.Utils;


public class DialogManager {
    protected static final String TAG = DialogManager.class.getSimpleName();

    public static void showCustomDialog(Context mContext, String message) {
        Utils.hideSoftKeyboard((Activity) mContext);

        new CustomAlertPopup(mContext, message);
    }

    public static void showCustomDialog(Context mContext, String title, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        Activity activity = (Activity) mContext;
        Utils.hideSoftKeyboard(activity);

        new CustomAlertPopup(activity, title, message, iCustomDialogCallBack);

    }

    /*These methods show custom dialog boxes based on number of parameters passed to them
     */
    public static void showCustomDialog(Activity mContext, String title, String message) {
        Utils.hideSoftKeyboard(mContext);

        new CustomAlertPopup(mContext, title, message);
    }

    public static void showCustomDialog(Activity mContext, String message) {
        Utils.hideSoftKeyboard(mContext);
        new CustomAlertPopup(mContext, message);
    }


    public static CustomAlertPopup showCustomDialog(Activity mContext, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        Utils.hideSoftKeyboard(mContext);
        CustomAlertPopup popup = null;
        popup = new CustomAlertPopup(mContext, message, iCustomDialogCallBack);
        return popup;
    }

    public static void showCustomDialog(Activity mContext, String message, String btn1, String btn2, ICustomDialogCallBack iCustomDialogCallBack) {
        Utils.hideSoftKeyboard(mContext);

        new CustomAlertPopup(mContext, message, btn1, btn2, iCustomDialogCallBack);
    }

    public static void showCustomDialog(Activity mContext, String title, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        Utils.hideSoftKeyboard(mContext);
        new CustomAlertPopup(mContext, title, message, iCustomDialogCallBack);
    }

   /* public static void showChangePasswordDialog(Activity mContext, ChangePasswordDialogData data, ICustomDialogCallBack iCustomDialogCallBack, IChangePasswordDialogListener listener) {

        Utils.hideSoftKeyboard(mContext);
        new ChangePasswordDialog(mContext,data ,  iCustomDialogCallBack , listener);
    }

    public static void showSelectUnitDialog(PlecoBaseActivity mContext, IValueCallBack callBack) {

        Utils.hideSoftKeyboard(mContext);
        new SelectUnitDialog(mContext, callBack);
    }

    public static void showSetLimitDialog(PlecoBaseActivity mContext, ICustomDialogCallBack callBack) {

        Utils.hideSoftKeyboard(mContext);
        new SetLimitDialog(mContext, callBack);
    }*/
}
