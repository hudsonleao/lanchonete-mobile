package com.hudsonleao.tonyslanches;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class listaHistorico extends BaseAdapter {

    Context context;
    private final String [] values;
    private final String [] data;
    private final String [] numbers;

    public listaHistorico(Context context, String [] values, String [] data, String [] numbers){
        this.context = context;
        this.values = values;
        this.data = data;
        this.numbers = numbers;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listahistorico, parent, false);
            viewHolder.Sanduichetxt = (TextView) convertView.findViewById(R.id.Sandu);
            viewHolder.Ingredientestxt = (TextView) convertView.findViewById(R.id.Ing);
            viewHolder.Valortxt = (TextView) convertView.findViewById(R.id.Val);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.Sanduichetxt.setText(values[position]);
        viewHolder.Ingredientestxt.setText("Data: "+data[position]);
        viewHolder.Valortxt.setText("Valor: "+numbers[position]);

        return convertView;
    }

    private static class ViewHolder {

        TextView Sanduichetxt;
        TextView Ingredientestxt;
        TextView Valortxt;

    }

}
