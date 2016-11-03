package com.example.marianaleal.pap;

import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import org.w3c.dom.Text;

import java.util.List;

public class EventoArrayAdapter extends ArrayAdapter<Evento>{
    private Context context;
    private List<Evento> eventos;

    public EventoArrayAdapter(Context context, int resource, List<Evento> objects) {
        super(context, resource, objects);
        this.context = context;
        this.eventos = objects;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View linha = inflater.inflate(R.layout.evento, parent, false);
        TextView nome = (TextView) linha.findViewById(R.id.nome);
        TextView horario = (TextView) linha.findViewById(R.id.horario);
        TextView estiloMusical = (TextView) linha.findViewById(R.id.estilomusical);
        TextView valorEntrada = (TextView) linha.findViewById(R.id.valorentrada);
        TextView faixaEtaria = (TextView) linha.findViewById(R.id.faixaetaria);
        TextView descricao = (TextView) linha.findViewById(R.id.descricaoevento);
        ImageView foto = (ImageView) linha.findViewById(R.id.foto);

        Evento e = eventos.get(position);
        nome.setText(e.getNome());
        horario.setText(e.getHorario());
        estiloMusical.setText(e.getEstiloMusical());
        valorEntrada.setText(String.valueOf(e.getValorEntrada()));
        faixaEtaria.setText(e.getFaixaEtaria());
        descricao.setText(e.getDescricao());
        foto.setImageResource(e.getFoto());

        return linha;
    }

}
