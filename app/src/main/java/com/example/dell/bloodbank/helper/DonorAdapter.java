package com.example.dell.bloodbank.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.bloodbank.R;
import com.example.dell.bloodbank.model.Donor;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dell on 9/22/2018.
 */

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.MyViewHolder>  {
    private Context context;
    private List<Donor> donorsList;

    public DonorAdapter(Context context, List<Donor> donorsList) {
        this.context = context;
        this.donorsList = donorsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.donor_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            Donor donor=donorsList.get(position);
            holder.donor_name.setText(donor.getName());
            holder.donor_phone.setText(donor.getPhone());
            holder.donor_address.setText(donor.getAddress());
            holder.donor_group.setText(donor.getGroup());

    }

    @Override
    public int getItemCount() {
        return donorsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView donor_name,donor_phone,donor_address,donor_group;
        public CircleImageView donor_image;

        public MyViewHolder(View itemView) {
            super(itemView);

         donor_image=(CircleImageView) itemView.findViewById(R.id.single_image);
         donor_name=(TextView)itemView.findViewById(R.id.single_name);
         donor_phone=(TextView)itemView.findViewById(R.id.single_phone);
         donor_address=(TextView)itemView.findViewById(R.id.single_address);
         donor_group=(TextView)itemView.findViewById(R.id.single_group);

        }
    }





}
