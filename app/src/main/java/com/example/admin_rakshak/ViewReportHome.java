//package com.example.admin_rakshak;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.ArrayList;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class ViewReportHome extends AppCompatActivity {
//
//    private RecyclerView recyclerView;
//    private ArrayList<reportBlog> arrayList;
//    private FirebaseRecyclerOptions<reportBlog> options;
//    private FirebaseRecyclerAdapter<reportBlog,FirebaseViewHolder> adapter;
//    private DatabaseReference databaseReference;
//
//
//    @Overr
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        recyclerView.findViewById(R.id.recyclerView_ID);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        arrayList = new ArrayList<reportBlog>();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Test");
//        databaseReference.keepSynced(true);
//        options = new FirebaseRecyclerOptions.Builder<reportBlog>().setQuery(databaseReference,reportBlog.class).build();
//
//        adapter = new FirebaseRecyclerAdapter<reportBlog, FirebaseViewHolder>( options) {
//            @Override
//            protected void onBindViewHolder(@NonNull FirebaseViewHolder firebaseViewHolder, int i, @NonNull reportBlog reportBlog) {
//
//                firebaseViewHolder.Type.setText(reportBlog.getType());
//                firebaseViewHolder.Description.setText(reportBlog.getDesc());
//                if(reportBlog.isStatus()==true){
//                    firebaseViewHolder.Status.setText("Accepted");
//                }
//                else{
//                    firebaseViewHolder.Status.setText("Not Accepted");
//                }
//                firebaseViewHolder.itemView.setOnClickListener(new View.OnClickListener( ) {
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(ViewReportHome.this, "SDFGHjk", Toast.LENGTH_SHORT).show( );
//                        Intent intent = new Intent(ViewReportHome.this, viewInMap.class);
//                        in
//
//                    }
//                });
//
//            }
//
//            @NonNull
//            @Override
//            public FirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return new FirebaseViewHolder(LayoutInflater.from(ViewReportHome.this).inflate(R.layout.card_report,parent,false));
//            }
//        };
//
//
//        recyclerView.setAdapter(adapter);
//    }
//}
