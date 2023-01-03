package com.example.bdd;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class CustomProgressDialog extends ProgressDialog
{
    public AnimationDrawable animation;

    static CustomProgressDialog dialog;

    public static ProgressDialog pd(Context context)
    {
        dialog = new CustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        //dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        return dialog;
    }

    public CustomProgressDialog(Context context)
    {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme)
    {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progress_bar_layout);

        ImageView la = (ImageView) findViewById(R.id.animation);
        la.setBackgroundResource(R.drawable.cust_progress_dialog_anim);
        animation = (AnimationDrawable) la.getBackground();
    }

    @Override
    public void show()
    {
        super.show();
        animation.start();
    }

    @Override
    public void dismiss()
    {
        super.dismiss();
        if (animation.isRunning())
        {
            animation.stop();
        }

    }
}
