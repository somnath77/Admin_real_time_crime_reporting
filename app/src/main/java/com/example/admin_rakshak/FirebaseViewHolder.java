package com.example.admin_rakshak;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public TextView Type,Description,Status;


    public FirebaseViewHolder(@NonNull View itemView) {
        super(itemView);

        Type =itemView.findViewById(R.id.textView_type);
        Description = itemView.findViewById(R.id.textView_description);
        Status = itemView.findViewById(R.id.textView_status);
    }
}
