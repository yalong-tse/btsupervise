package com.dreaming.btsupervise.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.dreaming.btsupervise.net.TaskObserver;

public abstract class TaskActivity extends Activity
  implements TaskObserver
{
  protected ProgressDialog progressDialog;

  protected void closeAlertDialog()
  {
    if ((this.progressDialog != null) && (this.progressDialog.isShowing()))
      this.progressDialog.dismiss();
  }

  public void closeInput()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
  }

  public ProgressDialog getProgressDialog()
  {
    return this.progressDialog;
  }

  public boolean isInputOpen()
  {
    return ((InputMethodManager)getSystemService("input_method")).isActive();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.progressDialog = new ProgressDialog(this);
  }

  public void openInput(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(paramView, 2);
  }
}