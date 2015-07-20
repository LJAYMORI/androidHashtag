package com.ljaymori.androidhashtag;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemView> {

    private Context mContext;
    private ArrayList<ItemData> items = new ArrayList<ItemData>();

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void add(ItemData id) {
        items.add(id);
        notifyDataSetChanged();
    }

    @Override
    public ItemView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_text, viewGroup, false);

        return new ItemView(v);
    }

    @Override
    public void onBindViewHolder(ItemView itemView, int i) {
        itemView.setItemView(items.get(i));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
