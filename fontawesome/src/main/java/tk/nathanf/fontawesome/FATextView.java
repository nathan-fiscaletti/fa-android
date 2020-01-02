package tk.nathanf.fontawesome;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

public class FATextView extends AppCompatTextView {

    private Context context;

    public FATextView(Context context) {
        this(context, R.string.fa_question_circle, FATypeface.FAType.Regular, true);
    }

    public FATextView(Context context, @StringRes int icon, FATypeface.FAType type, boolean autoResize) {
        super(context);
        this.context = context;

        setTypeface(type);
        if (autoResize) {
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, 1, 2000, 1, TypedValue.COMPLEX_UNIT_DIP);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        } else {
            setGravity(Gravity.CENTER);
        }

        setPadding(0, 0, 0, 0);
        setText(icon);
        setIncludeFontPadding(false);
    }

    public FATextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.commonInit(attrs);
    }

    public FATextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.commonInit(attrs);
    }

    public void commonInit(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FATextView);
        int type = typedArray.getInt(R.styleable.FATextView_fa_type, 2);
        boolean resize = typedArray.getBoolean(R.styleable.FATextView_fa_autosize, true);
        String icon = typedArray.getString(R.styleable.FATextView_fa_icon);
        if (icon == null) {
            icon = context.getString(R.string.fa_question_circle);
        }
        typedArray.recycle();
        setTypeface(FATypeface.FAType.getType(type));

        if (resize) {
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, 1, 2000, 1, TypedValue.COMPLEX_UNIT_DIP);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        } else {
            setGravity(Gravity.CENTER);
        }

        setPadding(0, 0, 0, 0);
        setText(icon);
        setIncludeFontPadding(false);
    }

    public void setTypeface(FATypeface.FAType type) {
        setTypeface(FATypeface.getTypeFace(context, type));
    }
}