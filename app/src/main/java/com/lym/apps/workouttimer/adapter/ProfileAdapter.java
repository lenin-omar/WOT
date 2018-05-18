package com.lym.apps.workouttimer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lym.apps.workouttimer.R;
import com.lym.apps.workouttimer.model.User;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<User> userList;

    public ProfileAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card_layout, parent, false);
        return new ProfileViewHolder(profileView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProfileViewHolder profileViewHolder = (ProfileViewHolder) holder;
        profileViewHolder.profileNameTextView.setText(userList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {

        TextView profileNameTextView;

        ProfileViewHolder(View itemView) {
            super(itemView);
            profileNameTextView = itemView.findViewById(R.id.profile_name_text_view);
        }

    }

}
