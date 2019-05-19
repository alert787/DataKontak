//15-05-2019
//Muhammad Ilyas
//10116339
//IF -8

package com.example.datakontak.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datakontak.model.ContactModel;
import com.example.datakontak.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {

    Context mContext;
    ArrayList<ContactModel> mData;
    Dialog mydialog;


    public RecyclerViewAdapter(Context mContext, ArrayList<ContactModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    public void setData(ArrayList<ContactModel> listkontak) {
        this.mData = listkontak;
        notifyDataSetChanged();
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

        final ContactModel infodata = mData.get(viewType);
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.listview_row,parent,false);
        final myViewHolder vHolder = new myViewHolder(v);

        mydialog = new Dialog(mContext);
        mydialog.setContentView(R.layout.dialog_contact);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        vHolder.itemkontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name = (TextView) mydialog.findViewById(R.id.nama);
                TextView dialog_nim = (TextView) mydialog.findViewById(R.id.nim);
                TextView dialog_kelas = (TextView) mydialog.findViewById(R.id.kelas);
                TextView dialog_telepon = (TextView) mydialog.findViewById(R.id.telepon);
                TextView dialog_email = (TextView) mydialog.findViewById(R.id.email);
                TextView dialog_fb = (TextView) mydialog.findViewById(R.id.fb);
                ImageView dialog_img = (ImageView) mydialog.findViewById(R.id.gambar);

                dialog_name.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_nim.setText(mData.get(vHolder.getAdapterPosition()).getNIM());
                dialog_kelas.setText("Kelas         : "+mData.get(vHolder.getAdapterPosition()).getKelas());
                dialog_telepon.setText("Telepon     : "+mData.get(vHolder.getAdapterPosition()).getTelepon());
                dialog_email.setText("Email         : "+mData.get(vHolder.getAdapterPosition()).getEmail());
                dialog_fb.setText("FB               : "+mData.get(vHolder.getAdapterPosition()).getFB());
                dialog_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getGambar());

                mydialog.show();
            }
        });

        vHolder.itemkontak.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                deleteItem(vHolder.getAdapterPosition());

                return true;
            }


        });

        return vHolder;
    }

    void deleteItem(int vHolder) {
        mData.remove(vHolder);
        notifyItemRemoved(vHolder);
    }

    @Override
    public void onBindViewHolder(myViewHolder myViewHolder, int position) {

        myViewHolder.tv_name.setText(mData.get(position).getName());
        myViewHolder.tv_nim.setText(mData.get(position).getNIM());
        myViewHolder.img.setImageResource(mData.get(position).getGambar());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class myViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout itemkontak;
        private TextView tv_name;
        private TextView tv_nim;
        private ImageView img;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            itemkontak = (LinearLayout) itemView.findViewById(R.id.linearlistkontak);
            tv_name = (TextView) itemView.findViewById(R.id.nametextView);
            tv_nim = (TextView) itemView.findViewById(R.id.infotextView2);
            img = (ImageView) itemView.findViewById(R.id.imageView1);
        }
    }
}
