package com.example.materialdesignpractice.customs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RelativeLayout;

/**
 * Created by Xavier on 2015/4/23.
 */
public class ProgressBarCircular extends RelativeLayout {
	private final static String ANDROIDXML = "http://schemas.android.com/apk/res/android";
	private int backgroundColor = Color.parseColor("#1E88E5");

	private float radius1 = 0;
	private float radius2 = 0;
	private int cont = 0;
	private boolean firstAnimationOver = false;

	private int arcD = 1;
	private int arcO = 0;
	private float rotateAngle = 0;
	private int limit = 0;

	public ProgressBarCircular(Context context, AttributeSet attrs) {
		super(context, attrs);
		setAttributes(attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		if (firstAnimationOver == false) {
//			drawFirstAnimation(canvas);
//		}
//
//		if (cont > 0) {
//			drawSecondAnimation(canvas);
//		}

		drawSecondAnimation(canvas);

		invalidate();
	}

	private void setAttributes(AttributeSet attrs) {
		//		setMinimumHeight(dpToPx(32, getResources()));
		//		setMinimumWidth(dpToPx(32, getResources()));
		//		String realWidthDip = attrs.getAttributeValue(ANDROIDXML, "layout_width");
		//		String realHeightDip = attrs.getAttributeValue(ANDROIDXML, "layout_height");

		int backgroundColor = attrs.getAttributeResourceValue(ANDROIDXML, "background", -1);
		if (backgroundColor != -1) {
			setBackgroundColor(getResources().getColor(backgroundColor));
		} else {
			String background = attrs.getAttributeValue(ANDROIDXML, "background");
			Log.d("", "ProgressBarCircular::setAttributes()::background - " + background);

			if (background != null) {
				setBackgroundColor(Color.parseColor(background));
			} else {
				setBackgroundColor(Color.parseColor("#1E88E5"));
			}
		}

		//		setMinimumHeight(dpToPx(3, getResources()));
	}

	private int dpToPx(float dp, Resources resources) {
		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
		return (int) px;
	}

	private int makePressColor() {
		int r = (this.backgroundColor >> 16) & 0xFF;
		int g = (this.backgroundColor >> 8) & 0xFF;
		int b = (this.backgroundColor >> 0) & 0xFF;
		//		r = (r+90 > 245) ? 245 : r+90;
		//		g = (g+90 > 245) ? 245 : g+90;
		//		b = (b+90 > 245) ? 245 : b+90;
		return Color.argb(128, r, g, b);
	}

	private void drawFirstAnimation(Canvas canvas) {
		if (radius1 < getWidth() / 2) {
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(makePressColor());
			radius1 = (radius1 >= getWidth() / 2) ? (float) getWidth() / 2 : radius1 + 1;
			canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius1, paint);
		} else {
			Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
			Canvas temp = new Canvas(bitmap);

			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(makePressColor());
			temp.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2, paint);

			Paint transparentPaint = new Paint();
			transparentPaint.setAntiAlias(true);
			transparentPaint.setColor(getResources().getColor(android.R.color.transparent));
			transparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

			if (cont >= 50) {
				radius2 = (radius2 >= getWidth() / 2) ? (float) getWidth() / 2 : radius2 + 1;
			} else {
				radius2 = (radius2 >= getWidth() / 2 - dpToPx(4, getResources())) ? (float) getWidth() / 2 - dpToPx(4, getResources()) : radius2 + 1;
			}

			temp.drawCircle(getWidth() / 2, getHeight() / 2, radius2, transparentPaint);
			canvas.drawBitmap(bitmap, 0, 0, new Paint());

			if (radius2 >= getWidth() / 2 - dpToPx(4, getResources())) {
				cont++;
			}

			if (radius2 >= getWidth() / 2) {
				firstAnimationOver = true;
			}
		}

		Log.d("", "ProgressBarCircular::drawFirstAnimation()::radius1 - " + radius1);
		Log.d("", "ProgressBarCircular::drawFirstAnimation()::radius2 - " + radius2);
		Log.d("", "ProgressBarCircular::drawFirstAnimation()::getWidth() / 2 - dpToPx(4, getResources() - " + (getWidth() / 2 - dpToPx(4, getResources())));
		Log.d("", "ProgressBarCircular::drawFirstAnimation()::cont - " + cont);
	}

	private void drawSecondAnimation(Canvas canvas) {
//		if (arcO == limit) {
//			arcD += 6;
//		}
//
//		if (arcD >= 290 || arcO > limit) {
//			arcO += 6;
//			arcD -= 6;
//		}
//
//		if (arcO > limit + 290) {
//			limit = arcO;
//			arcO = limit;
//			arcD = 1;
//		}

//		rotateAngle += 4;
//		canvas.rotate(rotateAngle, getWidth() / 2, getHeight() / 2);

		Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas temp = new Canvas(bitmap);

		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(backgroundColor);
		//		temp.drawARGB(0, 0, 0, 255);
//		temp.drawArc(new RectF(0, 0, getWidth(), getHeight()), arcO, arcD, true, paint);
//		temp.drawArc(new RectF(0, 0, getWidth(), getHeight()), 100, 100, true, paint);

		Paint transparentPaint = new Paint();
		transparentPaint.setAntiAlias(true);
		transparentPaint.setColor(getResources().getColor(android.R.color.transparent));
		transparentPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
		temp.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - dpToPx(4, getResources()), transparentPaint);

		canvas.drawBitmap(bitmap, 0, 0, new Paint());
	}

	public void setBackgroundColor(int color) {
		super.setBackgroundColor(getResources().getColor(android.R.color.transparent));
		this.backgroundColor = color;
	}
}
