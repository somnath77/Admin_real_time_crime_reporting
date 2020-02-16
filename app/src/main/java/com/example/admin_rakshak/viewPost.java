package com.example.admin_rakshak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class viewPost extends AppCompatActivity {

    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Posts");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) findViewById(R.id.recyclerView_id);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<upload_post, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<upload_post, BlogViewHolder>
                (upload_post.class, R.layout.card_viewpost, BlogViewHolder.class, mDatabase) {
            @Override
            protected void populateViewHolder(BlogViewHolder blogViewHolder, upload_post blog, int i) {
                blogViewHolder.setImage(getApplicationContext(), blog.getImageUrl());
                blogViewHolder.setTextView_description(getApplicationContext(),blog.getDescription());
            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter );
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setTextView_description(Context applicationContext, String description)
        {
            TextView textView_fname = (TextView)mView.findViewById(R.id.textView_viewPost);
            textView_fname.setText(description);
        }

        public void setImage(Context ctx, String image) {
            ImageView imageview = (ImageView) mView.findViewById(R.id.imageViewPost);
            Picasso.get().load(image).fit().centerCrop()
                    .into(imageview);
        }

    }
}
