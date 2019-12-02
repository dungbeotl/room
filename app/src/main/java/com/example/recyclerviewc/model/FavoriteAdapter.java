package com.example.recyclerviewc.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewc.R;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FContactViewHolder> {
    private List<Contact> mData; //cache copy of contact
    private Context mContext;

    public FavoriteAdapter(Context mContext){
        this.mContext = mContext;
    }
    public static class FContactViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout itemViewContact;
        // private CardView cardView;
        private TextView tv_nameContact, tv_phoneContact;
        private ImageView iv_contact;
        private FContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nameContact = itemView.findViewById(R.id.tv_nameContact);
            tv_phoneContact = itemView.findViewById(R.id.tv_phoneContact);
            iv_contact = itemView.findViewById(R.id.iv_contact);
            itemViewContact = itemView.findViewById(R.id.itemContact_id);
        }
    }

    @NonNull
    @Override
    public FContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact,parent,false);
        FContactViewHolder fContactViewHolder = new FContactViewHolder(view);


        return fContactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FContactViewHolder holder, int position) {
        holder.iv_contact.setImageResource(R.drawable.usertwo);
        holder.tv_nameContact.setText(mData.get(position).getName());
        holder.tv_phoneContact.setText(mData.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else return 0;
    }
    public void setFContact(List<Contact> contact) {
        mData = contact;
        notifyDataSetChanged();
    }
}
