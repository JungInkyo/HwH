package kr.teamcadi.hwh;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

import static kr.teamcadi.hwh.R.id.mData;


/**
 * Created by WIN8 on 2016-12-25.
 */

public class chatting extends Activity {
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatactivity_main); /*activity_main을 채팅것으로 불러올것*/

        mListView = (ListView) findViewById(R.id.mList);
        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText ed = (EditText) findViewById(R.id.etxt_message);
                String text = ed.getText().toString();

                if (text.length() != 0) {
                    Calendar calendar = Calendar.getInstance();
                    mAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher),
                            text,

                            calendar.get(Calendar.HOUR) + " : "
                                    + calendar.get(Calendar.MINUTE) + " : "
                                    + calendar.get(Calendar.SECOND), "정인교"); /*시간 분 초 표시*/
                    ed.setText("");
                    mAdapter.dataChange();
                }

            }
        });
    }


    class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mData;
        public TextView mName;
    }

    public class ListViewAdapter extends BaseAdapter
    {
        private Context c = null;
        private ArrayList<chatListData> mListData = new ArrayList<chatListData>();

        public ListViewAdapter(Context c) {
            super();
            this.c = c;
        }

        public int getCount() {
            return mListData.size();
        }

        public Object getItem(int position) {
            return mListData.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertVeiw, ViewGroup parent) {
            ViewHolder holder;

            if (convertVeiw == null)
            {
                holder = new ViewHolder();

                LayoutInflater inflater =
                        (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertVeiw = inflater.inflate(R.layout.chatlistview_item, null);

                holder.mIcon = (ImageView) convertVeiw.findViewById(R.id.mIage);
                holder.mText = (TextView) convertVeiw.findViewById(R.id.mText);
                holder.mData = (TextView) convertVeiw.findViewById(mData);
                holder.mName = (TextView) convertVeiw.findViewById(R.id.mName);

                convertVeiw.setTag(holder);
            } else {
                holder = (ViewHolder) convertVeiw.getTag();
            }

            chatListData mData = mListData.get(position);
            if (mData.mIcon != null) {
                holder.mIcon.setVisibility(View.VISIBLE);
            } else {
                holder.mIcon.setVisibility(View.GONE);
            }
            holder.mText.setText(mData.mTitle);
            holder.mData.setText(mData.mData);
            holder.mName.setText(mData.mName);

            return convertVeiw;
        }

        public void addItem(Drawable icon, String mTitle, String mData, String mName) {
            chatListData addInfo = null;
            addInfo = new chatListData();

            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mData = mData;
            addInfo.mName = mName;

            mListData.add(addInfo);
        }

        public void dataChange() {
            mAdapter.notifyDataSetChanged();
        }

    }
}