package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    TextView pantalla, procedimiento;
    Button a;
    double valor1=0.0,valor2=0.0;
    public void miclick(View view)
    {
        int seleccion= view.getId();
        a=(Button)findViewById(seleccion);
        pantalla=(TextView) findViewById(R.id.pantalla);
        if(pantalla.getText()=="0")
        {
            pantalla.setText(null);
        }
        pantalla.setText(pantalla.getText().toString()+a.getText().toString());

    }
    String oper=null;
    public void operacion(View view)
    {
        pantalla=(TextView)findViewById(R.id.pantalla);
        procedimiento=(TextView) findViewById(R.id.procedimiento);
        int seleccion= view.getId();
        a=(Button)findViewById(seleccion);
        valor1=Double.parseDouble(pantalla.getText().toString());
        procedimiento.setText(pantalla.getText().toString()+a.getText().toString());
        pantalla.setText("0");
        switch (seleccion)
        {
            case R.id.multiplicacion: oper="multiplicacion";    break;
            case R.id.suma: oper="suma";            break;
            case R.id.resta: oper="resta";          break;
            case R.id.division: oper="division";    break;
            case R.id.potencia: oper="potencia";    break;
            default:
        }
    }


    public void borrar(View view) {
    }

    public void borratodo(View view) {
        pantalla=(TextView)findViewById(R.id.pantalla);
        procedimiento=(TextView) findViewById(R.id.procedimiento);
        procedimiento.setText(null);
        pantalla.setText("0");
    }

    public void igual(View view) {
        pantalla=(TextView)findViewById(R.id.pantalla);
        procedimiento=(TextView) findViewById(R.id.procedimiento);
        valor2=Double.parseDouble(pantalla.getText().toString());
        procedimiento.setText(procedimiento.getText().toString()+pantalla.getText().toString());
        double resultado=0.0;
        switch (oper)
        {
            case "multiplicacion":
                resultado=valor1*valor2;
                break;
            case "division":
                resultado=valor1/valor2;
                break;
            case "suma":
                resultado=valor1+valor2;
                break;
            case "resta":
                resultado=valor1-valor2;
                break;
            case "potencia":
                resultado=Math.pow(valor1, valor2);
                break;
            default: resultado=0.0;
        }
        pantalla.setText(String.format(String.valueOf(resultado)));

    }
}