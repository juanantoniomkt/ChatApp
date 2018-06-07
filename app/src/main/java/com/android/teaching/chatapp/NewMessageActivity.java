package com.android.teaching.chatapp;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.teaching.chatapp.models.MessageModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewMessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        Toolbar toolbar = findViewById(R.id.toolbarNew);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void send(View view)
    {
        EditText usernameEdit = findViewById(R.id.usernameNew);
        EditText textEdit = findViewById(R.id.textNew);

        String username = usernameEdit.getText().toString();
        String text = textEdit.getText().toString();

        if(TextUtils.isEmpty(username) && TextUtils.isEmpty(text))
        {
            Toast.makeText(this,"todos los campos son obligatorios", Toast.LENGTH_LONG).show();

        }

        else if(TextUtils.isEmpty(username))
        {
            Toast.makeText(this,"username es obligatorio", Toast.LENGTH_LONG).show();

        }

        else if(TextUtils.isEmpty(text))
        {
            Toast.makeText(this,"mensaje es obligatorio", Toast.LENGTH_LONG).show();
        }

        else
        {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("messages");
            myRef.push().setValue(new MessageModel(usernameEdit.getText().toString(), textEdit.getText().toString()));


            usernameEdit.setText("");
            textEdit.setText("");
        }

    }
}
