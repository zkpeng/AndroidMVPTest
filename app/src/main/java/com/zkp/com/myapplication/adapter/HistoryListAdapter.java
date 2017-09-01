package com.zkp.com.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zkp.com.myapplication.R;
import com.zkp.com.myapplication.bean.HistoryListItemBean;
import com.zkp.com.myapplication.bean.ResultBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 历史上的今天列表适配器
 *
 * @author ZKP
 *         created at:2017/7/19 13:42
 */
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {

    private static List<ResultBean> historyDatas;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ResultBean resultBean);
    }

    public HistoryListAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        historyDatas = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ResultBean historyListItemBean = historyDatas.get(position);
        viewHolder.tvTitle.setText(historyListItemBean.getTitle());
        viewHolder.tvContent.setText(historyListItemBean.getEvent());
        viewHolder.viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(historyDatas.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyDatas == null ? 0 : historyDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View viewItem;
        public TextView tvTitle;
        public TextView tvContent;

        public ViewHolder(View view) {
            super(view);
            viewItem = view.findViewById(R.id.list_item);
            tvTitle = (TextView) view.findViewById(R.id.history_title);
            tvContent = (TextView) view.findViewById(R.id.history_content);
        }
    }

    public void refreshValues(List<ResultBean> datas) {
        this.historyDatas = datas;
        notifyDataSetChanged();
    }
}
   