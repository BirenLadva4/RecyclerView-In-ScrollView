package com.example.recycleinscrollview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class OneItemTypeAdapter extends RecyclerView.Adapter<OneItemTypeAdapter.ViewHolder> {
    private static final String TAG = "OneItemTypeAdapter";
    private RecyclerItem[] mData;
    private LayoutInflater mInflater;

    public OneItemTypeAdapter(Context context, RecyclerItem[] data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.activity_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder ");
        RecyclerItem recyclerItem = mData[position];
        holder.bindItem(recyclerItem);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView myTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
        }

        void bindItem(RecyclerItem recyclerItem) {
            myTextView.setText(recyclerItem.getTitle());
        }
    }
}