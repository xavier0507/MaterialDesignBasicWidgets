package com.example.materialdesignpractice.customs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.materialdesignpractice.R;

/**
 * Created by Xavier on 2015/4/23.
 */
public class CustomTextView extends TextView {
	public CustomTextView(Context context) {
		super(context);
	}

	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.initial(context, attrs);
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.initial(context, attrs);
	}

	private void initial(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.my_text_view);
		Log.d("", "Result: " + typedArray.toString());

		float textsize = typedArray.getFloat(R.styleable.my_text_view_text_size, 14);
		int textColor = typedArray.getColor(R.styleable.my_text_view_text_color, 0xFFFFFF);
		int bgColor = typedArray.getColor(R.styleable.my_text_view_text_back_ground, 0xFFFFFF);

		super.setTextColor(textColor);
		super.setTextSize(textsize);
		super.setBackgroundColor(bgColor);

		typedArray.recycle();
	}
}
