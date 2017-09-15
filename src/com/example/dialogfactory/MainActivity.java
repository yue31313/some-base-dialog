package com.example.dialogfactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private AlertDialog dialog3;
	private Button btn1,btn2,btn3,btn4,btn5;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findView();
		init();
	}
	
	private void init() {
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
	}
	private void findView() {
		btn1=(Button)this.findViewById(R.id.btn1);
		btn2=(Button)this.findViewById(R.id.btn2);
		btn3=(Button)this.findViewById(R.id.btn3);
		btn4=(Button)this.findViewById(R.id.btn4);
		btn5=(Button)this.findViewById(R.id.btn5);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn1://确定取消对话框
				//1获取一个对话框的创建器
				AlertDialog.Builder builder=new Builder(MainActivity.this);
				//2所有builder设置一些参数
				builder.setTitle("对话框标题");
				builder.setMessage("提示是否退出");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "确定按钮被点击",1).show();
					}
				});
				builder.setNeutralButton("取消",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "取消按钮被点击",1).show();
					}
				});
				
				builder.create().show();
				
				break;
			case R.id.btn2://pick对话框
				AlertDialog.Builder builder2=new Builder(MainActivity.this);
				builder2.setTitle("选择一个人");
				final String[] arr=new String[]{"张三","李四","王五"};
				builder2.setItems(arr, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, arr[which], 1).show();
					}
				}); 
				builder2.create().show();
				break;
			case R.id.btn3://带选择的单选按钮的对话框
				
				AlertDialog.Builder builder3=new Builder(MainActivity.this);
				builder3.setTitle("选择一个颜色");
				final String[] items=new String[]{"蓝色","黄色","红色"};
				builder3.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, items[which], 1).show();
					}
				});
				
				builder3.create().show();
				dialog3.dismiss();
				break;
			case R.id.btn4:
				
				AlertDialog.Builder builder4=new Builder(MainActivity.this);
				builder4.setTitle("选择若干个颜色");
				final String[] items4=new String[]{"蓝色","黄色","红色"};
				builder4.setMultiChoiceItems(items4, new boolean[]{false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						Toast.makeText(MainActivity.this, items4[which]+"选择状态"+isChecked, 1).show();
					}
				});
				builder4.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				dialog3=builder4.create();
				dialog3.show();
				break;
			case R.id.btn5://进度条的对话框
				ProgressDialog pd=new ProgressDialog(this);
				pd.setTitle("提示");
				pd.setMessage("正在加载中，请稍后...");
				pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置带进度条的
				pd.setMax(100);
				
				pd.show();
				pd.setProgress(50);
				break;
		}
	}
}

