package kr.teamcadi.hwh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by WIN8 on 2016-12-25.
 */

public class ProfileActivity extends AppCompatActivity
{
    Button button1;
    Button button2;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/010-9253-3847"));
                startActivity(intent); /*버튼1을 누를시 전화*/
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent goChat = new Intent(ProfileActivity.this, chatting.class);
                startActivity(goChat);
                finish(); /*버튼 2를 누를시 chatiing 클래스로*/
            }
        });

    }
}
