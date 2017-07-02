package com.example.farzi.testsimplerecycleview.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farzi.testsimplerecycleview.R;
import com.example.farzi.testsimplerecycleview.model.FlowerResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farzi on 28/06/2017.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<FlowerResponse> mFlowerList;

    public FlowerAdapter(LayoutInflater mInflater) {
        this.mInflater = mInflater;
        mFlowerList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_flower,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        FlowerResponse cuurFlower = mFlowerList.get(position);

        holder.mName.setText(mFlowerList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mPhoto;
        private TextView mName, mPrice;
        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView) itemView.findViewById(R.id.flowerName);
            mPrice = (TextView) itemView.findViewById(R.id.flowerPrice);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

        }
    }
    public void addFlower( List<FlowerResponse> flowerResponses) {
        mFlowerList.addAll(flowerResponses);
        notifyDataSetChanged();
    }
}
