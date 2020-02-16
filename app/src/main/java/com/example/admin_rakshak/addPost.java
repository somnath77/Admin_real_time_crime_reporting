package com.example.admin_rakshak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class addPost extends AppCompatActivity {

    private static  final int PICK_IMAGE_REQUEST=1;
    private Button button_choose;
    private ImageView imageView;
    private TextView textView;
    private EditText editText;
    private Button button_upload;

    private Uri mImageUri;
    View v;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;

    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        button_choose = (Button) findViewById(R.id.button_chooseImage);
        button_upload = (Button)findViewById(R.id.button_uploadAll);
        imageView = (ImageView) findViewById(R.id.image_addPost);
        editText = (EditText) findViewById(R.id.editText_description);
        textView = (TextView) findViewById(R.id.textview_description);

        storageReference = FirebaseStorage.getInstance().getReference("posts");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Posts");


        button_choose.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        button_upload.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                if(mUploadTask != null && mUploadTask.isInProgress()){
                    Toast.makeText(addPost.this, "Upload in progress", Toast.LENGTH_SHORT).show( );
                }
                else{
                    uploadFile();
                    editText.getText().clear();
                    imageView.setImageBitmap(null);
                }

            }
        });
        editText.setText(".");
    }

    private void openFileChooser() {

        Intent intent =new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data != null && data.getData() != null ){
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).placeholder(R.drawable.ic_launcher_foreground).into(imageView);
        }
    }
    private String getFileExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));

    }

    private void uploadFile(){
        if(mImageUri != null){
            StorageReference fileReference = storageReference.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            mUploadTask  = fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>( ) {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable( ) {

                                @Override
                                public void run() {
                                }
                            },2000);
                            Toast.makeText(addPost.this, "Upload Successful", Toast.LENGTH_SHORT).show( );
                            upload_post upost = new upload_post( taskSnapshot.getMetadata().getReference().getDownloadUrl().toString() , editText.getText().toString().trim());
                            String uploadID  = databaseReference.push().getKey();
                            databaseReference.child(uploadID).setValue(upost);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener( ) {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(addPost.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else{
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show( );
        }
    }

}
