package br.edu.fateczl.bhaskaraform;

import static java.lang.Math.sqrt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvSol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvSol), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etA = findViewById(R.id.etA);
        etA.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvSol = findViewById(R.id.tvSol);
        tvSol.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnRes = findViewById(R.id.btnRes);

        btnRes.setOnClickListener(op -> res());
    }

    private void res() {
        float a = Float.parseFloat(etA.getText().toString());
        float b = Float.parseFloat(etB.getText().toString());
        float c = Float.parseFloat(etC.getText().toString());

        double delta = sqrt(b * b - 4 * a * c);

        float x1 = (float) (-b - sqrt(delta)) / (2 * a);
        float x2 = (float) (-b + sqrt(delta)) / (2 * a);
        String s = getString(R.string.sol) + " " + x1 + " e " + x2;
        tvSol.setText(s);
        etA.setText("");
        etB.setText("");
        etC.setText("");
    }
}