package com.example.admin_rakshak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class viewReport extends AppCompatActivity {
    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Test");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) findViewById(R.id.recyclerView_ID);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));

        cardView = (CardView) findViewById(R.id.card_report);

    }


    @Override
    protected void onStart() {
        Toast.makeText(this, "Starting...", Toast.LENGTH_SHORT).show( );
        super.onStart();



        final FirebaseRecyclerAdapter<reportBlog, viewReport.BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<reportBlog, viewReport.BlogViewHolder>
                (reportBlog.class, R.layout.card_report, viewReport.BlogViewHolder.class, mDatabase) {

            @Override
            protected void populateViewHolder(final viewReport.BlogViewHolder blogViewHolder, reportBlog blog, int i) {
                blogViewHolder.setTextView_desc(getApplicationContext(),blog.getDesc());
                blogViewHolder.setTextView_type(getApplicationContext(),blog.getType());
                blogViewHolder.setTextView_status(getApplicationContext(),blog.isStatus());
                blogViewHolder.setTextView_makePublicStatus(getApplicationContext(),blog.isMakePublicStatus());
                blogViewHolder.itemView.findViewById(R.id.textView_description);
                blogViewHolder.itemView.findViewById(R.id.textView_type);
                blogViewHolder.itemView.findViewById(R.id.textView_status);

                final double latitude = blog.getLatitude();
                final double longitude = blog.getLongitude();
                final long contact = blog.getContact();
                final String desc = blog.getDesc();
                final String type = blog.getType();
                final boolean makePublicStatus = blog.isMakePublicStatus();
                final boolean status = blog.isStatus();

                blogViewHolder.mView.setOnClickListener(new View.OnClickListener( ) {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(viewReport.this, "ds", Toast.LENGTH_SHORT).show( );
                        Intent intent = new Intent(viewReport.this,viewInMap.class);
                        intent.putExtra("latitude",latitude );
                        intent.putExtra("longitude",longitude );
                        intent.putExtra("desc",desc );
                        intent.putExtra("type",type );
                        intent.putExtra("contact",contact );
                        intent.putExtra("status",status );
                        intent.putExtra("makePublicStatus",makePublicStatus );

                        startActivity(intent);
                    }
                });

            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter );

    }



    public  static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
//
        public void setTextView_desc(Context applicationContext, String description){
            TextView textView_fname = (TextView)mView.findViewById(R.id.textView_description);
            textView_fname.setText(description);

        }
        public void setTextView_type(Context applicationContext, String type){
            TextView textView_fname = (TextView)mView.findViewById(R.id.textView_type);
            textView_fname.setText(type);
        }
        public void setTextView_status(Context applicationContext, boolean status){
            TextView textView_fname = (TextView)mView.findViewById(R.id.textView_status);
            if(status == true) {
                textView_fname.setText("Accepted");
                textView_fname.setBackgroundColor(Color.parseColor("#008000"));
            }
            else{
                textView_fname.setText("Not Accepted");
                textView_fname.setBackgroundColor(Color.parseColor("#FF0800"));
            }

        }

        public void setTextView_makePublicStatus(Context applicationContext, boolean makePublicStatus) {
            TextView textView_fname = (TextView)mView.findViewById(R.id.textView_publicStatus);
            if(makePublicStatus == true) {
                textView_fname.setText("Public");
                textView_fname.setBackgroundColor(Color.parseColor("#008000"));
            }
            else{
                textView_fname.setText("Not Public");
                textView_fname.setBackgroundColor(Color.parseColor("#FF0800"));
            }

        }
    }
}
