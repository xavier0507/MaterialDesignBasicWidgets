package com.example.materialdesignpractice.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.materialdesignpractice.R;

/**
 * Created by Xavier on 2015/4/24.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	private ItemData[] itemsData;

	public MyAdapter(ItemData[] itemsData) {
		this.itemsData = itemsData;
	}

	@Override
	public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
		View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
		ViewHolder viewHolder = new ViewHolder(itemLayoutView);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.topContentTextView.setText(this.itemsData[position].getTopContent());
		holder.midContentTextView.setText(this.itemsData[position].getMidContent());
		holder.bottomContentTextView.setText(this.itemsData[position].getBottomContent());
	}

	@Override
	public int getItemCount() {
		return this.itemsData.length;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		public TextView topContentTextView;
		public TextView midContentTextView;
		public TextView bottomContentTextView;

		public ViewHolder(View view) {
			super(view);
			view.setOnClickListener(this);
			this.topContentTextView = (TextView) view.findViewById(R.id.text_top_content);
			this.midContentTextView = (TextView) view.findViewById(R.id.text_mid_content);
			this.bottomContentTextView = (TextView) view.findViewById(R.id.text_bottom_content);
		}

		@Override
		public void onClick(View v) {
			Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_LONG).show();
		}
	}
}
