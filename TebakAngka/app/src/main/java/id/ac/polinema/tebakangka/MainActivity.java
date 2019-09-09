package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int numInput, randNumber;
	private Random random;
	private EditText numInputForm;
	private Button guessBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		random = new Random();
		numInputForm = findViewById(R.id.number_input);
		guessBtn = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		randNumber = random.nextInt(100) + 1;

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String numInputString = numInputForm.getText().toString();
		if (numInputString.equalsIgnoreCase("")) {
			Toast.makeText(this, "Input harus berupa angka", Toast.LENGTH_SHORT).show();
		} else {
			numInput = Integer.parseInt(numInputString);
			if (numInput > randNumber) {
				Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
			} else if (numInput < randNumber) {
				Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
			} else if (numInput == randNumber) {
				Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_SHORT).show();
				guessBtn.setEnabled(false);
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numInputForm.setText("");
		initRandomNumber();
		guessBtn.setEnabled(true);
	}
}
