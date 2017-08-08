package song.tiaofeiji.view;

import song.tiaofeiji.util.Common;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

	public int w = 320;
	public int h = 480;
	public int itemW = 80;
	public int itemH = 40;
	public int left = 0;
	public int top = 0;
	public int right = 0;
	public int bottom = 0;
	public int planePaddingL = 30;
	public int planePaddingT = 30;
	public int planePaddingR = 30;
	public int planePaddingpB = 30;
	public int ovalPadding = 10;
	public int planeHeight = 10;
	public int ovalRadius = 10;
	public int rockerRadius = 35;
	public int textSize = 20;

	public Paint paint = new Paint();
	public RectF oval;
	public Thread thread;
	public MyPoint rocker1;
	public MyPoint rocker2;
	public MyPoint rocker3;
	public int step = 0;
	public int pass = 0;

	class MyPoint {
		public float x;
		public float y;

		public MyPoint(float x, float y) {
			this.x = x;
			this.y = y;
		}

		public boolean isIn(float tx, float ty) {
			if (Math.abs(x - tx) < rockerRadius
					&& Math.abs(y - ty) < rockerRadius) {
				return true;
			}
			return false;
		}
	}

	public GameView(Context context) {
		super(context);
		w = Common.GetW(context);
		h = Common.GetH(context);

		ovalRadius = itemW - ovalPadding;
		planeHeight = itemH * 8 + ovalRadius;

		planePaddingpB = (h - planeHeight) / 2;
		planePaddingT = planePaddingpB;

		paint.setAntiAlias(true);
		paint.setTextSize(textSize);
		oval = new RectF();

		float a = (float) Math.sqrt(Math.pow(rockerRadius * 1.5f * 2, 2)
				+ Math.pow(rockerRadius * 1.5f * 2, 2));
		float b = a * (float) Math.sin(15 * Math.PI / 180);
		float c = a * (float) Math.sin(75 * Math.PI / 180);
		rocker1 = new MyPoint((float) (w * 3 / 4 + rockerRadius * 1.5f),
				(float) (h / 2 - rockerRadius * 1.5f));
		rocker2 = new MyPoint((float) (w * 3 / 4 - rockerRadius * 1.5f),
				(float) (h / 2 + rockerRadius * 1.5f));
		rocker3 = new MyPoint((float) (w * 3 / 4 - rockerRadius * 1.5f + c),
				(float) (h / 2 + rockerRadius * 1.5f + b));

		thread = new Thread() {
			public void run() {
				while (true) {
					try {
						this.sleep(50);
						Log.v("event", "sleep");
						postInvalidate();
					} catch (Exception e) {

					}
				}
			}
		};
		thread.start();
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		drawPlane(canvas);
		drawRocker(canvas);
		drawState(canvas);
	}

	public void drawPlane(Canvas canvas) {
		step1(canvas);
		step2(canvas);
		step3(canvas);
		step4(canvas);
		step5(canvas);
		step6(canvas);
		step7(canvas);
		step8(canvas);
		step9(canvas);
	}

	public void step1(Canvas canvas) {
		if (step == 1) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL + itemW / 2;
			top = h - planePaddingpB - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
			
		} else {
			paint.setStyle(Paint.Style.STROKE);
			
			left = planePaddingL + itemW / 2;
			top = h - planePaddingpB - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step2(Canvas canvas) {
		if (step == 2) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);
			
			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step3(Canvas canvas) {
		if (step == 3) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);
			
			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step4(Canvas canvas) {
		if (step == 4) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setStyle(Paint.Style.FILL );

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);

			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step5(Canvas canvas) {
		if (step == 5) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);

			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step6(Canvas canvas) {
		if (step == 6) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setStyle(Paint.Style.FILL );

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
			
		} else {
			paint.setStyle(Paint.Style.STROKE);

			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step7(Canvas canvas) {
		if (step == 7) {
			paint.setStyle(Paint.Style.FILL );

			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);

			left = planePaddingL + itemW / 2;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step8(Canvas canvas) {
		if (step == 8) {
			paint.setStyle(Paint.Style.FILL );
			
			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			RadialGradient shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
			
			paint.setStyle(Paint.Style.FILL );

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			shader = new RadialGradient(left+(right-left)/2,top+(bottom-top)/2, itemW, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawRect(left, top, right, bottom, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawRect(left, top, right, bottom, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);

			left = planePaddingL;
			top = top - itemH;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);

			left = planePaddingL + itemW;
			top = top;
			right = left + itemW;
			bottom = top + itemH;
			paint.setColor(Color.RED);
			canvas.drawRect(left, top, right, bottom, paint);
		}
	}

	public void step9(Canvas canvas) {
		paint.setColor(Color.RED);
		if (step == 9) {
			paint.setStyle(Paint.Style.FILL );
			
			oval.left = planePaddingL + ovalPadding;
			oval.top = top - ovalRadius;
			oval.right = oval.left + ovalRadius + ovalRadius;
			oval.bottom = top + ovalRadius;
			
			RadialGradient shader = new RadialGradient(oval.left+(oval.right-oval.left)/2,oval.top+(oval.bottom-oval.top)/2, ovalRadius, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawArc(oval, 180, 180, false, paint);

			paint.setShader(null);
			paint.setStyle(Paint.Style.STROKE);
			canvas.drawArc(oval, 180, 180, false, paint);
		} else {
			paint.setStyle(Paint.Style.STROKE);

			oval.left = planePaddingL + ovalPadding;
			oval.top = top - ovalRadius;
			oval.right = oval.left + ovalRadius + ovalRadius;
			oval.bottom = top + ovalRadius;
			canvas.drawArc(oval, 180, 180, false, paint);
		}
	}

	public void drawRocker(Canvas canvas) {
		paint.setColor(Color.RED);
		if(step==0){
			paint.setStyle(Paint.Style.FILL);
			canvas.drawCircle(rocker1.x, rocker1.y, rockerRadius, paint);
			canvas.drawCircle(rocker2.x, rocker2.y, rockerRadius, paint);
			canvas.drawCircle(rocker3.x, rocker3.y, rockerRadius, paint);
		}else if(step==1 || step==2 || step==3 || step==5 || step==7 || step==9){
			paint.setStyle(Paint.Style.FILL);
			RadialGradient shader = new RadialGradient(rocker3.x, rocker3.y, rockerRadius, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawCircle(rocker3.x, rocker3.y, rockerRadius, paint);
			
			paint.setShader(null);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawCircle(rocker2.x, rocker2.y, rockerRadius, paint);
			canvas.drawCircle(rocker1.x, rocker1.y, rockerRadius, paint);
		}else{
			paint.setStyle(Paint.Style.FILL);
			canvas.drawCircle(rocker3.x, rocker3.y, rockerRadius, paint);
			
			paint.setStyle(Paint.Style.FILL);
			RadialGradient shader = new RadialGradient(rocker2.x, rocker2.y, rockerRadius, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawCircle(rocker2.x, rocker2.y, rockerRadius, paint);
			paint.setShader(null);
			
			paint.setStyle(Paint.Style.FILL);
			shader = new RadialGradient(rocker1.x, rocker1.y, rockerRadius, Color.WHITE, Color.RED,Shader.TileMode.MIRROR);
			paint.setShader(shader);
			canvas.drawCircle(rocker1.x, rocker1.y, rockerRadius, paint);
			paint.setShader(null);
		}
	}

	public void drawState(Canvas canvas) {

		String s = "STEP";
		float stringW = paint.measureText(s);
		canvas.drawText(s, w / 2 - stringW / 2, planePaddingT + textSize * 1, paint);

		s = "" + step;
		stringW = paint.measureText(s);
		canvas.drawText(s, w / 2 - stringW / 2, planePaddingT + textSize * 3, paint);

		s = "PASS";
		stringW = paint.measureText(s);
		canvas.drawText(s, w / 2 - stringW / 2, planePaddingT + textSize * 5, paint);

		s = "" + pass;
		stringW = paint.measureText(s);
		canvas.drawText(s, w / 2 - stringW / 2, planePaddingT + textSize * 7, paint);
	}

	
	long down = 0;
	int maxPointCount = 0;
	float x1 = 0;
	float y1 = 0;
	float x2 = 0;
	float y2 = 0;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int pointerCount = event.getPointerCount();
		if(maxPointCount<pointerCount){
			maxPointCount = pointerCount;
		}
		
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			down = System.currentTimeMillis();
			
			break;
		case MotionEvent.ACTION_POINTER_DOWN:  
			
			break;
		case MotionEvent.ACTION_POINTER_INDEX_MASK:  
			
			break;
		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:
			long co = System.currentTimeMillis()-down;
			
			if(co>500){
				maxPointCount = 0;
				x1 = 0;
				y1 = 0;
				x2 = 0;
				y2 = 0;
				break;
			}
			
			if(step==0){
				step ++;
			}else if(step==1 || step==2 || step==3 || step==5 || step==7 || step==9){
				if(maxPointCount == 1){
					x1 = event.getX(0);
					y1 = event.getY(0);
					
					if(rocker3.isIn(x1, y1)){
						step++;
					}
				}
			}else{
				if(maxPointCount == 2){
					if((rocker1.isIn(x1, y1) && rocker2.isIn(x2, y2))
							|| (rocker2.isIn(x1, y1) && rocker1.isIn(x2, y2))
							){
						step++;
					}
				}
			}
			
			if(step>9){
				step = 0;
			}
			
			maxPointCount = 0;
			x1 = 0;
			y1 = 0;
			x2 = 0;
			y2 = 0;
			
			break;
        case MotionEvent.ACTION_POINTER_UP:  
			x1 = event.getX(0);
			y1 = event.getY(0);
			if(pointerCount>=2){
				x2 = event.getX(1);
				y2 = event.getY(1);
			}
			
			break;
		case MotionEvent.ACTION_CANCEL:

			break;
		default:
			break;
		}
		return true;
	}

}
