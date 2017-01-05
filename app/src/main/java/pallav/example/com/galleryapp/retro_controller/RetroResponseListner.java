/*
package pallav.example.com.galleryapp.retro_controller;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import net.hockeyapp.android.LoginActivity;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import pallav.example.com.galleryapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetroResponseListner<T> implements Callback<T> {
    private static final String TAG = RetroResponseListner.class.getName();
    private final Context context;

    public RetroResponseListner(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
*/
/*

        PlecoBaseActivity activity = (PlecoBaseActivity) context;

        if (activity != null)
            activity.hideProgressDialog();

        if (response != null)
            if (response != null) {
                BaseResponse<T> body = response.body();
                if (body != null) {
                    int responseStatus = body.getStatus();
                    if (responseStatus == 1) {
                        onSuccess(body.getResponse());


                        return;
                    } else if (responseStatus == 0) {
//                        List<Error> errors = body.getErrors();
//                        onError(errors.get(0));
                        onError(body.getErrors());
                        return;
                    }
                } else {
                    if (response.raw() != null && response.raw().message() != null) {
                        onError(activity.getString(R.string.error_msg));
                        return;


                    }
                }
            }
        DialogManager.showCustomDialog(activity, activity.getString(R.string.error_msg));*//*

    }

    public void onError(final Error error) {
        */
/*final PlecoBaseActivity activity = (PlecoBaseActivity) context;
        if (activity != null) {
            activity.hideProgressDialog();*//*


           */
/* // if email does not exist
            if (error.getCode().equals(4)) {

                DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                    @Override
                    public void onOkClicked(Dialog dialog) {
                    }

                    @Override
                    public void onCancelClicked(Dialog dialog) {

                    }
                });
            }
            if (error.getCode().equals(5)) {

                DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                    @Override
                    public void onOkClicked(Dialog dialog) {


                    }

                    @Override
                    public void onCancelClicked(Dialog dialog) {

                    }
                });
            }
            else {
                DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                    @Override
                    public void onOkClicked(Dialog dialog) {

                    }

                    @Override
                    public void onCancelClicked(Dialog dialog) {

                    }
                });
            }

*//*


           */
/* switch (Integer.parseInt(error.getCode()))
            {
                case 2:

                    PlecoPrefKeeper prefKeeper = PlecoPrefKeeper.getInstance(context);
                    Utils.saveUserData(context , null);
                    prefKeeper.saveDeviceData(false);
                    activity.launchActivityByClearExisting(LoginActivity.class , true);

                    break;

                case 4:
                    DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                        @Override
                        public void onOkClicked(Dialog dialog) {
                        }

                        @Override
                        public void onCancelClicked(Dialog dialog) {

                        }
                    });
                    break;

                case 5:
                    DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                        @Override
                        public void onOkClicked(Dialog dialog) {


                        }

                        @Override
                        public void onCancelClicked(Dialog dialog) {

                        }
                    });
                    break;

                default:
                    DialogManager.showCustomDialog(activity, error.getMsg(), new ICustomDialogCallBack() {
                        @Override
                        public void onOkClicked(Dialog dialog) {

                        }

                        @Override
                        public void onCancelClicked(Dialog dialog) {

                        }
                    });
                    break;


            }
        }*//*

    }


    public void onError(String msg) {
       */
/* PlecoBaseActivity activity = (PlecoBaseActivity) context;
        if (activity != null) {
            activity.hideProgressDialog();
            DialogManager.showCustomDialog(activity, msg);
        }*//*


    }

    protected abstract void onSuccess(T response);


    @Override
    public void onFailure(Call<BaseResponse<T>> call, Throwable t) {
        Log.d(TAG, "onFailure() called with: " + "call = [" + call + "], t = [" + t + "]");
        PlecoBaseActivity activity = (PlecoBaseActivity) context;
        if (activity != null)
            activity.hideProgressDialog();

        if (t instanceof ConnectException)
            DialogManager.showCustomDialog(activity, activity.getString(R.string.internet_error_msg));
        else if (t instanceof SocketTimeoutException)
            DialogManager.showCustomDialog(activity, activity.getString(R.string.internet_error_msg));
        else if (t instanceof UnknownHostException)
            DialogManager.showCustomDialog(activity, activity.getString(R.string.internet_error_msg));
        else
            DialogManager.showCustomDialog(activity, activity.getString(R.string.error_msg));

    }

}
*/
