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
			case R.id.btn1://ȷ��ȡ���Ի���
				//1��ȡһ���Ի���Ĵ�����
				AlertDialog.Builder builder=new Builder(MainActivity.this);
				//2����builder����һЩ����
				builder.setTitle("�Ի������");
				builder.setMessage("��ʾ�Ƿ��˳�");
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "ȷ����ť�����",1).show();
					}
				});
				builder.setNeutralButton("ȡ��",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "ȡ����ť�����",1).show();
					}
				});
				
				builder.create().show();
				
				break;
			case R.id.btn2://pick�Ի���
				AlertDialog.Builder builder2=new Builder(MainActivity.this);
				builder2.setTitle("ѡ��һ����");
				final String[] arr=new String[]{"����","����","����"};
				builder2.setItems(arr, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, arr[which], 1).show();
					}
				}); 
				builder2.create().show();
				break;
			case R.id.btn3://��ѡ��ĵ�ѡ��ť�ĶԻ���
				
				AlertDialog.Builder builder3=new Builder(MainActivity.this);
				builder3.setTitle("ѡ��һ����ɫ");
				final String[] items=new String[]{"��ɫ","��ɫ","��ɫ"};
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
				builder4.setTitle("ѡ�����ɸ���ɫ");
				final String[] items4=new String[]{"��ɫ","��ɫ","��ɫ"};
				builder4.setMultiChoiceItems(items4, new boolean[]{false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						Toast.makeText(MainActivity.this, items4[which]+"ѡ��״̬"+isChecked, 1).show();
					}
				});
				builder4.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				dialog3=builder4.create();
				dialog3.show();
				break;
			case R.id.btn5://�������ĶԻ���
				ProgressDialog pd=new ProgressDialog(this);
				pd.setTitle("��ʾ");
				pd.setMessage("���ڼ����У����Ժ�...");
				pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//���ô���������
				pd.setMax(100);
				
				pd.show();
				pd.setProgress(50);
				break;
		}
	}
}

