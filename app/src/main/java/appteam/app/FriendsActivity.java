package appteam.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;

public class FriendsActivity extends AppCompatActivity {

    public AddFriendView addFriendTab;
    public FriendOptionsView friendOptTab;
    public FriendTabView selected_friend;

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
        friendOptTab = (FriendOptionsView) findViewById(R.id.FriendOptionsTab);

    }

    public void DeleteFriend(View view) {

        // DB delete friend

        ViewGroup vg = (ViewGroup) findViewById(R.id.friendlistFrame);
        vg.removeView(selected_friend);

    }


    public void SearchFriendName(View view){

        // search friends in DB: addFriendTab.friend_name.getText().toString();
        // once results have been retrieved

        for(int i = 0; i < 5; i++){    // provisional

            addFriendTab.AddUserToSearchRes(getString(R.string.example1), getString(R.string.example2));

        }

    }

    public void CloseFriendOptTab(View view){

        friendOptTab.setVisibility(View.GONE);
    }

    public void OpenFriendOptTab(){
        if (friendOptTab.getVisibility() == View.GONE) {
            friendOptTab.setVisibility(View.VISIBLE);
        }
    }

    public void CloseAddFriendTab(View view){

        addFriendTab.setVisibility(View.GONE);
    }

    public void OpenAddFriendTab(View view){
        if (addFriendTab.getVisibility() == View.GONE) {
            addFriendTab.setVisibility(View.VISIBLE);
        }
    }

}
