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

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    public static AlmacenPuntuaciones almacen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreditos = (Button) findViewById(R.id.button);
        final Button btnPreferencias = (Button) findViewById(R.id.button2);
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

        //* Shared Preferences
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacen = new AlmancenPuntuacionesPreferencias(getApplicationContext());
                almacen.guardarPuntuacion(5000, "Darwin", 20181211);
                almacen.guardarPuntuacion(5000, "test", 20181211);
                almacen.guardarPuntuacion(5000, "test2", 20181211);
                lanzarConf(v);
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

    public void lanzarConf(View view) {
        Vector<String> rs = new Vector<String>();
        rs = almacen.listaPuntuaciones(1);

        for (int i = 0; i < rs.size(); i++){
            Toast.makeText(getApplicationContext(), rs.get(i), Toast.LENGTH_LONG).show();
        }
    }

}
