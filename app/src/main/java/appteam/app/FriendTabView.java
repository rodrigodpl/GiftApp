package appteam.app;

import android.content.Context;
import android.util.AttributeSet;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FriendTabView extends RelativeLayout {
    private TextView header;
    private TextView description;
    private ImageView thumbnail;
    private ImageView icon;

    public FriendTabView(Context context) {
        super(context, null, R.attr.TabStyle);
        init();
    }

    public FriendTabView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.TabStyle);
        init();
    }

    public FriendTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.friend_tab_view, this);
        header = (TextView)findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);
        thumbnail = (ImageView)findViewById(R.id.thumbnail);
        icon = (ImageView)findViewById(R.id.icon);
    }
}