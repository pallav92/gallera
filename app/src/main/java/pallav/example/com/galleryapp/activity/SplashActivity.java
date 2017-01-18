package pallav.example.com.galleryapp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import pallav.example.com.galleryapp.R;
import pallav.example.com.galleryapp.adapter.SplashPagerAdapter;
import pallav.example.com.galleryapp.callbacks.IGetStartedCallback;

public class SplashActivity extends BaseActivity implements IGetStartedCallback {

    private static final String TAG = SplashActivity.class.getSimpleName();
    @BindView(R.id.viewPager_splash)
    ViewPager viewPager_splash;

    @BindView(R.id.tabDots)
    TabLayout tabdots;


    SplashPagerAdapter splashPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        tabdots.setupWithViewPager(viewPager_splash, true);

        splashPagerAdapter = new SplashPagerAdapter(this);
        viewPager_splash.setAdapter(splashPagerAdapter);

    }

    @Override
    public void onGetStartedClicked() {
        this.launchActivity(SignUpActivity.class,true);

    }

    @Override
    public void onLoginClicked() {
        this.launchActivity(LoginActivity.class,true);
    }
}
