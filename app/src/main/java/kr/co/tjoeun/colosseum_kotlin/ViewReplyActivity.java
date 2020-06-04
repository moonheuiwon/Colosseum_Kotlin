package kr.co.tjoeun.colosseum_kotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import kr.co.tjoeun.colosseum_kotlin.databinding.ActivityViewReply2Binding;

public class ViewReplyActivity extends BaseActivity {

    ActivityViewReply2Binding binding;

    int replyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_reply2);
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        replyId = getIntent().getIntExtra("replyId", -1);

        if (replyId != -1) {
//            서버에서 의견의 상세 정보를 불러오자
            getReplyDataFromServer();
        }

    }

    void getReplyDataFromServer() {

    }

}
