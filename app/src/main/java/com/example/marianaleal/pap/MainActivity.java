package com.example.marianaleal.pap;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import android.app.ProgressDialog;

public class MainActivity extends AppCompatActivity {


    private UsuarioService service = new UsuarioService();

    private List<Evento> eventos = new ArrayList();
    private EventoArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventos.add(new Evento(1, "Lollapalooza: maior festilva de música", 16, "Diversos", "21h00", R.drawable.lollapalooza, "Lollapalooza", 400.00));

        adapter = new EventoArrayAdapter(this, 0, eventos);
        ((ListView) findViewById(R.id.eventos)).setAdapter(adapter);

    }

    private class OurTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog dialog;
        private Usuario usuario;

        public OurTask(Usuario usuario) {
        this.usuario = usuario;

        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            service.post(usuario);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();

        }
    }


}
