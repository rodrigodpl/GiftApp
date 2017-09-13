package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FriendTabReducedView extends RelativeLayout {

    public TextView username;
    public TextView profile_name;

    public FriendTabReducedView(Context context) {
        super(context);
        init();
    }

    public FriendTabReducedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendTabReducedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.friend_tab_reduced_view, this);
        username = findViewById(R.id.friend_red_tab_username);
        profile_name = findViewById(R.id.friend_red_tab_profilename);
    }
}
