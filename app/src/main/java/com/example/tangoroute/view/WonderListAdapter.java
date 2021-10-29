package com.example.tangoroute.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tangoroute.R;
import com.example.tangoroute.models.Location;
import com.example.tangoroute.models.Wonder;

import java.util.List;

public class WonderListAdapter extends BaseAdapter {

    private List<Wonder> wonders;
    protected Resources resources;
    protected Context context;
    private static LayoutInflater inflater;

    public WonderListAdapter(List<Wonder> wonders, Resources resources, Context context) {
        this.wonders = wonders;
        this.resources = resources;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.wonders.size();
    }

    @Override
    public Wonder getItem(int position) {
        return this.wonders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WonderCardHolder holder = new WonderCardHolder();
        View view = inflater.inflate(R.layout.card_view_item, null);
        holder.imageViewItem = view.findViewById(R.id.imageViewItem);
        // TO-DO poner imagenes
        holder.tvItemName = view.findViewById(R.id.tvItemName);
        holder.tvItemName.setText(this.wonders.get(position).getName());
        setGeneralDataText(view, holder, position);
        // TO-DO botón detalle
        return view;
    }

    private void setGeneralDataText(View view, WonderCardHolder holder, int position) {
        Location location = this.wonders.get(position).getLocation();
        String generalDataText = location.getCity() + "(" + location.getCountry() + ")\n"
                + location.getCoordinates().toString();
        holder.tvItemGeneralData = view.findViewById(R.id.tvItemGeneralData);
        holder.tvItemGeneralData.setText(generalDataText);
    }

    public class WonderCardHolder {

        ImageView imageViewItem;
        TextView tvItemName;
        TextView tvItemGeneralData;
        Button buttonDetail;

    }
}
