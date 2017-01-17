package pallav.example.com.galleryapp.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.metrics.MetricsManager;

import pallav.example.com.galleryapp.R;
import pallav.example.com.galleryapp.utils.GalleraConstant;
import pallav.example.com.galleryapp.utils.Utils;

/**
 * Created by pallav on 17/1/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    public Fragment currentFragment;
    public String fragmentTag;
    private boolean showDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkForCrashes();
        checkForUpdates();
        Utils.hideSoftKeyboard(BaseActivity.this);
        //addMetrics();
    }


    /**
     * launch new activity
     *
     * @param activityClass
     */
    public void launchActivity(Class<? extends BaseActivity> activityClass, boolean isAnimateRequired) {
        startActivity(new Intent(this, activityClass));
        if (isAnimateRequired)
            overridePendingTransitionEnter();
    }


    /**
     * launch new activity with flags
     *
     * @param activityClass
     * @param flag
     */
    public void launchActivity(Class<? extends BaseActivity> activityClass, int flag) {
        Intent intent = new Intent(this, activityClass);
        intent.setFlags(flag);
        startActivity(intent);
    }

    public void launchActivityByClearExisting(Class<? extends BaseActivity> aClass, boolean isAnimateRequired) {
        Intent intent = new Intent(this, aClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        if (isAnimateRequired) {
            overridePendingTransitionEnter();
        }
    }

    public void launchActivityByclearExistingWithData(Class<? extends BaseActivity> aClass, Bundle bundle) {
        Intent intent = new Intent(this, aClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    /**
     * launch new activity with bundle data
     *
     * @param classType
     * @param bundle
     */
    public void launchActivity(Class<? extends Activity> classType, Bundle bundle, boolean isAnimateRequired) {
        Intent intent = new Intent(this, classType);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isAnimateRequired)
            overridePendingTransitionEnter();
    }

    public void startActivityForResult(Class<? extends Activity> classObject, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, classObject);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    public void showToast(String s) {
        if (!TextUtils.isEmpty(s)) {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(BaseActivity.this, "", "", true);
            progressDialog.setContentView(R.layout.progresslayout);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }


    public void replaceFragment(int containerId, String fragmentTagToBeAdded, @SuppressWarnings("SameParameterValue") int enter, int exit, int enterPop, int exitPop, boolean isNextFragmentNeedsTobeAdded, Bundle bundle) {
        FragmentManager manager = getSupportFragmentManager();
        if (manager != null) {
            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            if (fragmentTagToBeAdded == null) {
                return;
            }
            fragmentTransaction.setCustomAnimations(enter, exit, enterPop, exitPop);
            if (isNextFragmentNeedsTobeAdded) {
                fragmentTransaction.addToBackStack(fragmentTagToBeAdded);
            }
            Fragment fragment;
            fragment = manager.findFragmentByTag(fragmentTagToBeAdded);

            if (fragment == null)
                fragment = Fragment.instantiate(this, fragmentTagToBeAdded, bundle);
            if (fragment.isAdded()) {
                return;
            }
            currentFragment = fragment;
            fragmentTag = fragmentTagToBeAdded;

            fragmentTransaction.replace(containerId, fragment, fragmentTagToBeAdded);
            fragmentTransaction.commit();

        }
    }


    // method call as screen orientation change
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    private void checkForCrashes() {
        CrashManager.register(this, GalleraConstant.HOCKEY_APPID);
    }

    // Remove this for store builds!
    private void checkForUpdates() {
        UpdateManager.register(this, GalleraConstant.HOCKEY_APPID);
    }

    private void addMetrics() {

        MetricsManager.register(this, getApplication());
    }


    /*public void hitChangePasswordApi(String old_pw, String new_pw, ChangePasswordDialog dialog) {

        String oldPass = (Utils.getEncryptedPassword(old_pw).toLowerCase());
        String newPass = (Utils.getEncryptedPassword(new_pw).toLowerCase());

        IRetroServices service = RetroGenerator.getService(GalleraBaseActivity.this);
        Call<BaseResponse<MessageResponse>> call = service.changePasswordApi(oldPass, newPass);
        call.enqueue(new RetroResponseListner<MessageResponse>(GalleraBaseActivity.this) {
            @Override
            protected void onSuccess(MessageResponse response) {
                if (response.getStatus() == 0) {

                    // after getting succes we have to update isPasswordChange field value from "false" to "true"
                    User user = Utils.fetchUserDataFromPref(GalleraBaseActivity.this);
                    user.setPassChanged(true);
                    Utils.saveUserData(GalleraBaseActivity.this, user);
                    dialog.dismiss();

                    DialogManager.showCustomDialog(GalleraBaseActivity.this, response.getMsg());
                } else {

                    dialog.setDefaultVaueInEditText();
                    onError(response.getErrors());

                }
            }
        });

    }*/

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
            overridePendingTransitionExit();

        }

    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.create_enter, R.anim.create_exit);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.finish_enter, R.anim.finish_exit);
    }









}
