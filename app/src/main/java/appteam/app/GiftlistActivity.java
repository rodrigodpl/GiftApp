package appteam.app;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GiftlistActivity extends AppCompatActivity {

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

                OpenAddTab(view);

            }
        });

        addItemTab = (AddItemView) findViewById(R.id.AddItemTab);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void CloseAddTab(View view){

        addItemTab.title.setText("");
        addItemTab.url.setText("");
        addItemTab.comm.setText("");

        findViewById(R.id.AddItemTab).setVisibility(View.GONE);
    }

    public void OpenAddTab(View view){
        if (findViewById(R.id.AddItemTab).getVisibility() == View.GONE) {
            findViewById(R.id.AddItemTab).setVisibility(View.VISIBLE);
        }
    }

    public void OpenAddTabLoaded(View view){

        addItemTab.title.setText(R.string.example1);
        addItemTab.url.setText(R.string.example2);
        addItemTab.comm.setText(R.string.example3);

        if (findViewById(R.id.AddItemTab).getVisibility() == View.GONE) {
            findViewById(R.id.AddItemTab).setVisibility(View.VISIBLE);
        }
    }

    public void SaveItem(View view){

        ItemTabView test = (ItemTabView) findViewById(R.id.ExampleGift);

        test.SetDataFromTab(addItemTab);
    }

}
