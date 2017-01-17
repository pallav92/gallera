package pallav.example.com.galleryapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import pallav.example.com.galleryapp.R;
import pallav.example.com.galleryapp.callbacks.ICustomDialogCallBack;


public class CustomAlertPopup extends Dialog implements View.OnClickListener {

    private TextView txtOk;
    private TextView txtMessage;
    private TextView txtTitle;
    private TextView txtCancel;
    private TextView txt_sep;
    private ICustomDialogCallBack iCustomDialogCallBack;

    public CustomAlertPopup(Context activity, String message) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        txtCancel.setOnClickListener(this);
        this.show();
    }

    private void initView() {

        txtOk = (TextView) findViewById(R.id.txt_ok);
        txtMessage = (TextView) findViewById(R.id.txt_message);
        txtTitle = (TextView) findViewById(R.id.txt_title);
        txtCancel = (TextView) findViewById(R.id.txt_cancel);
        txt_sep = (TextView) findViewById(R.id.txt_sep);
    }

    public CustomAlertPopup(Context activity, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        this.iCustomDialogCallBack = iCustomDialogCallBack;
        txtCancel.setOnClickListener(this);
        this.show();
    }

    public CustomAlertPopup(Activity activity, String message) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        txtCancel.setOnClickListener(this);
        this.show();
    }

    public CustomAlertPopup(Activity activity, String title, String message) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        txtTitle.setText(title);
        txtCancel.setOnClickListener(this);
        this.show();
    }

    public CustomAlertPopup(Activity activity, String title, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        txtTitle.setText(title);
        this.iCustomDialogCallBack = iCustomDialogCallBack;
        txtCancel.setOnClickListener(this);


        this.show();
    }

    public CustomAlertPopup(Activity activity, String message, ICustomDialogCallBack iCustomDialogCallBack) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtMessage.setText(message);
        this.iCustomDialogCallBack = iCustomDialogCallBack;
        txtCancel.setOnClickListener(this);

        this.show();
    }

    public CustomAlertPopup(Activity activity, String message, String btn1, String btn2, ICustomDialogCallBack iCustomDialogCallBack) {
        super(activity);
        this.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        this.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_alert);
        initView();
        txtOk.setOnClickListener(this);
        txtOk.setText(btn2);
        txt_sep.setVisibility(View.VISIBLE);
        txtMessage.setText(message);
        this.iCustomDialogCallBack = iCustomDialogCallBack;
        txtCancel.setOnClickListener(this);
        txtCancel.setText(btn1);
        txtCancel.setVisibility(View.VISIBLE);
        this.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_ok:
                if (iCustomDialogCallBack != null) {
                    iCustomDialogCallBack.onOkClicked(CustomAlertPopup.this);
                }
                dismiss();
                break;
            case R.id.txt_cancel:
                if (iCustomDialogCallBack != null) {
                    iCustomDialogCallBack.onCancelClicked(CustomAlertPopup.this);
                }
                dismiss();
                break;

        }
    }
}
