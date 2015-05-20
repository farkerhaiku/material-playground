package com.example.jasonmayer.myapplication;

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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layout;
        public TextView textView;

        public ViewHolder(LinearLayout  v) {
            super(v);
            layout = v;
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

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.textView.setText(questionList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}
