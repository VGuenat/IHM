package com.ihm.ihm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vincent on 05/12/2016.
 * Sert d'adapter pour la ListView. DOIT ÊTRE MODIFIÉ POUR PRENDRE EN COMPTE LES 2 LISTES SUR LA
 * MÊME PAGE !
 */

class ConcertListeItemAdapter extends ArrayAdapter<ConcertListeItem> {

    ConcertListeItemAdapter(Context context, List<ConcertListeItem> items) {
        super(context,0,items);
    }

    @NonNull
    public View getView (int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_liste,parent,false);

        ConcertListItemViewHolder viewHolder = (ConcertListItemViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new ConcertListItemViewHolder();
            viewHolder.artiste_present = (TextView) convertView.findViewById(R.id.artiste_present);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.titre = (TextView) convertView.findViewById(R.id.titre);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
        }

        ConcertListeItem item = getItem(position);

        assert item != null;
        viewHolder.artiste_present.setText(item.getArtiste());
        viewHolder.date.setText(item.getDate());
        viewHolder.titre.setText(item.getDescription());
        viewHolder.avatar.setImageResource(item.getImage());

        return convertView;
    }

    private class ConcertListItemViewHolder {
        TextView artiste_present;
        TextView date;
        TextView titre;
        ImageView avatar;
    }
}
