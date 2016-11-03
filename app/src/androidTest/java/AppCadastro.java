/**
 * Created by MARIANA LEAL on 30/10/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

import com.example.marianaleal.pap.R;

public class AppCadastro extends Activity {
    Registro pri, reg, ult, aux;
    EditText nome, endereco, horario, descricao, estilomusical;
    int numreg, pos, precoentr;

    void CarregaTelaInicial() {
        setContentView(R.layout.main);
        Button btnovo = (Button) findViewById(R.id.btnovo);
        Button btcadastrados = (Button) findViewById(R.id.btcadastrados);

        btnovo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CarregaTelaCadastro();

            }
        });

        btcadastrados.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CarregaTelaCadastrados();

            }
        });

    }

    void CarregaTelaCadastro() {

        setContentView(R.layout.cadastro);

        Button btconfirma = (Button) findViewById(R.cadastro.btconfirma);
        Button btcancelar = (Button) findViewById(R.cadastro.btcancelar);

        btconfirma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    reg = new Registro();

                    nome = (EditText) findViewById(R.cadastro.nome);
                    endereco = (EditText) findViewById(R.cadastro.endereco);
                    horario = (EditText) findViewById(R.cadastro.horario);
                    descricao = (EditText) findViewById(R.cadastro.descricao);
                    estilomusical = (EditText) findViewById (R.cadastro.estilomusical);
                    precoentr = (EditText) findViewById(R.cadastro.precoentr);

                    reg.nome = nome.getText().toString();
                    reg.endereco = endereco.getText().toString();
                    reg.horario = horario.getText().toString();
                    reg.descricao = descricao.getText().toString();
                    reg.estilomusical = estilomusical.getText().toString();
                    reg.precoentr = precoentr.getText().toString();

                    if (pri == null)
                        pri = reg;

                    reg.Ant = ult;
                    if (ult == null)
                        ult = reg;
                    else {
                        ult.Prox = reg;
                        ult = reg;
                    }

                    numreg++;
                    showMessage("Cadastrado com Exito", AppCadastro.this);
                    CarregaTelaInicial();

                } catch (Exception e) {
                    showMessage("Erro Ao efetivar o cadastro", AppCadastro.this);

                }
            }
        });

        btcancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                CarregaTelaInicial();
            }
        });

    }

    void CarregaTelaCadastrados() {
        if (numreg == 0) {
            showMessage("Não consta Cadastro", AppCadastro.this);

            CarregaTelaInicial();
            return;
        }

        setContentView(R.layout.cadastrados);
        pos = 1;
        aux = pri;
        TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
        TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
        TextView txthorario = (TextView) findViewById(R.cadastrados.txthorario);
        TextView txtdescricao = (TextView) findViewById(R.cadastrados.txtdescricao);
        TextView txtestilomusical = (TextView) findViewById(R.cadastro.txtestilomusical);
        TextView txtprecoentr = (TextView) findViewById (R.cadastro.txtprecoentr);

        Button btmenu = (Button) findViewById(R.cadastrados.btmenu);
        Button btavancar = (Button) findViewById(R.cadastrados.btavancar);
        Button btvoltar = (Button) findViewById(R.cadastrados.btvoltar);

        txtnome.setText(aux.nome);
        txtendereco.setText(aux.endereco);
        txthorario.setText(aux.horario);
        txtdescricao.setText(aux.descricao);
        txtestilomusical.setText(aux.estilomusical);
        txtprecoentr.setText(aux.precoentr);


        btmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                CarregaTelaInicial();

            }
        });

        btvoltar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (pos == 1)
                    return;
                pos--;
                aux = aux.Ant;
                TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
                TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
                TextView txthorario = (TextView) findViewById(R.cadastrados.txthorario);
                TextView txtdescricao = (TextView) findViewById(R.cadastrados.txtdescricao);
                TextView txtestilomusical = (TextView) findViewById (R.cadastrados.txtestilomusical);
                TextView txtprecoentr = (TextView) findViewById(R.cadastradas.txtprecoentr);

                txtnome.setText(aux.nome);
                txtendereco.setText(aux.endereco);
                txthorario.setText(aux.horario);
                txtdescricao.setText(aux.descricao);
                txtestilomusical.setText(aux.estilomusical);
                txtprecoentr.setText(aux.precoentr);

            }
        });

        btavancar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (pos == numreg)
                    return;
                pos++;
                aux = aux.Prox;
                TextView txtnome = (TextView) findViewById(R.cadastrados.txtnome);
                TextView txtendereco = (TextView) findViewById(R.cadastrados.txtendereco);
                TextView txthorario = (TextView) findViewById(R.cadastrados.txthorario);
                TextView txtdescricao= (TextView) findViewById(R.cadastrados.txtdescricao);
                TextView txtestilomusical = (TextView) findViewById(R.cadastrados.txtestilomusical);
                TextView txtprecoentr = (TextView) findViewById (R.cadastrados.txtprecoentr);

                txtnome.setText(aux.nome);
                txtendereco.setText(aux.endereco);
                txthorario.setText(aux.horario);
                txtdescricao.setText(aux.descricao);
                txtestilomusical.setText(aux.estilomusical);
                txtprecoentr.setText(aux.precoentr);

            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numreg = 0;
        pri = ult = null;
        CarregaTelaInicial();

    }

    public void showMessage(String Caption, Activity activity) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(activity);
        dialogo.setTitle("Atencao");
        dialogo.setMessage(Caption);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}