package com.example.tictactoe;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetGame;
	private int turn = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button7);
		button8 = (Button) findViewById(R.id.button8);
		button9 = (Button) findViewById(R.id.button9);
		resetGame = (Button) findViewById(R.id.resetGame);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		resetGame.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		try {
			if (v.getId() == button1.getId()) {
				manipulateButton(button1);
			}else if (v.getId() == button2.getId()) {
				manipulateButton(button2);
			}else if (v.getId() == button3.getId()) {
				manipulateButton(button3);
			}else if (v.getId() == button4.getId()) {
				manipulateButton(button4);
			}else if (v.getId() == button5.getId()) {
				manipulateButton(button5);
			}else if (v.getId() == button6.getId()) {
				manipulateButton(button6);
			}else if (v.getId() == button7.getId()) {
				manipulateButton(button7);
			}else if (v.getId() == button8.getId()) {
				manipulateButton(button8);
			}else if (v.getId() == button9.getId()) {
				manipulateButton(button9);
			}
			
		} catch (Exception e) {
			Log.d("Exception", e.getMessage());
		}
		
		
	}
	
	private void manipulateButton(Button b){
		b.setEnabled(false);
		if (turn == 0) {
			b.setText("O");
			turn = 1;
		}else{
			b.setText("X");
			turn = 0;
		}
	}

}
