package pallav.example.com.galleryapp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pallav.example.com.galleryapp.R;
import pallav.example.com.galleryapp.callbacks.IGetStartedCallback;

/**
 * Created by pallav on 18/1/17.
 */

public class SplashPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    IGetStartedCallback iGetStartedCallback;

    int[] resources = {R.drawable.rounded_square_bg_blue, R.drawable.rounded_square_bg_red, R.drawable.rounded_square_bg_green};

    public SplashPagerAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        iGetStartedCallback = (IGetStartedCallback) mContext;
    }

    @Override
    public int getCount() {
        return resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.splash_pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_pager_item);
        imageView.setImageResource(resources[position]);
        TextView tv_splash_text = (TextView) itemView.findViewById(R.id.tv_pager_title);
        tv_splash_text.setText("Gallera" + position);
        Button btn_get_started = (Button) itemView.findViewById(R.id.btn_getStarted);
        Button btn_login = (Button) itemView.findViewById(R.id.btn_login);
        if (position == 2) {
            btn_get_started.setVisibility(View.VISIBLE);
            btn_login.setVisibility(View.VISIBLE);
        } else {
            btn_get_started.setVisibility(View.GONE);
            btn_login.setVisibility(View.GONE);
        }

        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetStartedCallback.onGetStartedClicked();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGetStartedCallback.onLoginClicked();
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
