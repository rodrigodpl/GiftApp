package appteam.app;

import android.content.Context;
import android.util.AttributeSet;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class FriendTabView extends RelativeLayout {

    private ImageButton options_but;

    public FriendTabView(Context context) {
        super(context);
        init();
    }

    public FriendTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.friend_tab_view, this);
        options_but = findViewById(R.id.friend_tab_opt);

        options_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               OpenFriendOptions();
            }
        });
    }

    public void OpenFriendOptions(){

        FriendsActivity fa = (FriendsActivity) getContext();
        fa.selected_friend = this;

        // enter in fa.friendOptTab and setup it with DB data

        fa.OpenFriendOptTab();

    }
}