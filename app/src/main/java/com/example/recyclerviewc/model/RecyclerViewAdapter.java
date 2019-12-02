package com.example.recyclerviewc.model;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewc.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {

    private Context mContext;
    private List<Contact> mData; //cache copy of contact
    private Dialog dialogDetail;
    private TextView tv_nameDia, tv_phoneDia;
    private ImageView iv_imgDia;

    public RecyclerViewAdapter(Context mContext,List<Contact> list) {
        this.mContext = mContext;
      this.mData = list;
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout itemViewContact;
        // private CardView cardView;
        private TextView tv_nameContact, tv_phoneContact;
        private ImageView iv_contact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nameContact = itemView.findViewById(R.id.tv_nameContact);
            tv_phoneContact = itemView.findViewById(R.id.tv_phoneContact);
            iv_contact = itemView.findViewById(R.id.iv_contact);
            //cardView = itemView.findViewById(R.id.cardView_id);
            itemViewContact = itemView.findViewById(R.id.itemContact_id);

        }
    }
//    void setContacts(List<Contact> contacts){
//        mData = contacts;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        dialogDetail = new Dialog(mContext);
        dialogDetail.setContentView(R.layout.dialog_contact);
        dialogDetail.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        tv_nameDia = dialogDetail.findViewById(R.id.tv_nameDia);
        tv_phoneDia = dialogDetail.findViewById(R.id.tv_phoneDia);
        iv_imgDia = dialogDetail.findViewById(R.id.iv_imgDia);


        View view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false);
        final ContactViewHolder viewHolder = new ContactViewHolder(view);


        //item click show dialog detail contact
        viewHolder.itemViewContact.setOnClickListener(view1 -> {
            Toast.makeText(mContext, "Click: " + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_LONG).show();

            //set data to dialog
            tv_nameDia.setText(mData.get(viewHolder.getAdapterPosition()).getName());
            tv_phoneDia.setText(mData.get(viewHolder.getAdapterPosition()).getPhone());
            iv_imgDia.setImageResource(mData.get(viewHolder.getAdapterPosition()).getImage());
            //show dialog
            dialogDetail.show();
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.tv_nameContact.setText(mData.get(position).getName());
        holder.tv_phoneContact.setText(mData.get(position).getPhone());
        holder.iv_contact.setImageResource(mData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        else return 0;
    }


}
