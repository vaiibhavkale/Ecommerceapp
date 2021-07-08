
package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.e_commerce.model.Users;
import com.example.e_commerce.prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button joinNowButton, loginButtonregister;

    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinNowButton = (Button) findViewById(R.id.main_join_now_button);
        loginButtonregister = (Button) findViewById(R.id.main_loginbutton_registerpage);
        loadingbar = new ProgressDialog(this);

        Paper.init(this);

        loginButtonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        String UserPhonekey = Paper.book().read(Prevalent.UserPhonekey);
        String UserPasswordkey = Paper.book().read(Prevalent.UserPasswordkey);

        if (UserPhonekey != "" && UserPasswordkey != ""){
            if (!TextUtils.isEmpty(UserPhonekey) && !TextUtils.isEmpty(UserPasswordkey)){
                AllowAccess( UserPhonekey, UserPasswordkey);

                loadingbar.setTitle("Already Logged in");
                loadingbar.setMessage("Please wait, While we are redirecting to the main app");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
            }
        }

    }
    private void AllowAccess(final String userPhonekey, final String userPasswordkey) {
        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if(snapshot.child("Users").child(userPhonekey).exists()){
                    Users usersData = snapshot.child("Users").child(userPhonekey).getValue(Users.class);
                    if (usersData.getPhone().equals(userPhonekey)){
                        if (usersData.getPassword().equals(userPasswordkey)){
                            Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();

                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            Prevalent.CurrentonlineUser = usersData;
                            startActivity(intent);
                        }
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Account does not exist, Please create one", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

}