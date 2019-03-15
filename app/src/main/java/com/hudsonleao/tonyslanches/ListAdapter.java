package com.hudsonleao.tonyslanches;

import android.content.Context;
import android.content.Intent;
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


public class ListAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final String [] ingre;
    private final String [] numbers;
    private final int [] images;

    public ListAdapter(Context context, String[] values, String[] ingre, String[] numbers, int[] images){
        this.context = context;
        this.values = values;
        this.ingre = ingre;
        this.numbers = numbers;
        this.images = images;
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
            convertView = inflater.inflate(R.layout.activity_single_list_item, parent, false);
            viewHolder.Sanduichetxt = (TextView) convertView.findViewById(R.id.Sanduiche);
            viewHolder.Ingredientestxt = (TextView) convertView.findViewById(R.id.Ingredientes);
            viewHolder.Valortxt = (TextView) convertView.findViewById(R.id.Valor);
            viewHolder.iconeimg = (ImageView) convertView.findViewById(R.id.Icone);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.Sanduichetxt.setText(values[position]);
        viewHolder.Ingredientestxt.setText("Ingredientes: "+ingre[position]);
        viewHolder.Valortxt.setText("Valor: R$"+numbers[position]);
        viewHolder.iconeimg.setImageResource(images[position]);

        return convertView;
    }

    private static class ViewHolder {

        TextView Sanduichetxt;
        TextView Ingredientestxt;
        TextView Valortxt;
        ImageView iconeimg;

    }


}
