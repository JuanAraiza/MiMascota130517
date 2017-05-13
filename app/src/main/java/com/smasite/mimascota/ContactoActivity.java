package com.smasite.mimascota;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.smasite.mimascota.Mail.SendMail;

public class ContactoActivity extends AppCompatActivity {
    private EditText teNombre;
    private EditText teEmail;
    private EditText teMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setNavigationIcon(R.drawable.back_26);
        setSupportActionBar(miActionBar);
    }


    public void btn_enviar(View view) {
        teNombre = (EditText) findViewById(R.id.etNombre);
        teEmail = (EditText) findViewById(R.id.etEmail);
        teMensaje = (EditText) findViewById(R.id.etMensaje);

        String nombre = teNombre.getText().toString().trim();
        String email = teEmail.getText().toString().trim();
        String mensaje = teMensaje.getText().toString().trim();

         SendMail sm = new SendMail(this, email, nombre, mensaje);

        //Executing sendmail to send email
       sm.execute();

    }
}


