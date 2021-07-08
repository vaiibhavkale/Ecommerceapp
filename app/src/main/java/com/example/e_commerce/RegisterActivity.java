package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText InpuName, Inputphonenumber, Inputpassword;
    private ProgressDialog loadingbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateAccountButton = (Button) findViewById(R.id.main_registerbutton_registerpage);
        InpuName = (EditText) findViewById(R.id.register_username);
        Inputphonenumber = (EditText) findViewById(R.id.register_phone_number);
        Inputpassword = (EditText) findViewById(R.id.register_password_input);
        loadingbar = new ProgressDialog(this);


        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Createaccount();
            }
        });

    }

    private void Createaccount(){
        String name = InpuName.getText().toString();
        String Phone_number = Inputphonenumber.getText().toString();
        String password = Inputpassword.getText().toString();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter name to continue", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Phone_number)){
            Toast.makeText(this, "Please enter phone number to continue", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password to continue", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingbar.setTitle("Create Account");
            loadingbar.setMessage("Please wait, While we are checking the cardentials");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            ValidatePhoneNumber(name, Phone_number, password);
        }
    }

    private void ValidatePhoneNumber(String name, String Phone_number, String password){
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                if(!(snapshot.child("Users").child(Phone_number).exists())){
                    HashMap<String, Object> userdatamap = new HashMap<>();
                    userdatamap.put("phone", Phone_number);
                    userdatamap.put("name", name);
                    userdatamap.put("password", password);

                    Rootref.child("Users").child(Phone_number).updateChildren(userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();

                                        Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(RegisterActivity.this, "Error occur while Creating account. Please try again", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();
                                    }
                                }
                            });
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Phone number Already exists", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(RegisterActivity.this, "Please try using other phone number", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }

}