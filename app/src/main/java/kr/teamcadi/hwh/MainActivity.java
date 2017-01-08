package kr.teamcadi.hwh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView FriendListView = null;
    private FriendListViewAdapter friendListViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FriendListView = (ListView)findViewById(R.id.mList);
        friendListViewAdapter = new FriendListViewAdapter(this);
        FriendListView.setAdapter(friendListViewAdapter);

        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile), "정인교", "토사곰", null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile1), "홍영준","없을무",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "조민국","1월 18일 수강꾸러미",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "유재혁","뿌뿌뿌",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "장재현","숯",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "백선기","Enjoy or avoid",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "정민혁","이모티콘",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "이수진"," ",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "박광일",":)",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "배지은"," ",null);
        friendListViewAdapter.addItem(getResources().getDrawable(R.drawable.profile2), "박준기"," ",null); /*카톡 인원 리스트*/



        FriendListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Listdata mData = friendListViewAdapter.mListData.get(position);
                switch (position) /*각각 인원들의 경우의 수들*/
                {
                    case 0:
                        Intent goProfile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(goProfile);
                        finish();
                        break; /*첫번째 사진을 누를시 goProfile을 실행시켜라, goProfle은 ProfileActivity를 실행*/
                    case 1:
                        Toast.makeText(MainActivity.this, mData.myStateMsg, Toast.LENGTH_LONG).show();
                        break; /*내 상태메세지를 길게(LENGTH_LONG) 나타내라*/
                    case 2:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break; /*내 이름을 길게 나타내라*/
                    case 3:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 8:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 9:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                    case 10:
                        Toast.makeText(MainActivity.this, mData.myName, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    private class ViewHolder
    {
        public ImageView myProfile;
        public TextView myName;
        public ImageView state_bg;
        public TextView myStateMsg;
    }
    private class FriendListViewAdapter extends BaseAdapter
    {
        private Context mContext = null;
        private ArrayList<Listdata> mListData = new ArrayList<Listdata>();

        public FriendListViewAdapter(Context mContext)
        {
            super();
            this.mContext = mContext;
        }

        public int getCount()
        {
            return mListData.size();
        }

        public Object getItem(int position)
        {
            return mListData.get(position);
        }

        public long getItemId(int position)
        {
            return position;
        }
        public void addItem(Drawable myProfile, String myName, String myStateMsg, Drawable state_bg)
        {
            Listdata addInfo = null;
            addInfo = new Listdata();
            addInfo.myProfile = myProfile;
            addInfo.myName = myName;
            addInfo.myStateMsg = myStateMsg;
            addInfo.state_bg = state_bg;

            mListData.add(addInfo);
        }

        public void remove(int position)
        {
            mListData.remove(position);
            datachange();
        }

        public void datachange()
        {
            friendListViewAdapter.notifyDataSetChanged();
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder;
            if(convertView == null)
            {
                holder = new ViewHolder();

                LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_item, null);

                holder.myProfile=(ImageView) convertView.findViewById(R.id.myProfile);
                holder.myName = (TextView) convertView.findViewById(R.id.myName);
                holder.myStateMsg=(TextView) convertView.findViewById(R.id.myStateMsg);
                holder.state_bg=(ImageView) convertView.findViewById(R.id.state_bg);

                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            Listdata mData = mListData.get(position);

            if (mData.myProfile !=null)
            {
                holder.myProfile.setVisibility(View.VISIBLE);
                holder.myProfile.setImageDrawable(mData.myProfile);
            }
            else
            {
                holder.myProfile.setVisibility(View.VISIBLE);
            }

            holder.myName.setText(mData.myName);
            holder.myStateMsg.setText(mData.myStateMsg);

            return convertView;
        }
    }
}
