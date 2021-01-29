package com.example.tateti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnEmpezar;
    EditText nombreImpar,nombrePar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreImpar = findViewById(R.id.editImpar);
        nombrePar = findViewById(R.id.editPar);
        btnEmpezar = findViewById(R.id.btnEmpezar);

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] jugadores = {nombreImpar.getText().toString(),nombrePar.getText().toString()};
                Bundle bundle = new Bundle();
                bundle.putStringArray("jugadores",jugadores);
                Intent intent = new Intent(getApplicationContext(),JuegoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
