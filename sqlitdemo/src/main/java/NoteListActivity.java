import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.SimpleCursorAdapter;

import com.joke.sqlitdemo.R;
import com.joke.sqlitdemo.serviver.DBContext;

public class NoteListActivity extends Activity implements OnQueryTextListener {
    //private ArrayAdapter<String> adapter;
    private SimpleCursorAdapter adapter;
    private DBContext dbContext;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dbContext = new DBContext(this);
        c = dbContext.rawQuery();
        adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                c,
                new String[]{"content", "noteDate"},
                new int[]{android.R.id.text1, android.R.id.text2},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        adapter.setFilterQueryProvider(
                new FilterQueryProvider() {
                    //������adapter.getFilter().filter(newText)�˷���ʱ
                    //��ִ�����·���
                    @Override
                    public Cursor runQuery(CharSequence constraint) {
                        Log.i("TAG", "constraint=" + constraint);
                        return
                                dbContext.rawFilterQuery(constraint.toString());
                    }
                });
        ListView lsv = (ListView) findViewById(R.id.listView1);
        lsv.setAdapter(adapter);
        registerForContextMenu(lsv);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "onRestart()");
        Cursor c = dbContext.rawQuery();
        adapter.swapCursor(c);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(
                R.menu.ctxmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(
            MenuItem item) {
        Log.i("TAG", "menuIfo=" +
                item.getMenuInfo());//AdapterContextMenuInfo
        AdapterContextMenuInfo mInfo =
                (AdapterContextMenuInfo) item.getMenuInfo();
        int pos = mInfo.position;
        Log.i("TAG", "pos=" + pos);
        Cursor c = (Cursor) adapter.getItem(pos);
        Log.i("TAG", "c=" + c);
        int idIndex = c.getColumnIndex("_id");
        Log.i("TAG", "c.getInt(idIndex)=" + c.getInt(idIndex));

        switch (item.getItemId()) {
            case R.id.noteDel:
                dbContext.delete(c.getInt(idIndex));
                Cursor cur = dbContext.rawQuery();
                adapter.swapCursor(cur);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater()
                .inflate(R.menu.note_list, menu);
        MenuItem item = menu.findItem(R.id.noteSearch);
        SearchView searchView =
                (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.noteAdd:
                Intent intent =
                        new Intent(this,
                                NoteAddActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (!TextUtils.isEmpty(newText)) {
            adapter.getFilter().filter(newText);
        } else {
            adapter.getFilter().filter("");
        }
        Log.i("TAG", "newText=" + newText);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
