package team.sungkyul.workin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import team.sungkyul.workin.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private ArrayList<User> mDataset;
    String stMyEmail = "";
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvUser;
        public ImageView ivUser;
        public MyViewHolder(View v) {
            super(v);
            tvUser = v.findViewById(R.id.tvUser);
            ivUser  = v.findViewById(R.id.ivUser);
        }
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    public UserAdapter(ArrayList<User> myDataset, String stEmail) {
        mDataset = myDataset;
        this.stMyEmail = stEmail;
    }
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvUser.setText(mDataset.get(position).getEmail());
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
