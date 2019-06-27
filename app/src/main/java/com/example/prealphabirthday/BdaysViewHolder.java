package com.example.prealphabirthday;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class BdaysViewHolder extends RecyclerView.ViewHolder{
    private TextView nameTextView;
    private EditText bdayDateView;

    public BdaysViewHolder(final View itemView) { // (?) Why final?
        // Constructor, set up the name TextView
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.name_text);
        bdayDateView = (EditText) itemView.findViewById(R.id.bday_date); // This is an EditText date view thingy
    }

    public void bindData(final BdaysViewModel viewModel) {
        nameTextView.setText(viewModel.getName());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        String date_str = dateFormatter.format(viewModel.getDate());
        bdayDateView.setText(date_str);
    }

}
