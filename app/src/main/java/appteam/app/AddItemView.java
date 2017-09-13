package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AddItemView extends RelativeLayout {

    EditText title;
    EditText url;
    EditText comm;
    EditText price;
    TextView latitude;
    TextView longitude;

    public AddItemView(Context context) {
        super(context, null, R.attr.TabStyle);
        init();
    }

    public AddItemView(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.TabStyle);
        init();
    }

    public AddItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.add_item_view, this);

        title = findViewById(R.id.addfriends_name);
        url   = findViewById(R.id.url);
        comm  = findViewById(R.id.comments);
        price = findViewById(R.id.price_additemtab);
        latitude = findViewById(R.id.latitude_addTab);
        longitude = findViewById(R.id.longitude);

    }

    public void SetDataFromItemTab(ItemTabView item_tab){

        title.setText(item_tab.title.getText());
        comm.setText(item_tab.description.getText());
        price.setText(item_tab.price.getText());

        url.setText(item_tab.url.getText());
        latitude.setText(item_tab.loc_lat.getText());
        longitude.setText(item_tab.loc_long.getText());

    }



}