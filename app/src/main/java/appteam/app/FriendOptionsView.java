package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FriendOptionsView extends RelativeLayout {

    public FriendOptionsView(Context context) {
        super(context);
        init();
    }

    public FriendOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FriendOptionsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.friend_options_view, this);
        //header = (TextView)findViewById(R.id.friend_red_tab_profilename);
    }
}
