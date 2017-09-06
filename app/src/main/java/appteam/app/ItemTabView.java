
package appteam.app;

import android.content.Context;
import android.util.AttributeSet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ItemTabView extends RelativeLayout {
    private Button cls_button;
    private TextView description;
    private ImageView thumbnail;
    private ImageView icon;
    private TextView title;

    public ItemTabView(Context context) {
        super(context, null, R.attr.TabStyle);
        init();
    }

    public ItemTabView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.TabStyle);
        init();
    }

    public ItemTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_tab_view, this);
        cls_button = findViewById(R.id.closeButton);
        description = findViewById(R.id.description);
        thumbnail = findViewById(R.id.thumbnail);
        icon = findViewById(R.id.icon);
        title = findViewById(R.id.title);

    }

    public void SetDataFromTab(AddItemView AddItemTab){

        title.setText(AddItemTab.comm.getText());
        description.setText(AddItemTab.comm.getText());
        //     ...
    }


}