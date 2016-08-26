package com.joke.dbdemo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import static android.R.attr.id;

public class MainActivity extends Activity {
    private ToDoDb myToDoDb;
    private Cursor myCursor;
    private ListView myListView;
    private EditText myEditText;
    private int _id;
    protected final static int MENU_ADD = Menu.FIRST;
    protected final static int MENU_EDIT = Menu.FIRST + 1;
    protected final static int MENU_DELETE = Menu.FIRST + 2;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case MENU_ADD:
              this.addTodo();
                break;
            case MENU_EDIT:
                this.editTodo();
                break;
            case MENU_DELETE:
                this.deleteTodo();
                break;
        }
       return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = (ListView) this.findViewById(R.id.myListView);
        myEditText = (EditText) this.findViewById(R.id.myEditText);

        myToDoDb = new ToDoDb(this);
        //获取database里的数据
        myCursor = myToDoDb.select();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list, myCursor, new String[]
                {}, new int[]
                {R.id.listTextView1});
        myListView.setAdapter(adapter);

        //将listview添加到ONItemclicklistener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
                    {
	                /* 将myCursor移到所点击的值 */
                        myCursor.moveToPosition(arg2);
	             /* 取得字段_id的值 */
                        _id = myCursor.getInt(0);
	              /* 取得字段todo_text的值 */
                        myEditText.setText(myCursor.getString(1));
                    }

                });
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getselecteditem所取得的是sqlitecursor
                SQLiteCursor sc = (SQLiteCursor) parent.getSelectedItem();
                _id = sc.getInt(0);
                myEditText.setText(sc.getString(1));

            }

        });
    }
    private void addTodo(){
        if (myEditText.getText().toString().equals("")) {
            return;
        }
        //添加数据到数据库
        myToDoDb.insert(myEditText.getText().toString());
        //重新查询
        myCursor.requery();
        //重新整理mylistview
        myListView.invalidateViews();
        myEditText.setText("");
        _id = 0;

    }

    private void editTodo() {
        if (myEditText.getText().toString().equals("")) {
            return;
        }
        //修改数据
        myToDoDb.update(_id, myEditText.getText().toString());
        myCursor.requery();
        myListView.invalidateViews();
        myEditText.setText("");
        _id = 0;

    }

    private void deleteTodo() {
        if (id == 0) {
            return;
        }
        //删除数据
        myToDoDb.delete(_id);
        myCursor.requery();
        myListView.invalidateViews();
        myEditText.setText("");
        _id=0;

    }
}
