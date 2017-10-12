package com.example.andres.promedionotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edTN1M1, edTN2M1, edTN3M1;
    private EditText edTN1M2, edTN2M2, edTN3M2;
    private EditText edTN1M3, edTN2M3, edTN3M3;
    private EditText edTN1M4, edTN2M4, edTN3M4;

    TextView tVDef1, tVDef2, tVDef3, tVDef4, NF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Materia 1
        edTN1M1 = (EditText) findViewById(R.id.edTN1M1);
        edTN2M1 = (EditText) findViewById(R.id.edTN2M1);
        edTN3M1 = (EditText) findViewById(R.id.edTN3M1);
        //Materia 2
        edTN1M2 = (EditText) findViewById(R.id.edTN1M2);
        edTN2M2 = (EditText) findViewById(R.id.edTN2M2);
        edTN3M2 = (EditText) findViewById(R.id.edTN3M2);
        //Materia 3
        edTN1M3 = (EditText) findViewById(R.id.edTN1M3);
        edTN2M3 = (EditText) findViewById(R.id.edTN2M3);
        edTN3M3 = (EditText) findViewById(R.id.edTN3M3);
        //Materia 4
        edTN1M4 = (EditText) findViewById(R.id.edTN1M4);
        edTN2M4 = (EditText) findViewById(R.id.edTN2M4);
        edTN3M4 = (EditText) findViewById(R.id.edTN3M4);


        tVDef1 = (TextView) findViewById(R.id.tVDef1);
        tVDef2 = (TextView) findViewById(R.id.tVDef2);
        tVDef3 = (TextView) findViewById(R.id.tVDef3);
        tVDef4 = (TextView) findViewById(R.id.tVDef4);
        NF = (TextView) findViewById(R.id.NF);



        //Materia 1
        SharedPreferences prefe1=getSharedPreferences("mat1", Context.MODE_PRIVATE);
        edTN1M1.setText(prefe1.getString("m1Nota1",""));
        edTN2M1.setText(prefe1.getString("m1Nota2",""));
        edTN3M1.setText(prefe1.getString("m1Nota3",""));
        tVDef1.setText(prefe1.getString("m1Def1",""));

        ///////////////////////////////////////////////////////
        // ONCHANGE MATERIA 1

        edTN1M1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    SharedPreferences prefe1=getSharedPreferences("mat1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe1.edit();

                    float nro1 = Float.parseFloat(edTN1M1.getText().toString());
                    editor.putString("m1Nota1", edTN1M1.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M1.getText().toString());
                    editor.putString("m1Nota2", edTN2M1.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M1.getText().toString());
                    editor.putString("m1Nota3", edTN3M1.getText().toString());

                    if(nro1<=5 && nro1>=0) {

                        double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);

                        String materia1 = String.valueOf(result);
                        editor.putString("m1Def1", materia1);

                        editor.commit();
                        tVDef1.setText(materia1);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN1M1.getText().toString().equals("")) {

                        Toast vacio=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastLlenarCampos),Toast.LENGTH_LONG);
                        vacio.show();
                        Toast m1n1=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota1),Toast.LENGTH_LONG);
                        m1n1.show();
                    }
                }
            }
        });

        edTN2M1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe1=getSharedPreferences("mat1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe1.edit();

                    float nro1 = Float.parseFloat(edTN1M1.getText().toString());
                    editor.putString("m1Nota1", edTN1M1.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M1.getText().toString());
                    editor.putString("m1Nota2", edTN2M1.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M1.getText().toString());
                    editor.putString("m1Nota3", edTN3M1.getText().toString());

                    if(nro2<=5 && nro2>=0) {

                        double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                        String materia1 = String.valueOf(result);
                        editor.putString("m1Def1", materia1);

                        editor.commit();
                        tVDef1.setText(materia1);
                    }else {
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN2M1.getText().toString().equals("")) {
                        Toast m1n2=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota2),Toast.LENGTH_LONG);
                        m1n2.show();
                    }
                }
            }
        });

        edTN3M1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe1=getSharedPreferences("mat1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe1.edit();

                    float nro1 = Float.parseFloat(edTN1M1.getText().toString());
                    editor.putString("m1Nota1", edTN1M1.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M1.getText().toString());
                    editor.putString("m1Nota2", edTN2M1.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M1.getText().toString());
                    editor.putString("m1Nota3", edTN3M1.getText().toString());

                    if(nro3<=5 && nro3>=0) {

                        double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                        String materia1 = String.valueOf(result);
                        editor.putString("m1Def1", materia1);

                        editor.commit();
                        tVDef1.setText(materia1);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if(edTN3M1.getText().toString().equals("")) {
                        Toast m1n3=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota3),Toast.LENGTH_LONG);
                        m1n3.show();
                    }
                }
            }
        });

        //Materia 2
        SharedPreferences prefe2=getSharedPreferences("mat2", Context.MODE_PRIVATE);
        edTN1M2.setText(prefe2.getString("m2Nota1",""));
        edTN2M2.setText(prefe2.getString("m2Nota2",""));
        edTN3M2.setText(prefe2.getString("m2Nota3",""));
        tVDef2.setText(prefe2.getString("m2Def2",""));


        ///////////////////////////////////////////////////////
        // ONCHANGE MATERIA 2

        edTN1M2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int j, int j1, int j2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int j, int j1, int j2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    SharedPreferences prefe2=getSharedPreferences("mat2", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe2.edit();

                    float nro1 = Float.parseFloat(edTN1M2.getText().toString());
                    editor.putString("m2Nota1", edTN1M2.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M2.getText().toString());
                    editor.putString("m2Nota2", edTN2M2.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M2.getText().toString());
                    editor.putString("m2Nota3", edTN3M2.getText().toString());
                    if(nro1<=5 && nro1>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia2 = String.valueOf(result);
                    editor.putString("m2Def2", materia2);

                    editor.commit();
                    tVDef2.setText(materia2);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN1M2.getText().toString().equals("")) {
                        Toast m2n1=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota1),Toast.LENGTH_LONG);
                        m2n1.show();
                    }
                }
            }
        });

        edTN2M2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe2=getSharedPreferences("mat2", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe2.edit();

                    float nro1 = Float.parseFloat(edTN1M2.getText().toString());
                    editor.putString("m2Nota1", edTN1M2.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M2.getText().toString());
                    editor.putString("m2Nota2", edTN2M2.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M2.getText().toString());
                    editor.putString("m2Nota3", edTN3M2.getText().toString());

                    if(nro2<=5 && nro2>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia2 = String.valueOf(result);
                    editor.putString("m2Def2", materia2);

                    editor.commit();
                    tVDef2.setText(materia2);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN2M2.getText().toString().equals("")) {
                        Toast m2n2=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota2),Toast.LENGTH_LONG);
                        m2n2.show();
                    }
                }
            }
        });

        edTN3M2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe2=getSharedPreferences("mat2", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe2.edit();

                    float nro1 = Float.parseFloat(edTN1M2.getText().toString());
                    editor.putString("m2Nota1", edTN1M2.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M2.getText().toString());
                    editor.putString("m2Nota2", edTN2M2.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M2.getText().toString());
                    editor.putString("m2Nota3", edTN3M2.getText().toString());

                    if(nro3<=5 && nro3>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia2 = String.valueOf(result);
                    editor.putString("m2Def2", materia2);

                    editor.commit();
                    tVDef2.setText(materia2);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN3M2.getText().toString().equals("")) {
                        Toast m2n3=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota3),Toast.LENGTH_LONG);
                        m2n3.show();
                    }
                }
            }
        });

        //Materia 3
        SharedPreferences prefe3=getSharedPreferences("mat3", Context.MODE_PRIVATE);
        edTN1M3.setText(prefe3.getString("m3Nota1",""));
        edTN2M3.setText(prefe3.getString("m3Nota2",""));
        edTN3M3.setText(prefe3.getString("m3Nota3",""));
        tVDef3.setText(prefe3.getString("m3Def3",""));

        ///////////////////////////////////////////////////////
        // ONCHANGE MATERIA 3

        edTN1M3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int h, int h1, int h2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int h, int h1, int h2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    SharedPreferences prefe3=getSharedPreferences("mat3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe3.edit();

                    float nro1 = Float.parseFloat(edTN1M3.getText().toString());
                    editor.putString("m3Nota1", edTN1M3.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M3.getText().toString());
                    editor.putString("m3Nota2", edTN2M3.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M3.getText().toString());
                    editor.putString("m3Nota3", edTN3M3.getText().toString());

                    if(nro1<=5 && nro1>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia3 = String.valueOf(result);
                    editor.putString("m3Def3", materia3);

                    editor.commit();
                    tVDef3.setText(materia3);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN1M3.getText().toString().equals("")) {
                        Toast m3n1=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota1),Toast.LENGTH_LONG);
                        m3n1.show();
                    }
                }
            }
        });

        edTN2M3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe3=getSharedPreferences("mat3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe3.edit();

                    float nro1 = Float.parseFloat(edTN1M3.getText().toString());
                    editor.putString("m3Nota1", edTN1M3.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M3.getText().toString());
                    editor.putString("m3Nota2", edTN2M3.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M3.getText().toString());
                    editor.putString("m3Nota3", edTN3M3.getText().toString());

                    if(nro2<=5 && nro2>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia3 = String.valueOf(result);
                    editor.putString("m3Def3", materia3);

                    editor.commit();
                    tVDef3.setText(materia3);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN2M3.getText().toString().equals("")) {
                        Toast m3n2=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota2),Toast.LENGTH_LONG);
                        m3n2.show();
                    }
                }
            }
        });

        edTN3M3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe3=getSharedPreferences("mat3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe3.edit();

                    float nro1 = Float.parseFloat(edTN1M3.getText().toString());
                    editor.putString("m3Nota1", edTN1M3.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M3.getText().toString());
                    editor.putString("m3Nota2", edTN2M3.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M3.getText().toString());
                    editor.putString("m3Nota3", edTN3M3.getText().toString());

                    if(nro3<=5 && nro3>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia3 = String.valueOf(result);
                    editor.putString("m3Def3", materia3);

                    editor.commit();
                    tVDef3.setText(materia3);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN3M3.getText().toString().equals("")) {
                        Toast m3n3=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota3),Toast.LENGTH_LONG);
                        m3n3.show();
                    }
                }
            }
        });


        //Materia 4
        SharedPreferences prefe4=getSharedPreferences("mat4", Context.MODE_PRIVATE);
        edTN1M4.setText(prefe4.getString("m4Nota1",""));
        edTN2M4.setText(prefe4.getString("m4Nota2",""));
        edTN3M4.setText(prefe4.getString("m4Nota3",""));
        tVDef4.setText(prefe4.getString("m4Def4",""));

        ///////////////////////////////////////////////////////
        // ONCHANGE MATERIA 4

        edTN1M4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int k, int k1, int k2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int k, int k1, int k2) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                try {
                    SharedPreferences prefe4=getSharedPreferences("mat4", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe4.edit();

                    float nro1 = Float.parseFloat(edTN1M4.getText().toString());
                    editor.putString("m4Nota1", edTN1M4.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M4.getText().toString());
                    editor.putString("m4Nota2", edTN2M4.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M4.getText().toString());
                    editor.putString("m4Nota3", edTN3M4.getText().toString());

                    if(nro1<=5 && nro1>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia4 = String.valueOf(result);
                    editor.putString("m4Def4", materia4);

                    editor.commit();
                    tVDef4.setText(materia4);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN1M4.getText().toString().equals("")) {
                        Toast m4n1=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota1),Toast.LENGTH_LONG);
                        m4n1.show();
                    }
                }
            }
        });

        edTN2M4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe4=getSharedPreferences("mat4", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe4.edit();

                    float nro1 = Float.parseFloat(edTN1M4.getText().toString());
                    editor.putString("m4Nota1", edTN1M4.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M4.getText().toString());
                    editor.putString("m4Nota2", edTN2M4.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M4.getText().toString());
                    editor.putString("m4Nota3", edTN3M4.getText().toString());

                    if(nro2<=5 && nro2>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia4 = String.valueOf(result);
                    editor.putString("m4Def4", materia4);

                    editor.commit();
                    tVDef4.setText(materia4);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN2M4.getText().toString().equals("")) {
                        Toast m4n2=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota2),Toast.LENGTH_LONG);
                        m4n2.show();
                    }
                }
            }
        });

        edTN3M4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int coun, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int star, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SharedPreferences prefe4=getSharedPreferences("mat4", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=prefe4.edit();

                    float nro1 = Float.parseFloat(edTN1M4.getText().toString());
                    editor.putString("m4Nota1", edTN1M4.getText().toString());

                    float nro2 = Float.parseFloat(edTN2M4.getText().toString());
                    editor.putString("m4Nota2", edTN2M4.getText().toString());

                    float nro3 = Float.parseFloat(edTN3M4.getText().toString());
                    editor.putString("m4Nota3", edTN3M4.getText().toString());

                    if(nro3<=5 && nro3>=0) {

                    double result = (((nro1 + nro2) / 2) * 0.6) + (nro3 * 0.4);
                    String materia4 = String.valueOf(result);
                    editor.putString("m4Def4", materia4);

                    editor.commit();
                    tVDef4.setText(materia4);
                    }else{
                        Toast noMayor=Toast.makeText(MainActivity.this,getResources().getString(R.string.toast1),Toast.LENGTH_LONG);
                        noMayor.show();
                    }

                } catch (Exception e) {
                    if (edTN3M4.getText().toString().equals("")) {
                        Toast m4n3=Toast.makeText(MainActivity.this,getResources().getString(R.string.toastNota3),Toast.LENGTH_LONG);
                        m4n3.show();
                    }
                }
            }
        });

    }

    //SACA PROMEDIO
    public void promedio(View view){


               if (edTN1M1.getText().toString().equals("") ||
                   edTN2M1.getText().toString().equals("") ||
                   edTN3M1.getText().toString().equals("") ||
                   edTN1M2.getText().toString().equals("") ||
                   edTN2M2.getText().toString().equals("") ||
                   edTN3M2.getText().toString().equals("") ||
                   edTN1M3.getText().toString().equals("") ||
                   edTN2M3.getText().toString().equals("") ||
                   edTN3M3.getText().toString().equals("") ||
                   edTN1M4.getText().toString().equals("") ||
                   edTN2M4.getText().toString().equals("") ||
                   edTN3M4.getText().toString().equals("")) {

               Toast total = Toast.makeText(MainActivity.this, getResources().getString(R.string.toastCampoVacio), Toast.LENGTH_LONG);
               total.show();
           }
           else{

               float tVDf1,tVDf2,tVDf3,tVDf4, PF;

               tVDf1 = Float.parseFloat(tVDef1.getText().toString());
               tVDf2 = Float.parseFloat(tVDef2.getText().toString());
               tVDf3 = Float.parseFloat(tVDef3.getText().toString());
               tVDf4 = Float.parseFloat(tVDef4.getText().toString());

               PF = ((tVDf1+tVDf2+tVDf3+tVDf4)/4);
               String total = String.valueOf(PF);
               NF.setText(total);
           }
    }

    /**
     *metodo para ingresar acerca de
     * @param view
     */
    public void acercaDe(View view){

        Intent i=new Intent(this,AcercaDe.class);
        startActivity(i);

    }


}