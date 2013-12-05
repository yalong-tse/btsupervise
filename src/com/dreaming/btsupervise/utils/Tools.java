package com.dreaming.btsupervise.utils;
//
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Bitmap.CompressFormat;
//import android.graphics.Bitmap.Config;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Matrix;
//import android.graphics.drawable.Drawable;
//import android.media.SoundPool;
//import android.os.Environment;
//import android.text.TextPaint;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.UUID;
//
public class Tools
{
//  public static byte[] Bitmap2Bytes(Bitmap paramBitmap)
//  {
//    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
//    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
//    return localByteArrayOutputStream.toByteArray();
//  }
//
//  public static Bitmap Bytes2Bimap(byte[] paramArrayOfByte)
//  {
//    if (paramArrayOfByte.length != 0);
//    for (Bitmap localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length); ; localBitmap = null)
//      return localBitmap;
//  }
//
//  public static Bitmap ResizeBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
//  {
//    if (paramBitmap == null);
//    while (true)
//    {
//      return paramBitmap;
//      int i = paramBitmap.getWidth();
//      int j = paramBitmap.getHeight();
//      float f1 = paramInt1 / i;
//      float f2 = paramInt2 / j;
//      Matrix localMatrix = new Matrix();
//      localMatrix.postScale(f1, f2);
//      Object localObject = null;
//      Bitmap localBitmap1 = paramBitmap;
//      try
//      {
//        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, i, j, localMatrix, true);
//        localObject = localBitmap2;
//        //paramBitmap = localObject;
//      }
//      catch (Exception localException)
//      {
//        while (true)
//          localException.printStackTrace();
//      }
//    }
//  }
//
//  public static void copyFile(File paramFile1, File paramFile2, Boolean paramBoolean)
//  {
//    if (!paramFile1.exists())
//      return;
//    if ((paramFile1.isFile()) && (paramFile1.canRead()))
//    {
//      if (!paramFile2.getParentFile().exists())
//        paramFile2.getParentFile().mkdirs();
//      if ((paramFile2.exists()) && (paramBoolean.booleanValue()))
//        paramFile2.delete();
//    }
//    while (true)
//    {
//      FileOutputStream localFileOutputStream;
//      byte[] arrayOfByte;
//      int i;
//      try
//      {
//        FileInputStream localFileInputStream = new FileInputStream(paramFile1);
//        localFileOutputStream = new FileOutputStream(paramFile2);
//        arrayOfByte = new byte[1024];
//        i = localFileInputStream.read(arrayOfByte);
//        if (i > 0)
//          break;
//        localFileInputStream.close();
//        localFileOutputStream.close();
//      }
//      catch (Exception localException)
//      {
//        Log.e("readfile", localException.getMessage());
//      }
//      localFileOutputStream.write(arrayOfByte, 0, i);
//      break;
//    }
//  }
//
  private static String decode(String paramString)
  {
//      String str = decode(paramString.toCharArray());
//      paramString = str;
      return paramString;
  }

//  private static String decode(char[] paramArrayOfChar)
//    throws Exception
//  {
//    int i = 0;
//    char[] arrayOfChar = new char[paramArrayOfChar.length];
//    int j = 0;
//    while (true)
//    {
//      if (i >= paramArrayOfChar.length);
//      int k;
//      int m;
//      int i2;
//      int i8;
//      int i10;
//      int i11;
//      int i12;
//      while (true)
//      {
//        return new String(arrayOfChar, 0, j);
//        k = i + 1;
//        m = paramArrayOfChar[i];
//        if (m != 92)
//          break label612;
//        if (paramArrayOfChar.length > k)
//        {
//          i = k + 1;
//          i2 = paramArrayOfChar[k];
//          if (i2 != 117)
//            break label481;
//          i8 = 0;
//          if (paramArrayOfChar.length <= i + 4)
//            break label457;
//          i10 = 1;
//          i11 = 0;
//          i12 = i;
//          if (i11 < 4)
//            break label135;
//          if (i10 == 0)
//            break label400;
//          int i20 = j + 1;
//          arrayOfChar[j] = ((char)i8);
//          j = i20;
//          i = i12;
//          break;
//        }
//        int i1 = j + 1;
//        arrayOfChar[j] = '\\';
//        j = i1;
//      }
//      label135: int i13 = i12 + 1;
//      int i14 = paramArrayOfChar[i12];
//      switch (i14)
//      {
//      default:
//        i10 = 0;
//      case 48:
//      case 49:
//      case 50:
//      case 51:
//      case 52:
//      case 53:
//      case 54:
//      case 55:
//      case 56:
//      case 57:
//      case 97:
//      case 98:
//      case 99:
//      case 100:
//      case 101:
//      case 102:
//      case 65:
//      case 66:
//      case 67:
//      case 68:
//      case 69:
//      case 70:
//      }
//      while (true)
//      {
//        i11++;
//        i12 = i13;
//        break;
//        i8 = -48 + (i14 + (i8 << 4));
//        continue;
//        i8 = -97 + (i14 + (10 + (i8 << 4)));
//        continue;
//        i8 = -65 + (i14 + (10 + (i8 << 4)));
//      }
//      label400: int i15 = i12 - 4;
//      int i16 = j + 1;
//      arrayOfChar[j] = '\\';
//      int i17 = i16 + 1;
//      arrayOfChar[i16] = 'u';
//      int i18 = i17 + 1;
//      int i19 = i15 + 1;
//      arrayOfChar[i17] = paramArrayOfChar[i15];
//      j = i18;
//      i = i19;
//      continue;
//      label457: int i9 = j + 1;
//      arrayOfChar[j] = '\\';
//      j = i9 + 1;
//      arrayOfChar[i9] = 'u';
//      continue;
//      switch (i2)
//      {
//      default:
//        int i7 = j + 1;
//        arrayOfChar[j] = '\\';
//        j = i7 + 1;
//        arrayOfChar[i7] = i2;
//        break;
//      case 116:
//        int i6 = j + 1;
//        arrayOfChar[j] = '\t';
//        j = i6;
//        break;
//      case 114:
//        int i5 = j + 1;
//        arrayOfChar[j] = '\r';
//        j = i5;
//        break;
//      case 110:
//        int i4 = j + 1;
//        arrayOfChar[j] = '\n';
//        j = i4;
//        break;
//      case 102:
//        label481: int i3 = j + 1;
//        arrayOfChar[j] = '\f';
//        j = i3;
//        continue;
//        label612: int n = j + 1;
//        arrayOfChar[j] = m;
//        j = n;
//        i = k;
//      }
//    }
//  }
//
//  public static Bitmap drawableToBitmap(Drawable paramDrawable)
//  {
//    int i = paramDrawable.getIntrinsicWidth();
//    int j = paramDrawable.getIntrinsicHeight();
//    if (paramDrawable.getOpacity() != -1);
//    for (Bitmap.Config localConfig = Bitmap.Config.ARGB_8888; ; localConfig = Bitmap.Config.RGB_565)
//    {
//      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
//      Canvas localCanvas = new Canvas(localBitmap);
//      paramDrawable.setBounds(0, 0, i, j);
//      paramDrawable.draw(localCanvas);
//      return localBitmap;
//    }
//  }
//
//  public static Bitmap getLoacalBitmap(String paramString)
//  {
//    try
//    {
//      Bitmap localBitmap2 = BitmapFactory.decodeStream(new FileInputStream(paramString));
//      localBitmap1 = localBitmap2;
//      return localBitmap1;
//    }
//    catch (FileNotFoundException localFileNotFoundException)
//    {
//      while (true)
//      {
//        localFileNotFoundException.printStackTrace();
//        Bitmap localBitmap1 = null;
//      }
//    }
//  }
//
//  public static SoundPool getSound()
//  {
//    return new SoundPool(10, 1, 5);
//  }
//
//  public static boolean haveSDCard(Context paramContext)
//  {
//    if (!Environment.getExternalStorageState().equals("mounted"));
//    for (boolean bool = false; ; bool = true)
//      return bool;
//  }
//
//  public static boolean isNum(String paramString)
//  {
//    return paramString.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
//  }
//
//  public static String newRandomUUID()
//  {
//    return UUID.randomUUID().toString().replaceAll("-", "");
//  }
//
//  public static int randomInt(int paramInt1, int paramInt2)
//  {
//    return (int)(paramInt1 + Math.random() * (1 + (paramInt2 - paramInt1)));
//  }
//
//  public static void setBold(TextView paramTextView)
//  {
//    paramTextView.getPaint().setFakeBoldText(true);
//  }
//
//  public static void setListViewHeightBasedOnChildren(ListView paramListView)
//  {
//    ListAdapter localListAdapter = paramListView.getAdapter();
//    if (localListAdapter == null)
//      return;
//    int i = 0;
//    for (int j = 0; ; j++)
//    {
//      if (j >= localListAdapter.getCount())
//      {
//        ViewGroup.LayoutParams localLayoutParams = paramListView.getLayoutParams();
//        localLayoutParams.height = (i + paramListView.getDividerHeight() * (-1 + localListAdapter.getCount()));
//        paramListView.setLayoutParams(localLayoutParams);
//        break;
//      }
//      View localView = localListAdapter.getView(j, null, paramListView);
//      localView.measure(0, 0);
//      i += localView.getMeasuredHeight();
//    }
//  }
//
//  public static String showTime(Date paramDate)
//  {
//    Object localObject;
//    if (paramDate == null)
//    {
//      localObject = "";
//      return localObject;
//    }
//    long l1 = Math.abs(System.currentTimeMillis() - paramDate.getTime());
//    String str;
//    if (l1 < 60000L)
//      str = l1 / 1000L + "秒钟前发布";
//    while (true)
//    {
//      localObject = str;
//      break;
//      if ((l1 >= 60000L) && (l1 < 3600000L))
//      {
//        str = l1 / 60000L + "分钟前发布";
//      }
//      else if ((l1 >= 3600000L) && (l1 < 86400000L))
//      {
//        str = l1 / 3600000L + "小时前发布";
//      }
//      else
//      {
//        long l2 = l1 / 86400000L;
//        if (l2 < 10L)
//          str = l2 + "天前发布";
//        else
//          str = new SimpleDateFormat("MM-dd HH:mm").format(paramDate);
//      }
//    }
//  }
//
//  public static Date stringToDate(String paramString)
//  {
//    try
//    {
//      localDate = new Date(paramString);
//      return localDate;
//    }
//    catch (Exception localException)
//    {
//      while (true)
//        Date localDate = new Date();
//    }
//  }
//}
}