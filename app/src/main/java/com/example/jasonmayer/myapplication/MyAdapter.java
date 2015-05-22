package com.example.jasonmayer.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Question> questionList;

    public MyAdapter(List<Question> questionList) {
        this.questionList = questionList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout layout;
        public TextView textView;
        private final CardView cardView;

        public ViewHolder(LinearLayout  v) {
            super(v);
            layout = v;
            cardView = (CardView) v.findViewById(R.id.card_view);
            textView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
        final String text = questionList.get(position).toString();
        holder.textView.setText(text);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDialog dialog = new AlertDialog.Builder(v.getContext())
                        .setView(R.layout.view_question)
                        .create();

                dialog.show();
                ((TextView) dialog.findViewById(R.id.question_text)).setText(text);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
