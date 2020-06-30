package team.sungkyul.workin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }
}