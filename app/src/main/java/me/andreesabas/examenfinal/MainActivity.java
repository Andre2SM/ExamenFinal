package me.andreesabas.examenfinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreditos = (Button) findViewById(R.id.button);
        Button btnPreferencias = (Button) findViewById(R.id.button2);
        Button btnWebServices = (Button) findViewById(R.id.button3);
        Button btnSalir = (Button) findViewById(R.id.button4);

        //* Mostrar Pop Up de créditos
        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //* Usando una actividad
                /*Intent credit = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(credit);*/

                //* Usando Dialog, mejor solución

                AlertDialog.Builder builder;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(MainActivity.this);
                }
                builder.setTitle("Créditos")
                        .setMessage("Aqui va el texto de los créditos.")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        //* Salir de la aplicación
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });



    }
}
