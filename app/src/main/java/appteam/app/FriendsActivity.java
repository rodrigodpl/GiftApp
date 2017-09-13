package appteam.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;

public class FriendsActivity extends AppCompatActivity {

    AddFriendView addFriendTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenAddFriendTab(view);
            }
        });
        fab.bringToFront();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addFriendTab = (AddFriendView) findViewById(R.id.AddFriendTab);

    }

    public void CloseAddFriendTab(View view){

        findViewById(R.id.AddFriendTab).setVisibility(View.GONE);
    }

    public void OpenAddFriendTab(View view){
        if (findViewById(R.id.AddFriendTab).getVisibility() == View.GONE) {
            findViewById(R.id.AddFriendTab).setVisibility(View.VISIBLE);
        }
    }

    public void DeleteFriend(View view) {

        //friend id coming from view context (fragment)
        //DB.deleteFriend(friend_id)
    }

    public void OpenGiftlist(View view) {
        Intent intent = new Intent(this, GiftlistActivity.class);

        //intent.putExtra(bool true so activity loads own or friend data)
        startActivity(intent);
    }

    public void SearchFriendName(View view){

        // search friends in DB: addFriendTab.friend_name.getText().toString();
        // once results have been retrieved

        for(int i = 0; i < 5; i++){    // provisional

            addFriendTab.AddUserToSearchRes(getString(R.string.example1), getString(R.string.example2));

        }

    }

}
