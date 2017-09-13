package appteam.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void OpenActivity(View view){

        Intent intent;

        switch(view.getId()){

            case R.id.mygiftlist_button:
                intent = new Intent(this, GiftlistActivity.class);
                startActivity(intent);
                break;

            case R.id.myfriends_button:
                intent = new Intent(this, FriendsActivity.class);
                startActivity(intent);
                break;

            case R.id.settings_button:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

}
