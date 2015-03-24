package com.github.draganddroplistview;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements onDropListener {

	LinearLayout dropbox1,dropbox2;
	LinearLayout variableview;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        dropbox1 =(LinearLayout)findViewById(R.id.Variable1);
		dropbox2 =(LinearLayout)findViewById(R.id.Variable2);
		variableview = (LinearLayout)findViewById(R.id.VariableView);
		
		
		
		
		
    }
    
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	
    	String [] items = new String [] {"Mango","Kiwi","Apples", "Grapes", "Capsicum", "Carrots","Okra"};
    	for(String item : items)
		{
			
			variableview.addView(PopulateSingleList(item));
		}
    	
    
  
    	
    	SelectionOnDragListener draglisten = new SelectionOnDragListener(this);
		draglisten.setOnDropListener(this);
    	dropbox1.setOnDragListener(draglisten);
    	dropbox1.setTag("Fruits");
		dropbox2.setOnDragListener(draglisten);
		dropbox2.setTag("Vegetables");
    }


	@Override
	public void onDrop(String data, String tag) {
		
		if(tag.equals("Fruits"))
		{
			
			TextView view = new TextView(this);
			view.setGravity(Gravity.CENTER);
			view.setText(data);
			dropbox1.addView(view);
		}
		else if (tag.equals("Vegetables"))
		{
			
			TextView view = new TextView(this);
			view.setGravity(Gravity.CENTER);
			view.setText(data);
			dropbox2.addView(view);
		}
		
	}
    
	private View PopulateSingleList(String title) {
		
		
		LayoutInflater inflater = (LayoutInflater)this.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.variable_selection_list_item,null);
		TextView tt1 = (TextView) v.findViewById(R.id.VarName);
		tt1.setText(title);
		
		v.setTag(title);
		v.setOnTouchListener(new SelectedOnTouchListener(){});
		
		return v;
	}
    


    
}
