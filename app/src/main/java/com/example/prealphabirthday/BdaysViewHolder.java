package com.example.prealphabirthday;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BdaysViewHolder extends RecyclerView.ViewHolder{
    private TextView nameTextView;

    public BdaysViewHolder(final View itemView) { // (?) Why final?
        // Constructor, set up the name TextView
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.name_text);
    }

    public void bindData(final BdaysViewModel viewModel) {
        nameTextView.setText(viewModel.getName());
    }

}
