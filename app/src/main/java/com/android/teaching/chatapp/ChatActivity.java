package com.android.teaching.chatapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.teaching.chatapp.callbacks.InteractorCallback;
import com.android.teaching.chatapp.interactors.Interactor;
import com.android.teaching.chatapp.models.MessageModel;

public class ChatActivity extends AppCompatActivity {

    ListView listView;

    MyAdapter adapter;

    Interactor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        listView = findViewById(R.id.listView);

        interactor = new Interactor();
        interactor.getMessages(new InteractorCallback() {
            @Override
            public void onMesagesAvaible() {

                adapter = new MyAdapter();
                listView.setAdapter(adapter);

            }
        });


    }

    public void add(View view)
    {
        Intent i = new Intent(this, NewMessageActivity.class);

        startActivity(i);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return interactor.getMessages().size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View myRow = inflater.inflate(R.layout.item_list, parent, false);

            MessageModel message = interactor.getMessages().get(position);

            TextView username = myRow.findViewById(R.id.username);
            username.setText(message.getUsername());

            TextView text = myRow.findViewById(R.id.text);
            text.setText(message.getText());

            return myRow;
        }
    }
}
