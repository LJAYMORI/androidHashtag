package com.ljaymori.androidhashtag;

import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemView extends RecyclerView.ViewHolder {

    private TextView tvContent;

    public ItemView(View itemView) {
        super(itemView);

        tvContent = (TextView) itemView.findViewById(R.id.text_content_item);
    }

    public void setItemView(ItemData id) {
        tvContent.setText(id.getContent());

        Pattern tagMatcher = Pattern.compile("[#]+[ㄱ-ㅎㅏ-ㅣ가-힣A-Za-z0-9-_]+\\b");

        String newActivityURL = "hash://search";

        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "?" + SearchActivity.PARAM_KEYWORD + "=" + url.substring(1, url.length());
            }
        };

        Linkify.addLinks(tvContent, tagMatcher, newActivityURL, null, transform);

        URLSpanNoUnderline.stripUnderlines(tvContent);
    }




}
