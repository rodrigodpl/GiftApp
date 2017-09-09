
package appteam.app;

import android.content.Context;
import android.util.AttributeSet;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ItemTabView extends RelativeLayout {

    public TextView description;
    public ImageView thumbnail;
    public Button enter_button;
    public Button edit_button;
    public TextView title;
    public TextView price;
    public String url;
    public String loc_lat;
    public String loc_long;

    public ItemTabView(Context context) {
        super(context);
        init();
    }

    public ItemTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemTabView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_tab_view, this);
        description = findViewById(R.id.description);
        thumbnail = findViewById(R.id.thumbnail);
        enter_button = findViewById(R.id.enter_btn);
        title = findViewById(R.id.title);
        edit_button = findViewById(R.id.edit_btn);
        price = findViewById(R.id.price_text);

    }

    public void SetDataFromTab(AddItemView AddItemTab){

        title.setText(AddItemTab.title.getText());
        description.setText(AddItemTab.comm.getText());
        //     ...
    }


}