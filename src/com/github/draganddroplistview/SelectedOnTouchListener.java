package com.github.draganddroplistview;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnTouchListener;

public class SelectedOnTouchListener implements OnTouchListener {

	@Override
	public boolean onTouch(View v, MotionEvent motionEvent) {
	
		
		 if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			      ClipData data = ClipData.newPlainText("", "");
			      DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
			      v.startDrag(data, shadowBuilder, v, 0);
			     // v.setVisibility(View.INVISIBLE);
			      return true;
			    } else {
			    return false;
			    }
			  
	}

}
