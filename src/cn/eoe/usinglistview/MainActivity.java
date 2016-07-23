package cn.eoe.usinglistview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	
	
	private ListView lv;
	private ArrayAdapter<ListCellData> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ArrayAdapter<ListCellData>(this, android.R.layout.simple_list_item_1);
//		adapter = new ArrayAdapter<String>(this, R.layout.list_cell);
		
		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(adapter);
		
		
		adapter.add(new ListCellData("小明", "男", 17));
		adapter.add(new ListCellData("小丽", "女", 15));
		
//		adapter.add("Hello");
//		adapter.add("eoe");
		
		lv.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		ListCellData data = adapter.getItem(position);
		
		Toast.makeText(this, String.format("名字：%s，性别：%s，年龄：%d", data.getUserName(),data.getSex(),data.getAge()), Toast.LENGTH_SHORT).show();
	}

}
