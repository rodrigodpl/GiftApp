package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AddFriendView extends RelativeLayout {

    public EditText friend_name;
    public Button search_button;
    private LinearLayout search_res;

    public AddFriendView(Context context) {
        super(context);
        init();
    }

    public AddFriendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AddFriendView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.add_friend_view, this);
        friend_name = findViewById(R.id.addfriends_name);
        search_button = findViewById(R.id.addfriends_search);
        search_res = findViewById(R.id.addfriends_search_res);
    }

    public void AddUserToSearchRes(String username, String profilename){

        FriendTabReducedView new_user = new FriendTabReducedView(getContext());

        new_user.username.setText(username);
        new_user.profile_name.setText(profilename);

        // new_user.thumbnail ...

        //search_res.setOnClickListener
        search_res.addView(new_user);

    }

}
