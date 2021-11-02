package com.example.tangoroute.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tangoroute.R;
import com.example.tangoroute.pojo.AirportList;
import com.example.tangoroute.pojo.Item;

import java.util.List;

public class AirportListAdapter extends BaseAdapter {

    private final AirportList airports;
    protected Resources resources;
    protected Context context;
    private final LayoutInflater inflater;

    public AirportListAdapter(AirportList airports, Resources resources, Context context) {
        this.airports = airports;
        this.resources = resources;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.airports.getItems().size();
    }

    @Override
    public Item getItem(int position) {
        return this.airports.getItems().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AirportCardHolder holder = new AirportCardHolder();
        View view = this.inflater.inflate(R.layout.wonder_card_view_item, null);
        setTexts(view, holder, position);
        return view;
    }

    private void setTexts(View view, AirportCardHolder holder, int position) {
        List<Item> items = this.airports.getItems();
        AirportActivity activity = (AirportActivity) this.context;
        holder.tvItemName = view.findViewById(R.id.tvItemName);
        holder.tvItemName.setText(items.get(position).getShortName());
        holder.tvItemCity = view.findViewById(R.id.tvItemCity);
        holder.tvItemCity.setText(items.get(position).getMunicipalityName());
        holder.tvItemIata = view.findViewById(R.id.tvItemIata);
        holder.tvItemIata.setText(this.resources.getString(R.string.iata_code)
                + " " + items.get(position).getName());
        holder.tvItemIcao = view.findViewById(R.id.tvItemIcao);
        holder.tvItemIcao.setText(this.resources.getString(R.string.icao_code)
                + " " + items.get(position).getName());
        holder.tvItemLocation = view.findViewById(R.id.tvItemLocation);
        holder.tvItemLocation.setText(items.get(position).getLocation().getLat()
                + ", " + items.get(position).getLocation().getLat());
        holder.tvItemDistance = view.findViewById(R.id.tvItemName);
        holder.tvItemDistance
                .setText(activity.getDistanceToWonder(items.get(position).getLocation()));
    }

    public static class AirportCardHolder {

        TextView tvItemName;
        TextView tvItemCity;
        TextView tvItemIata;
        TextView tvItemIcao;
        TextView tvItemLocation;
        TextView tvItemDistance;

    }
}
