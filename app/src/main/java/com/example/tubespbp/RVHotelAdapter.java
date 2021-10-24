package com.example.tubespbp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tubespbp.databinding.HotelItemBinding;


import java.util.List;

public class RVHotelAdapter extends RecyclerView.Adapter<RVHotelAdapter.UserViewHolder> {
    List<DataHotel> dataHotelList;
    private Context context;


    public RVHotelAdapter(List<DataHotel> dataHotel, Context context){
        this.dataHotelList = dataHotel;
        this.context = context;


    }



    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        HotelItemBinding binding = HotelItemBinding.inflate(layoutInflater, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        DataHotel dataHotel = dataHotelList.get(position);
        holder.binding.setDataHotel(dataHotel);
        holder.binding.executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("CheckOut");
                builder.setMessage("Anda akan dialihkan ke checkout menu, pastikan sudah memilih dengan benar").setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(context, informasihotel.class);
                                intent.putExtra("nama", dataHotelList.get(position).getNamaHotel());
                                intent.putExtra("nokamar", dataHotelList.get(position).getNoKamar());
                                intent.putExtra("total", dataHotelList.get(position).getHarga());
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                        .show();





            }
        });


    }

    @Override
    public int getItemCount() {
        return dataHotelList.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {
        HotelItemBinding binding;

        public UserViewHolder(@NonNull HotelItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }




}
