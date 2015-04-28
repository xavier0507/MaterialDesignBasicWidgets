package com.example.materialdesignpractice;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Xavier on 2015/4/22.
 */
public class SampleActivity extends ActionBarActivity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private Toolbar toolbar;
	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_sample);

		this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		this.mDrawerList = (ListView) findViewById(R.id.navdrawer);
		this.toolbar = (Toolbar) findViewById(R.id.toolbar);

		if (toolbar != null) {
			setSupportActionBar(toolbar);
			toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
			toolbar.setLogo(R.drawable.ic_logo);
		}

		this.drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
		this.mDrawerLayout.setDrawerListener(drawerToggle);

		String[] values = new String[] {
				"DEFAULT", "RED", "BLUE", "MATERIAL GREY"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);
		this.mDrawerList.setAdapter(adapter);
		this.mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				switch (position) {
					case 0:
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.colorPinkPrimary));
						toolbar.setBackgroundColor(getResources().getColor(R.color.colorPinkPrimary));
						mDrawerLayout.closeDrawer(Gravity.START);
						break;
					case 1:
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.red));
						toolbar.setBackgroundColor(getResources().getColor(R.color.red));
						mDrawerLayout.closeDrawer(Gravity.START);

						break;
					case 2:
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.blue));
						toolbar.setBackgroundColor(getResources().getColor(R.color.blue));
						mDrawerLayout.closeDrawer(Gravity.START);

						break;
					case 3:
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
						toolbar.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
						mDrawerLayout.closeDrawer(Gravity.START);

						break;
				}
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		switch (item.getItemId()) {
			case android.R.id.home:
				mDrawerLayout.openDrawer(Gravity.START);
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

//	@Override
//	public void onConfigurationChanged(Configuration newConfig) {
//		super.onConfigurationChanged(newConfig);
//		drawerToggle.onConfigurationChanged(newConfig);
//	}
}
