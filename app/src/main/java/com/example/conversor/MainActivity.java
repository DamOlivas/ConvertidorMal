package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //DECLARO ELEMENTOS
    private TextView dolares;
    private TextView yenes;
    private TextView pesosChilenos;
    private TextView libras;
    private TextView montoCambio;
    private Button calcula;

    //DECLARANDO OBJETO DE LA CLASE DIVISA
    private Divisa divisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
    }

    // MÉTODO PARA "CONECTAR" LOS ELEMENTOS DE LA VISTA CON LOS DE ESTA CLASE
    private void iniciar(){


        calcula = (Button) findViewById(R.id.calcular);

        //ASIGNAR EVENTO ONCLICK AL BOTÓN DE COMANDO
        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calculaCambio();

            }
        });

        dolares = (TextView) findViewById(R.id.dolar);
        yenes = (TextView) findViewById(R.id.yen);
        pesosChilenos = (TextView) findViewById(R.id.pech);
        libras = (TextView) findViewById(R.id.libe);
        montoCambio = (TextView) findViewById(R.id.montoCambiar);
    }

    //MÉTODO PARA CALCULAR LOS TIPOS DE CAMBIO
    private void calculaCambio(){

        //CAPTURA DE DATOS
        //CONVERTIR LOS DATOS DE LA VISTA EN REALES PARA PODER CALCULAR, SINO SERÁN CADENAS
        Float floatMC= Float.parseFloat(montoCambio.getText().toString());
        Float floatdl= Float.parseFloat(dolares.getText().toString());
        Float floatyn= Float.parseFloat(yenes.getText().toString());
        Float floatpc= Float.parseFloat(pesosChilenos.getText().toString());
        Float floatlb= Float.parseFloat(libras.getText().toString());

        //INVOCACIÓN DEL MÉTODO ESTÁTICO
        try {
            Float r = Divisa.calcularCambios(floatMC, floatdl, floatlb, floatpc, floatyn);
            dolares.setText("R= " + r);
            yenes.setText("R " + r);
            pesosChilenos.setText("R " + r);
            libras.setText("R " + r);

        } catch (Exception e) {
            //IMPRIME EL SEGUIMIENTO DE LA PILA DE ERRORES
            e.printStackTrace();
            //ENVIAR A LA VISTA DEL USUARIO UN MENSAJE DE ERROR
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

}