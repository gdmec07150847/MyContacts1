package cn.edu.gdmec.a07150847.mycontacts;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by asus on 2016/11/16.
 */
public class FndDialog extends Dialog{

    private Context l_context;
    public FndDialog(Context context) {
        super(context);
        l_context=context;

    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        setTitle("查询联系人");
        final Button find = (Button) findViewById(R.id.find);
        Button calcel = (Button) findViewById(R.id.cancel);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText value = (EditText) findViewById(R.id.value);
                ContactsTable ct = new ContactsTable(l_context);
                User[] users = ct.findUserByKey(value.getText().toString());

                for (int i=0;i<users.length;i++){
                    System.out.println("姓名:"+users[i].getName()+",电话:"+users[i].getMobile());
                }
                ((MainActivity)l_context).setUsers(users);
                ((MainActivity)l_context).getListViewAdapter().notifyDataSetChanged();
                ((MainActivity)l_context).setSelectItem(0);
                dismiss();

            }

        });
        calcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


}
