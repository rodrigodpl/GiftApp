package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemOptionsView extends RelativeLayout {
    private TextView header;
    private TextView description;
    private ImageView thumbnail;
    private ImageView icon;

    public ItemOptionsView(Context context) {
        super(context, null, R.attr.TabStyle);
        init();
    }

    public ItemOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.TabStyle);
        init();
    }

    public ItemOptionsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, R.attr.TabStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_tab_view, this);
        header = (TextView)findViewById(R.id.friend_red_tab_profilename);
        description = (TextView)findViewById(R.id.description);
        thumbnail = (ImageView)findViewById(R.id.thumbnail);
    }
}
