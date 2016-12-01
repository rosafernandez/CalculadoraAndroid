package edu.upc.eetac.dsa.calculadorasenzilla;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//declaració de les variables
    Integer numero1,numero2;
    Double resultatoperacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    //funció que es realitza quan fem click sobre el botó RESULTAT
    public void onClickResultat(View v)
    {
        RadioButton botoSumar = (RadioButton) findViewById(R.id.rbSumar);
        RadioButton botoRestar = (RadioButton) findViewById(R.id.rbRestar);
        RadioButton botoMultiplicar = (RadioButton) findViewById(R.id.rbMultiplicar);
        RadioButton botoDividir = (RadioButton) findViewById(R.id.rbDividir);
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resultat = (TextView) findViewById(R.id.resultat);
        try {

        numero1 = Integer.parseInt(num1.getText().toString());
        numero2 = Integer.parseInt(num2.getText().toString());

        //notificació del tipus "Toast" que indica que la operació s'ha realitzat correctament.
        Context context = getApplicationContext();
        CharSequence text = "Operació resolta";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //definició de les diferents operacions.
        if (botoSumar.isChecked()){
            resultatoperacio = (double) numero1 + (double) numero2;
        }
        else if (botoRestar.isChecked()){
            resultatoperacio = (double)numero1- (double) numero2;
        }
        else if (botoDividir.isChecked()){
            resultatoperacio = (double) numero1/ (double) numero2;
        }
        else if (botoMultiplicar.isChecked()){
            resultatoperacio = (double)numero1* (double) numero2;
        }

        //Delimitem el nombre de decimals a mostrar en el resultat de la operació.
        DecimalFormat decimals= new DecimalFormat("#.###");
        String res=decimals.format(resultatoperacio);
        resultat.setText(res.toString());
        }
        //notificació del tipus "Toast" que indica que cal indicar els dos números per poder operar.
        catch (Exception e) {
            Context context = getApplicationContext();
            CharSequence text = "Cal indicar els dos valors numèrics";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

        //funció que es produeix al fer click sobre el botó ESBORRAR
    public void onClickEsborrar(View v) {
        numero1 = 0;
        numero2 = 0;
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resultat = (TextView) findViewById(R.id.resultat);

        //inicialitzem el text dels EditText a 0
        num1.setText("0");
        num2.setText("0");
        resultat.setText("0");
    }

    //funció que es realitza quan seleccionem un RadioButton
    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        switch(v.getId()) {
            case R.id.rbSumar:
                if (checked)
                    break;
            case R.id.rbRestar:
                if (checked)
                    break;
            case R.id.rbDividir:
                if (checked)
                    break;
            case R.id.rbMultiplicar:
                if (checked)
                    break;
        }
    }
}

