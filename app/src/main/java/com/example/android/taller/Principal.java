package com.example.android.taller;

import android.content.res.Resources;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private TextView res,res1,res2;
    private Spinner hombre_zapatilla;
    private Spinner mujer_zapatilla;
    private Resources resources;
    private String op[];
    private String op3[];
    private EditText n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = (TextView)findViewById(R.id.lblResultado);
        res1 = (TextView)findViewById(R.id.lblResultado2);
        res2 = (TextView)findViewById(R.id.lblResultado3);
        hombre_zapatilla = (Spinner)findViewById(R.id.spinner);
        mujer_zapatilla = (Spinner)findViewById(R.id.spinner3);
        resources = getResources();
        op = resources.getStringArray(R.array.zapatillas1);
        op3 = resources.getStringArray(R.array.zapatillas2);
        n1 = (EditText)findViewById(R.id.txtNumeroUno);
        n2 = (EditText)findViewById(R.id.txtNumeroTres);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op);
        hombre_zapatilla.setAdapter(adapter);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,op3);
        mujer_zapatilla.setAdapter(adapter3);

    }
    
    public static double validar_cantidad(String n){
        if (n != null) return Double.parseDouble(n);
        else return 0.0;
    }

    public static double sumarTotal(double n1, double n2){
        return n1+n2;
    }

    public static double multiplicar(int price, double cant){
        return price*cant;
    }
    
   public void calcular (View v){
       int opcion, opcion1;
       double num1,num2, resultado=0, resultado1=0, resultado2=0;
       res.setText("");
       res1.setText("");
       res2.setText("");
       if(validar()) {
           opcion = hombre_zapatilla.getSelectedItemPosition();
           opcion1 = mujer_zapatilla.getSelectedItemPosition();
           num1 = validar_cantidad(n1.getText().toString());
           num2 = validar_cantidad(n2.getText().toString());
           switch (opcion) {
               case 0:
                   resultado = multiplicar(120000, num1);
                   break;
               case 1:
                   resultado = multiplicar(140000, num1);
                   break;
               case 2:
                   resultado = multiplicar(130000, num1);
                   break;
               case 3:
                   resultado = multiplicar(50000, num1);
                   break;
               case 4:
                   resultado = multiplicar(80000, num1);
                   break;
               case 5:
                   resultado = multiplicar(100000, num1);
                   break;
           }

           switch (opcion1) {
               case 0:
                   resultado1 = multiplicar(100000, num2);
                   break;
               case 1:
                   resultado1 = multiplicar(130000, num2);
                   break;
               case 2:
                   resultado1 = multiplicar(110000, num2);
                   break;
               case 3:
                   resultado1 = multiplicar(60000, num2);
                   break;
               case 4:
                   resultado1 = multiplicar(70000, num2);
                   break;
               case 5:
                   resultado1 = multiplicar(120000, num2);
                   break;
           }
           res.setText("valor hombre: " + String.format("%.0f", resultado));
           res1.setText("valor mujer: " + String.format("%.0f", resultado1));
           resultado2 = sumarTotal(resultado, resultado1);
           res2.setText("el valor total: " + String.format("%.0f", resultado2));
       }
   }

    public void borrar(View v) {
        n1.setText("");
        n2.setText("");
        res.setText("");
        res1.setText("");
        res2.setText("");
        hombre_zapatilla.setSelection(0);
        mujer_zapatilla.setSelection(0);
        n1.requestFocus();
    }

    private boolean validar(){
        int opcion = hombre_zapatilla.getSelectedItemPosition();
        int opcion1 = mujer_zapatilla.getSelectedItemPosition();

        if (n1.getText().toString().isEmpty()){
            n1.setError(resources.getString(R.string.error_uno));
            n1.requestFocus();
            return false;
        }
        if (n2.getText().toString().isEmpty()){
            n2.setError(resources.getString(R.string.error_uno));
            n2.requestFocus();
            return false;
        }

        return true;
    }


}
