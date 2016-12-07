package com.ihm.ihm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Florian.BADENS on 06/12/2016.
 */

class GererListeItemAdapter extends ArrayAdapter<GererListeItem> {

    GererListeItemAdapter(Context context, List<GererListeItem> items) {
        super(context,0,items);
    }

    @NonNull
    public View getView (int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_liste_gerer,parent,false);

        GererListeItemAdapter.GererListItemViewHolder viewHolder = (GererListeItemAdapter.GererListItemViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new GererListeItemAdapter.GererListItemViewHolder();
            viewHolder.artiste_present = (TextView) convertView.findViewById(R.id.artiste_present);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
        }

        GererListeItem item = getItem(position);



        assert item != null;
        viewHolder.artiste_present.setText(item.getArtiste());
        viewHolder.avatar.setImageResource(item.getImage());
        return convertView;


    }

    private class GererListItemViewHolder {
        TextView artiste_present;
        ImageView avatar;
    }
}
