package team.sungkyul.workin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton ibMember = (ImageButton) findViewById(R.id.ib_Member);
        ibMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomeActivity.this, MemberActivity.class);
                startActivity(intent1);
            }
        });
        ImageButton ibChat = (ImageButton) findViewById(R.id.ib_Chat);
        ibChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(HomeActivity.this, ChatActivity.class);
                startActivity(intent2);
            }
        });
        ImageButton ib_Call = (ImageButton)findViewById(R.id.ib_Call);
        ib_Call.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Context c = view.getContext();
                Intent intentc = new Intent(Intent.ACTION_DIAL);
                intentc.setData(Uri.parse("tel:"));

                try {
                    c.startActivity(intentc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ImageButton ibMemo = (ImageButton) findViewById(R.id.ib_Memo);
        ibMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(HomeActivity.this, CalendarActivity.class);
                startActivity(intent4);
            }
        });
        ImageButton ibFile = (ImageButton) findViewById(R.id.ib_File);
        ibFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(HomeActivity.this, FileActivity.class);
                startActivity(intent5);
            }
        });
    }

}


