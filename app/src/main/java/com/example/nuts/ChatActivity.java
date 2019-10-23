package com.example.nuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nuts.adapter.ChatAdapter;
import com.example.nuts.adapter.addressAdapter;
import com.example.nuts.utils.navigation.ItemDecorationAlbumColumns2;

public class ChatActivity extends AppCompatActivity {

    private LinearLayoutManager layoutManager;
    private RecyclerView rv;

    private void DeclareElements() {
        //editTextSearch = rootView.findViewById(R.id.editTextSearch);
        rv = findViewById(R.id.listView);
        layoutManager = new LinearLayoutManager(this);
        rv.addItemDecoration(new ItemDecorationAlbumColumns2(rv.getContext(), 1));
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(new ChatAdapter(DummyContent.ITEMS));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        DeclareElements();
    }
}
