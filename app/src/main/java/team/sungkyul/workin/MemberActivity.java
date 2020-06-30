package team.sungkyul.workin;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {
    private static final String TAG = "UsersFragment";
    FirebaseDatabase database;
    private RecyclerView recyclerView;
    UserAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<User> userArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_member);
        SharedPreferences sharedPref = getSharedPreferences("shared", Context.MODE_PRIVATE);
        String stEmail = sharedPref.getString("email","");
        userArrayList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new UserAdapter(userArrayList, stEmail);
        recyclerView.setAdapter(mAdapter);
        DatabaseReference ref = database.getReference("users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: "+dataSnapshot.getValue().toString());
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    User user = dataSnapshot1.getValue(User.class);
                    Log.d(TAG, "user: "+user.getEmail());
                    userArrayList.add(user);
                }
                mAdapter.notifyDataSetChanged();
            };
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}

