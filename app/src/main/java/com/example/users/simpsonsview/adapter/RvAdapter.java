package com.example.users.simpsonsview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.users.simpsonsview.activities.SimpsonsActivity;
import com.example.users.simpsonsview.model.Simpson;
import com.example.users.simpsonsview.R;
//import com.example.users.simpsonsview.activities.
//import com.demotxt.myapp.myapplication.activities.AnimeDetail;
import java.util.List;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    RequestOptions options ;
    private Context mContext ;
    private List<Simpson> mData ;


    public RvAdapter(Context mContext, List lst) {


        this.mContext = mContext;
        this.mData = lst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.simpson_row_item,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, SimpsonsActivity.class);

                i.putExtra("simpson_character",mData.get(viewHolder.getAdapterPosition()).getCharacter());
                i.putExtra("simpson_quote",mData.get(viewHolder.getAdapterPosition()).getQuote());
                i.putExtra("simpson_img",mData.get(viewHolder.getAdapterPosition()).getImage());

                mContext.startActivity(i);
            }



        });


        // click listener here
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {


        holder.IVThumbnail.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        holder.tvname.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        holder.tvquote.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        holder.tvname.setText(mData.get(position).getCharacter());
        holder.tvquote.setText(mData.get(position).getQuote());


        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getImage()).apply(options).into(holder.IVThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tvquote;
        ImageView IVThumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tvname = itemView.findViewById(R.id.simpson_character);
            tvquote = itemView.findViewById(R.id.simpson_quote);
            IVThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }


}
