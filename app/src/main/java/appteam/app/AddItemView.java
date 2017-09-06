package appteam.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * TODO: document your custom view class.
 */
public class AddItemView extends RelativeLayout {

    EditText title;
    EditText url;
    EditText comm;

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

        title = findViewById(R.id.item_title);
        url   = findViewById(R.id.url);
        comm  = findViewById(R.id.comments);
    }

}