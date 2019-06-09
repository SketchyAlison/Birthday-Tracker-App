package com.example.prealphabirthday;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater; // Convert XML to ViewGroups/Widgets, i.e. builds View objs
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BdaysAdapter extends RecyclerView.Adapter{

    // Connects data to RecyclerView and manages ViewHolder(s)
    // Tutorial: https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern

    private List<BdaysViewModel> models = new ArrayList<>();

    public BdaysAdapter(List<BdaysViewModel> viewModels) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Init ViewHolders
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new BdaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        // Bind ViewHolder to adapter, pass in data to ViewHolder
        ((BdaysViewHolder) viewHolder).bindData(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.bday_itemview;
    }
}
