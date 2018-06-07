package com.android.teaching.chatapp.interactors;

import com.android.teaching.chatapp.callbacks.InteractorCallback;
import com.android.teaching.chatapp.models.MessageModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Interactor {

    ArrayList<MessageModel> messages = new ArrayList<>();

    FirebaseDatabase data;
    DatabaseReference myRef;

    public Interactor()
    {
        data = FirebaseDatabase.getInstance();
        myRef = data.getReference("messages");


    }

    public ArrayList<MessageModel> getMessages() {
        return messages;
    }

    public void getMessages(final InteractorCallback interactorCallback) {


        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for(DataSnapshot nodo : dataSnapshot.getChildren())
                {

                    MessageModel model = nodo.getValue(MessageModel.class);

                    messages.add(model);

                }

                interactorCallback.onMesagesAvaible();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
