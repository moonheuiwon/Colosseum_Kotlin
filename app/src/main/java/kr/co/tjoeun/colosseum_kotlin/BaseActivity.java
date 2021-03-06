package kr.co.tjoeun.colosseum_kotlin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvents();
    public abstract void setValues();

    public TextView activityTitleTxt;
    public ImageView notificationImg;
    public ImageView logoImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setCustomActionBar();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);

        activityTitleTxt.setVisibility(View.VISIBLE);
        logoImg.setVisibility(View.GONE);
        activityTitleTxt.setText(title);


    }

    public void setCustomActionBar() {

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.custom_action_bar);

            getSupportActionBar().setBackgroundDrawable(null);

            Toolbar toolbar = (Toolbar) getSupportActionBar().getCustomView().getParent();
            toolbar.setContentInsetsAbsolute(0,0);


            View customActionBar = getSupportActionBar().getCustomView();
            activityTitleTxt = getSupportActionBar().getCustomView().findViewById(R.id.activityTitleTxt);
            notificationImg = customActionBar.findViewById(R.id.notificationImg);
            logoImg = customActionBar.findViewById(R.id.logoImg);

            notificationImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(mContext, NotificationListActivity.class);
                    startActivity(myIntent);
                }
            });
            setTitle("Colosseum");
        }
    }

}
