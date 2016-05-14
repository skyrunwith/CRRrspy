package com.youngheart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.youngheart.R;
import com.youngheart.entity.ProductComment;

import org.w3c.dom.Comment;

import java.util.List;

/**
 * Created by Administrator on 2016/4/24.
 */
public class CommentAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<ProductComment> productCommentList;

    public List<ProductComment> getProductCommentList() {
        return productCommentList;
    }

    public void setProductCommentList(List<ProductComment> productCommentList) {
        this.productCommentList = productCommentList;
    }

    public CommentAdapter(Context context, List<ProductComment> productCommentList){
        this.mInflater = LayoutInflater.from(context);
        this.productCommentList = productCommentList;
    }

    @Override
    public int getCount() {
        if(productCommentList != null){
            return productCommentList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.item_comment, null);
            holder.comment_TextView = (TextView) convertView.findViewById(R.id.comment);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.comment_TextView.setText(productCommentList.get(position).getUserip() + productCommentList.get(position).getContent() +
                    "{" + productCommentList.get(position).getCommentdate() + "}");
        return convertView;
    }

    public final class ViewHolder {
        public TextView comment_TextView;
    }
}
