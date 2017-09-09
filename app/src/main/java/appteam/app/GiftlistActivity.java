package appteam.app;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GiftlistActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private AddItemView addItemTab;
    private LinearLayout giftlist_frame;

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
        giftlist_frame = (LinearLayout) findViewById(R.id.giftlistFrame) ;

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

        // creating new tab in current screen

        ItemTabView new_item_view = new ItemTabView(this.getApplicationContext());

        new_item_view.title.setText(addItemTab.title.getText());
        new_item_view.price.setText(addItemTab.price.getText());
        new_item_view.description.setText(addItemTab.comm.getText());

        new_item_view.url = (addItemTab.url.getText().toString());
        new_item_view.loc_lat = (addItemTab.latitude.getText().toString());
        new_item_view.loc_long = addItemTab.longitude.getText().toString();

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        new_item_view.setLayoutParams(params);
        giftlist_frame.addView(new_item_view, 0);


        //Local (method 1)

        mDatabase.child("Name").setValue(new_item_view.title.getText().toString().trim());
        mDatabase.child("url").setValue(new_item_view.url);
        mDatabase.child("Price").setValue(new_item_view.price.getText().toString().trim());

        //Own (method 2)

        mDatabase.child("Comments").setValue(new_item_view.description.getText().toString().trim());
        mDatabase.child("Latitude").setValue(new_item_view.loc_lat);
        mDatabase.child("Longitude").setValue(new_item_view.loc_long);


        // no need to pass any view with this method, it should have 0 args
        CloseAddItemTab(new_item_view);

    }

}