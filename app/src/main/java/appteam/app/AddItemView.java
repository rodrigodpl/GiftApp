package appteam.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class AddItemView extends RelativeLayout {

    public EditText title;
    public EditText url;
    public EditText comm;
    public EditText price;
    public TextView latitude;
    public TextView longitude;

    public Spinner currency_selector;

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
        url   = findViewById(R.id.url_addTab);
        comm  = findViewById(R.id.comments);
        price = findViewById(R.id.price_additemtab);
        latitude = findViewById(R.id.latitude_addTab);
        longitude = findViewById(R.id.longitude_addTab);

        currency_selector = findViewById(R.id.currency_selector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.Currencies_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency_selector.setAdapter(adapter);
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