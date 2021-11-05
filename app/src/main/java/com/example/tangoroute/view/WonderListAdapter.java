package com.example.tangoroute.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;

import com.example.tangoroute.R;
import com.example.tangoroute.models.Situation;
import com.example.tangoroute.models.Wonder;

import java.util.List;

public class WonderListAdapter extends BaseAdapter {

    private final List<Wonder> wonders;
    protected Resources resources;
    protected Context context;
    private final LayoutInflater inflater;
    private int clickedCard;

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
        View view = this.inflater.inflate(R.layout.wonder_card_view_item, null);
        holder.imageViewItem = view.findViewById(R.id.imageViewItem);
        holder.imageViewItem.setImageDrawable(AppCompatResources
                .getDrawable(this.context, this.wonders.get(position).getImageId()));
        setTexts(view, holder, position);
        setButton(view, holder, position);
        view.setOnClickListener(v -> {
            clickedCard = position;
            notifyDataSetChanged();
        });
        return view;
    }

    private void setTexts(View view, WonderCardHolder holder, int position) {
        holder.tvItemName = view.findViewById(R.id.tvItemName);
        holder.tvItemName.setText(this.wonders.get(position).getName());
        Situation situation = this.wonders.get(position).getSituation();
        String generalDataText = situation.getCity() + "(" + situation.getCountry() + ")\n"
                + situation.getCoordinates().toString();
        holder.tvItemGeneralData = view.findViewById(R.id.tvItemGeneralData);
        holder.tvItemGeneralData.setText(generalDataText);
    }

    private void setButton(View view, WonderCardHolder holder, int position) {
        holder.buttonDetail = view.findViewById(R.id.buttonDetail);
        holder.buttonDetail.setOnClickListener(this::showDetail);
        if (this.clickedCard == position) {
            holder.buttonDetail.setEnabled(true);
            holder.buttonDetail.setAlpha(1f);
        } else {
            holder.buttonDetail.setEnabled(false);
            holder.buttonDetail.setAlpha(0.25f);
        }
    }

    private void showDetail(View view) {
        Intent intent = new Intent((MainActivity) context, DetailActivity.class);
        intent.putExtra(MainActivity.WONDER_BUNDLE_CODE, wonders.get(this.clickedCard));
        context.startActivity(intent);
    }

    public static class WonderCardHolder {

        ImageView imageViewItem;
        TextView tvItemName;
        TextView tvItemGeneralData;
        Button buttonDetail;

    }
}
