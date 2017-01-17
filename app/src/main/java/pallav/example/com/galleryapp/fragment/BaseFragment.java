package pallav.example.com.galleryapp.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

import pallav.example.com.galleryapp.activity.GalleraBaseActivity;

/**
 * Created by pallav on 17/1/17.
 */

public class BaseFragment extends HeadLessFragment {

    private String TAG = BaseFragment.class.getSimpleName();
    GalleraBaseActivity mActivity;
    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachContext(context);
        Log.i(TAG, "onAttach : "+this);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        onAttachContext(activity);
        // ((PlecoBaseActivity)activity).currentFragment
    }

    private void onAttachContext(Context context) {
        if (context instanceof Activity)
            mActivity = (GalleraBaseActivity) context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void startActivityForResult(Class<? extends Activity> classObject, Bundle bundle, int requestCode) {
        Intent intent = new Intent(mActivity, classObject);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    // what is its use??
    @Override
    public void onDetach() {
        super.onDetach();

        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
