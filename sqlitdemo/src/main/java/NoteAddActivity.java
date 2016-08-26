import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.joke.sqlitdemo.R;
import com.joke.sqlitdemo.serviver.DBContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteAddActivity extends Activity {
	private EditText contentEt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    contentEt=(EditText)findViewById(R.id.editText1);
	    
	}
	public void onClick(View view){
		String content=contentEt.getText().toString();
		if(TextUtils.isEmpty(content)){
			contentEt.setError("内容不能为空");
			return;
		}
		DBContext dbContext=new DBContext(this);
		ContentValues cv=new ContentValues();
		cv.put("content", content);
		SimpleDateFormat sdf=
	    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cv.put("noteDate", sdf.format(new Date()));
		dbContext.insert(cv);
		Toast.makeText(this, "insert ok", Toast.LENGTH_LONG).show();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.note_add, menu);
		return true;
	}

}
