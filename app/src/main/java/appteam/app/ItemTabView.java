
package appteam.app;

import android.content.Context;
import android.util.AttributeSet;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;



public class ItemTabView extends RelativeLayout {

    public TextView description;
    public ImageView thumbnail;
    public Button enter_button;
    public Button edit_button;
    public TextView title;
    public TextView price;
    public TextView currency_tag;
    public TextView url;
    public TextView loc_lat;
    public TextView loc_long;

    public static final int EURO = 1;
    public static final int US_DOLLAR = 2;
    public static final int YEN_YUANG = 3;
    public static final int GB_POUND = 4;

    private boolean expanded = false;

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
        View Tab = inflate(getContext(), R.layout.item_tab_view, this);
        description = findViewById(R.id.description);
        thumbnail = findViewById(R.id.thumbnail);
        enter_button = findViewById(R.id.enter_btn);
        title = findViewById(R.id.friend_red_tab_profilename);
        price = findViewById(R.id.price_text);
        currency_tag = findViewById(R.id.currency_tag);
        url = findViewById(R.id.url);
        loc_lat = findViewById(R.id.latitude_itemTab);
        loc_long = findViewById(R.id.longitude_itemTAb);

        edit_button = findViewById(R.id.friend_tab_opt);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {StartEditMode();}
        });

        Tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {ExpandTab();}
        });


    }

    public void StartEditMode(){

        GiftlistActivity ga = (GiftlistActivity) getContext();
        ga.selected_item = this;
        ga.editing = true;
        ga.addItemTab.SetDataFromItemTab(this);
        ga.OpenAddItemTab(this);

    }

    public void SetDataFromTab(AddItemView AddItemTab) {

        title.setText(AddItemTab.title.getText());

        // if(...)
        loc_lat.setText(AddItemTab.latitude.getText());
        loc_long.setText(AddItemTab.longitude.getText());

        if(AddItemTab.comm.length() > 0)
            description.setText(AddItemTab.comm.getText());

        if(AddItemTab.url.length() > 0)
            url.setText(AddItemTab.url.getText());

        if (AddItemTab.price.length() > 0) {

            currency_tag.setText(AddItemTab.currency_selector.getSelectedItem().toString());
            price.setText(AddItemTab.price.getText());
        }
        //     ...
    }

    public void SetDataFromDB(DatabaseReference mDataBase){


        //title.setText(mDataBase.title.getText());
        //description.setText(mDataBase.comm.getText());
        //price.setText(mDataBase.price.getText());
        //     ...
    }

    public void ExpandTab(){

        View additional_info = findViewById(R.id.more_info_frame);

        if(additional_info.getVisibility() == View.VISIBLE) {
            additional_info.setVisibility(View.GONE);
        }
        else{
            additional_info.setVisibility(View.VISIBLE);
        }

    }


}