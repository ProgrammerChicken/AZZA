package nghialt.demo.demosqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

	SQLiteDatabase database;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		MySQLiteHelper helper = new MySQLiteHelper(this);
		database = helper.getWritableDatabase();

//		String sql = "SELECT * FROM " + MySQLiteHelper.TABLE_NAME + " WHERE "
//				+ MySQLiteHelper.COL_ID + "=? OR " + MySQLiteHelper.COL_ID
//				+ "=?";
		String sql = "SELECT * FROM " + MySQLiteHelper.TABLE_NAME;
		//String[] selectionArgs = { "3", "1" };
		
		Cursor cursor = database.rawQuery(sql,null);
		//Cursor cursor = database.rawQuery(sql, selectionArgs);
		Log.d("do", "Cursor");
		if (cursor.moveToFirst()) {
			Log.d("do", "Have DB");
			while (!cursor.isAfterLast()) {
				long id = cursor.getLong(cursor
						.getColumnIndex(MySQLiteHelper.COL_ID));
				String enName = cursor.getString(cursor
						.getColumnIndex(MySQLiteHelper.COL_EN_NAME));
				Log.d("do", id + " - " + enName);
				cursor.moveToNext();
			}
		}

	}
}