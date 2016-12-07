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
 * Created by Florian.BADENS on 07/12/2016.
 */

class AvisListeItemAdapter extends ArrayAdapter<AvisListeItem> {

    AvisListeItemAdapter(Context context, List<AvisListeItem> items) {
        super(context,0,items);
    }

    @NonNull
    public View getView (int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_liste_commentaire,parent,false);

        AvisListeItemAdapter.AvisListItemViewHolder viewHolder = (AvisListeItemAdapter.AvisListItemViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new AvisListeItemAdapter.AvisListItemViewHolder();
            viewHolder.username = (TextView) convertView.findViewById(R.id.username);
            viewHolder.commentaire = (TextView) convertView.findViewById(R.id.commentaire);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
        }

        AvisListeItem item = getItem(position);

        assert item != null;
        viewHolder.username.setText(item.getUsername());
        viewHolder.commentaire.setText(item.getCommentaire());
        viewHolder.avatar.setImageResource(item.getImage());
        return convertView;
    }

    private class AvisListItemViewHolder {
        TextView commentaire;
        TextView username;
        ImageView avatar;
    }
}
