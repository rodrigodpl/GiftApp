package appteam.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GiftlistActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    AddItemView addItemTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giftlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenAddItemTab(view);

            }
        });
        fab.bringToFront();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addItemTab = (AddItemView) findViewById(R.id.AddItemTab);

        //Aim the root of the database with the variable mDatabase.
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }



    public void CloseAddItemTab(View view){

        addItemTab.title.setText("");
        addItemTab.url.setText("");
        addItemTab.comm.setText("");

        findViewById(R.id.AddItemTab).setVisibility(View.GONE);
    }

    public void OpenAddItemTab(View view){
        if (findViewById(R.id.AddItemTab).getVisibility() == View.GONE) {
            findViewById(R.id.AddItemTab).setVisibility(View.VISIBLE);
        }
    }

    public void OpenAddItemTabLoaded(View view){

        addItemTab.title.setText(R.string.example1);
        addItemTab.url.setText(R.string.example2);
        addItemTab.comm.setText(R.string.example3);

        if (findViewById(R.id.AddItemTab).getVisibility() == View.GONE) {
            findViewById(R.id.AddItemTab).setVisibility(View.VISIBLE);
        }
    }

    public void SaveItem(View view){

        ItemTabView test = (ItemTabView) findViewById(R.id.ExampleGift);

        String name_new_item = addItemTab.title.getText().toString().trim();
        String url_new_item = addItemTab.url.getText().toString().trim();
        String comments_new_item = addItemTab.comm.getText().toString().trim();

        mDatabase.child("Name").setValue(name_new_item);
        mDatabase.child("url").setValue(url_new_item);
        mDatabase.child("Comments").setValue(comments_new_item);

        test.SetDataFromTab(addItemTab);
    }

}