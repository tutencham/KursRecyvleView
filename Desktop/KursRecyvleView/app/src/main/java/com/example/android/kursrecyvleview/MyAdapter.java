package com.example.android.kursrecyvleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Grzesiek on 2017-07-27.
 */

class MyAdapter extends RecyclerView.Adapter {

    private ArrayList<Article> mArticles =new ArrayList<>();

    private RecyclerView mRecyclerView;


    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public TextView mContent;


        public MyViewHolder(View pItem) {
            super(pItem);
            mTitle = (TextView) pItem.findViewById(R.id.article_title);
            mContent = (TextView) pItem.findViewById(R.id.article_subtitle);


        }
    }


    public MyAdapter(ArrayList<Article> pArticles, RecyclerView pRecyclerView) {
        this.mArticles = pArticles;
        this.mRecyclerView = pRecyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i){

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_layout,viewGroup,false);
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                int positionToDelete = mRecyclerView.getChildAdapterPosition(v);

                mArticles.remove(positionToDelete);
                notifyItemRemoved(positionToDelete);
            }


        });

        return new MyViewHolder(view);




    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,final int i){

Article article= mArticles.get(i);
        ((MyViewHolder)viewHolder).mTitle.setText(article.getTitle());
        ((MyViewHolder)viewHolder).mContent.setText(article.getContent());

    }
@Override
    public int getItemCount(){
    return mArticles.size();
}









}
