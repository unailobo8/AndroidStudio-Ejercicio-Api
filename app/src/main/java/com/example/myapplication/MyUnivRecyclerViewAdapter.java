package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentItemBinding;
import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUnivRecyclerViewAdapter extends RecyclerView.Adapter<MyUnivRecyclerViewAdapter.ViewHolder> {

    private final List<Universidad> mValues;

    public MyUnivRecyclerViewAdapter(List<Universidad> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNombre());
        holder.mContentView.setText("Ver");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mIdView;
        public final Button mContentView;
        public Universidad mItem;

    public ViewHolder(FragmentItemBinding binding) {
      super(binding.getRoot());
      mIdView = binding.itemNumber;
      mContentView = binding.button;
      mContentView.setOnClickListener(this);
    }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.newInstance(mItem.getpWeb());
            ((FragmentActivity) view.getContext()).getFragmentManager().beginTransaction()
                    .replace(R.id.listFragment, webViewFragment)
                    .commit();
        }
    }
}