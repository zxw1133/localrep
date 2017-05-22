package w.x.z.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 123456 on 2017/5/22.
 */
public class Myfragment extends Fragment {

    private int position;

    public static Fragment newinstance(int position){
        Bundle b=new Bundle();
        b.putInt("index",position);
        Myfragment myfragment = new Myfragment();
        myfragment.setArguments(b);
        return myfragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = (int) getArguments().get("index");
        Log.e("position1",position+"");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.content, container,false);
        Log.e("position2",position+"");
        TextView tv= (TextView) inflate.findViewById(R.id.tv);
        tv.setText("page"+position);

        return inflate;
    }
}
