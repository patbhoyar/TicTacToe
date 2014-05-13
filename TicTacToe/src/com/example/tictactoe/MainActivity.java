package com.example.tictactoe;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, resetGame;
	private int turn = 0;
	private TextView whoseTurn;
	private Button[] buttonList = new Button[9];
	
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
		whoseTurn = (TextView) findViewById(R.id.whoseTurn);
		buttonList[0] = button1;
		buttonList[1] = button2;
		buttonList[2] = button3;
		buttonList[3] = button4;
		buttonList[4] = button5;
		buttonList[5] = button6;
		buttonList[6] = button7;
		buttonList[7] = button8;
		buttonList[8] = button9;
		
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
			}else if (v.getId() == resetGame.getId()) {
				resetGame();
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
		char t = (turn == 1)?'X':'O';
		whoseTurn.setText(t+"'s Turn");
		checkForWinner();
	}
	
	private void checkForWinner(){
		String block0 = String.valueOf(buttonList[0].getText());
		String block1 = String.valueOf(buttonList[1].getText());
		String block2 = String.valueOf(buttonList[2].getText());
		String block3 = String.valueOf(buttonList[3].getText());
		String block4 = String.valueOf(buttonList[4].getText());
		String block5 = String.valueOf(buttonList[5].getText());
		String block6 = String.valueOf(buttonList[6].getText());
		String block7 = String.valueOf(buttonList[7].getText());
		String block8 = String.valueOf(buttonList[8].getText());
		
		if (block0 == block1 && block1 == block2 && block2 != "") {
			whoseTurn.setText(block0+" Won");
			disableAllButtons();
		}else if (block3 == block4 && block4 == block5 && block3 != "") {
			whoseTurn.setText(block3+" Won");
			disableAllButtons();
		}else if (block6 == block7 && block7 == block8 && block6 != "") {
			whoseTurn.setText(block6+" Won");
			disableAllButtons();
		}else if (block0 == block3 && block3 == block6 && block0 != "") {
			whoseTurn.setText(block6+" Won");
			disableAllButtons();
		}else if (block1 == block4 && block4 == block7 && block1 != "") {
			whoseTurn.setText(block1+" Won");
			disableAllButtons();
		}else if (block2 == block5 && block5 == block8 && block2 != "") {
			whoseTurn.setText(block2+" Won");
			disableAllButtons();
		}else if (block0 == block4 && block4 == block8 && block0 != "") {
			whoseTurn.setText(block0+" Won");
			disableAllButtons();
		}else if (block2 == block4 && block4 == block6 && block2 != "") {
			whoseTurn.setText(block2+" Won");
			disableAllButtons();
		}
		
	}
	
	private void disableAllButtons(){
		for (Button b : buttonList) {
			b.setEnabled(false);
		}
	}
	
	private void enableAllButtons(){
		for (Button b : buttonList) {
			b.setEnabled(true);
		}
	}
	
	private void resetGame(){
		enableAllButtons();
		turn = 0;
		whoseTurn.setText("O's Turn");
		for (Button b : buttonList) {
			b.setText("");
		}
	}

}
