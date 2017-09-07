package appteam.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.widget.Button;
import android.widget.TextView;

public class MyProfileActivity extends AppCompatActivity {

    TextView profile_name;
    boolean isEditable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        profile_name = (TextView) findViewById(R.id.prflname_editable);
        isEditable = false;
    }

    public void SetProfilenameEditable(View view){


        if(!isEditable) {
            profile_name.setFocusable(true);
            profile_name.setFocusableInTouchMode(true);
            profile_name.setHint(profile_name.getText());
            profile_name.setText("");
            isEditable = true;
        }
        else{
            profile_name.setFocusable(false);
            isEditable = false;
        }

    }

}
