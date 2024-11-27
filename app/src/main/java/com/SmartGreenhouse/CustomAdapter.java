package com.SmartGreenhouse;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;public class CustomAdapter extends ArrayAdapter<ListItem> {

    private int resource;

    public CustomAdapter(Context context, int resource, List<ListItem> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Réutilisation de la vue pour de meilleures performances
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        // Obtenir l'élément actuel
        ListItem currentItem = getItem(position);

        // Initialiser les composants
        ImageView itemImage = convertView.findViewById(R.id.itemImage);
        TextView itemText = convertView.findViewById(R.id.itemValue);

        // Mise à jour des vues avec les données
        if (currentItem != null) {
            itemImage.setImageResource(currentItem.getImageResId());
            itemText.setText(currentItem.getText());
        }

        return convertView;
    }
}
