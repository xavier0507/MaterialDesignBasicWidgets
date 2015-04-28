package com.example.materialdesignpractice;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.materialdesignpractice.adapters.ItemData;
import com.example.materialdesignpractice.adapters.MyAdapter;

/**
 * Created by Xavier on 2015/4/24.
 */
public class RecyclerViewActivity extends ActionBarActivity implements android.support.v7.widget.Toolbar.OnMenuItemClickListener {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private Toolbar toolbar;
	private ActionBarDrawerToggle drawerToggle;
	private Window window;

	private RecyclerView mRecyclerView;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager mLayoutManager;

	private ScrollView scrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_recyclerview);

		this.mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);
		this.mDrawerList = (ListView) this.findViewById(R.id.navdrawer);
		this.toolbar = (Toolbar) this.findViewById(R.id.toolbar);

		this.mRecyclerView = (RecyclerView) this.findViewById(R.id.my_recycler_view);
		this.scrollView = (ScrollView) this.findViewById(R.id.my_card_view);

		if (toolbar != null) {
			this.setSupportActionBar(toolbar);
			this.toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
			this.toolbar.setSubtitle("Simple sample");
			this.toolbar.setOnMenuItemClickListener(this);
		}

		this.drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
		this.drawerToggle.syncState();
		this.mDrawerLayout.setDrawerListener(drawerToggle);
		this.setDrawerListData();

		this.mRecyclerView.setHasFixedSize(true);
		this.mLayoutManager = new LinearLayoutManager(this);
		this.mRecyclerView.setLayoutManager(mLayoutManager);

		this.mAdapter = new MyAdapter(this.getItemDatas());
		this.mRecyclerView.setAdapter(this.mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.menu_recyclerview, menu);
		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_add:
				this.mRecyclerView.setVisibility(View.VISIBLE);
				this.scrollView.setVisibility(View.GONE);
				break;

			case R.id.action_del:
				this.mRecyclerView.setVisibility(View.GONE);
				this.scrollView.setVisibility(View.VISIBLE);
				break;
		}

		return true;
	}

	private void setDrawerListData() {
		String[] values = new String[] {
				"DEFAULT", "RED", "BLUE", "GREEN"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		this.window = getWindow();
		this.mDrawerList.setAdapter(adapter);
		this.mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				switch (position) {
					case 0:
						window.setStatusBarColor(getResources().getColor(R.color.colorListDefaultPrimaryDark));
						window.setNavigationBarColor(getResources().getColor(R.color.colorListDefaultPrimaryDark));
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.colorListDefaultPrimary));
						toolbar.setBackgroundColor(getResources().getColor(R.color.colorListDefaultPrimary));
						mDrawerLayout.closeDrawer(Gravity.START);
						break;
					case 1:
						window.setStatusBarColor(getResources().getColor(R.color.colorListRedPrimaryDark));
						window.setNavigationBarColor(getResources().getColor(R.color.colorListRedPrimaryDark));
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.colorListRedPrimary));
						toolbar.setBackgroundColor(getResources().getColor(R.color.colorListRedPrimary));
						mDrawerLayout.closeDrawer(Gravity.START);
						break;
					case 2:
						window.setStatusBarColor(getResources().getColor(R.color.colorListBluePrimaryDark));
						window.setNavigationBarColor(getResources().getColor(R.color.colorListBluePrimaryDark));
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.colorListBluePrimary));
						toolbar.setBackgroundColor(getResources().getColor(R.color.colorListBluePrimary));
						mDrawerLayout.closeDrawer(Gravity.START);
						break;
					case 3:
						window.setStatusBarColor(getResources().getColor(R.color.colorListGreenPrimaryDark));
						window.setNavigationBarColor(getResources().getColor(R.color.colorListGreenPrimaryDark));
						mDrawerList.setBackgroundColor(getResources().getColor(R.color.colorListGreenPrimary));
						toolbar.setBackgroundColor(getResources().getColor(R.color.colorListGreenPrimary));
						mDrawerLayout.closeDrawer(Gravity.START);
						break;
				}
			}
		});
	}

	private ItemData[] getItemDatas() {
		ItemData[] itemDatas = new ItemData[15];
		for (int i = 0; i < itemDatas.length; i++) {
			ItemData itemData = new ItemData();
			itemData.setTopContent("All Connors");
			itemData.setMidContent("Brunch this weekend?");
			itemData.setBottomContent("I'll be in your neighborhood doing.........");
			itemDatas[i] = itemData;
		}

		return itemDatas;
	}
}
