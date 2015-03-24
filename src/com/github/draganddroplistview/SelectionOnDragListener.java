package com.github.draganddroplistview;

import android.content.ClipData;
import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;
import android.widget.TextView;




public class SelectionOnDragListener implements OnDragListener  {

Context context;
	
	private onDropListener callback;
	
	
	public SelectionOnDragListener(Context context)
	{
		this.context = context;
		
		
	}
	
	public void setOnDropListener(onDropListener callback)
	{
		this.callback = callback;
	}
	
	
	
	
	@Override
	public boolean onDrag(View v, DragEvent event) {
		
	  
	  switch (event.getAction()) {

	     case DragEvent.ACTION_DRAG_STARTED:
		
		 
         
       
        break;
      case DragEvent.ACTION_DRAG_ENTERED:
    	
    	 
    	  v.setBackgroundResource(R.drawable.enter_drop_zone);
    	  v.invalidate();
    	 
        break;
      case DragEvent.ACTION_DRAG_EXITED:
        
    	  v.setBackgroundResource(R.drawable.drop_drawable);
    	  v.invalidate();
        break;
        
      case DragEvent.ACTION_DROP:
        // Dropped, reassign View to ViewGroup
    	  
    	  View view =(View)event.getLocalState();
    	  
    	  
    	  TextView  drop = (TextView) view.findViewById(R.id.VarName);
    	

          LinearLayout container = (LinearLayout) v;

          callback.onDrop(drop.getText().toString(),v.getTag().toString());
          break;
        
        
      case DragEvent.ACTION_DRAG_ENDED:
       
    	  v.setBackgroundResource(R.drawable.drop_drawable);
    	  v.invalidate();
      default:
        break;
      }
      return true;

		
                   

	}
}
