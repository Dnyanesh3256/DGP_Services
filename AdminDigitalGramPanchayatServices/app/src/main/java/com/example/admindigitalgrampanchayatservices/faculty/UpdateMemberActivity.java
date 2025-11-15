package com.example.admindigitalgrampanchayatservices.faculty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.admindigitalgrampanchayatservices.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class UpdateMemberActivity extends AppCompatActivity {

    private ImageView updateMemberImage;
    private EditText updateMemberName,updateMemberEmail,updateMemberPost;
    private Button updateMemberBtn,deleteMemberBtn;

    private String name,email,image,post;

    private final int REQ = 1;
    private Bitmap bitmap = null;

    private StorageReference storageReference;
    private DatabaseReference reference;
    private String downloadURL,category,uniqueKey;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_member);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        image = getIntent().getStringExtra("image");
        post = getIntent().getStringExtra("post");

        uniqueKey = getIntent().getStringExtra("key");
        category = getIntent().getStringExtra("category");

        updateMemberImage = findViewById(R.id.updateMemberImage);
        updateMemberName = findViewById(R.id.updateMemberName);
        updateMemberEmail = findViewById(R.id.updateMemberEmail);
        updateMemberPost = findViewById(R.id.updateMemberPost);
        updateMemberBtn = findViewById(R.id.updateMemberBtn);
        deleteMemberBtn = findViewById(R.id.deleteMemberBtn);

        reference = FirebaseDatabase.getInstance().getReference().child("member");
        storageReference = FirebaseStorage.getInstance().getReference();

        pd = new ProgressDialog(this);

        try {
            Picasso.get().load(image).into(updateMemberImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateMemberEmail.setText(email);
        updateMemberName.setText(name);
        updateMemberPost.setText(post);

        updateMemberImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        updateMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = updateMemberName.getText().toString();
                email = updateMemberEmail.getText().toString();
                post = updateMemberPost.getText().toString();
                checkValidation();
            }
        });

        deleteMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }

    private void deleteData() {
        pd.setMessage("Deleting...");
        pd.show();
        reference.child(category).child(uniqueKey).removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(UpdateMemberActivity.this, "Member Deleted Successfully !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateMemberActivity.this,UpdateFacultyActivity.class);
                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(UpdateMemberActivity.this, "Something Went Wrong !", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void checkValidation() {
        if (name.isEmpty()){
            updateMemberName.setError("Please Enter Name");
            updateMemberName.requestFocus();
        } else if (email.isEmpty()){
            updateMemberEmail.setError("Please Enter Email");
            updateMemberEmail.requestFocus();
        } else if (post.isEmpty()){
            updateMemberPost.setError("Please Enter Post");
            updateMemberPost.requestFocus();
        } else if (bitmap == null) {
            pd.setMessage("Uploading...");
            pd.show();
            updateData(image);
        } else {
            pd.setMessage("Uploading...");
            pd.show();
            uploadImage();
        }
    }

    private void uploadImage() {
        pd.setMessage("Uploading...");
        pd.show();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
        byte[] finalimg = baos.toByteArray();
        final StorageReference filepath;
        filepath = storageReference.child(finalimg + "jpg");
        final UploadTask uploadTask = filepath.putBytes(finalimg);
        uploadTask.addOnCompleteListener(UpdateMemberActivity.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()) {
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filepath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadURL = String.valueOf(uri);
                                    updateData(downloadURL);
                                }
                            });
                        }
                    });
                } else {
                    pd.dismiss();
                    Toast.makeText(UpdateMemberActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateData(String s) {
        HashMap hp = new HashMap();
        hp.put("name",name);
        hp.put("email",email);
        hp.put("post",post);
        hp.put("image",s);

        reference.child(category).child(uniqueKey).updateChildren(hp).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                pd.setMessage("Updating Information...");
                pd.show();
                Toast.makeText(UpdateMemberActivity.this, "Member Updated Successfully !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateMemberActivity.this,UpdateFacultyActivity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UpdateMemberActivity.this, "Something Went Wrong !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateMemberImage.setImageBitmap(bitmap);
        }
    }
}