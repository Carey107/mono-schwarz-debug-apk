package de.monoschwarz.raster;

import android.inputmethodservice.InputMethodService;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.view.inputmethod.InputConnection;
import android.widget.*;
import java.util.Locale;

/** German QWERTZ IME. All typed content remains in the target app's input connection. */
public class MonoKeyboardService extends InputMethodService {
    private LinearLayout container;
    private String layer="ABC";
    private boolean shift=false;
    private int dp(int n){return (int)(n*getResources().getDisplayMetrics().density+.5f);}
    @Override public View onCreateInputView(){container=new LinearLayout(this);container.setOrientation(1);container.setPadding(dp(3),dp(5),dp(3),dp(5));container.setBackgroundColor(0xff151719);draw();return container;}
    private void draw(){container.removeAllViews();if(layer.equals("ABC")){row("Q","W","E","R","T","Z","U","I","O","P");row("A","S","D","F","G","H","J","K","L","Ä");row("⇧","Y","X","C","V","B","N","M","Ö","Ü");}else if(layer.equals("NUM")){row("1","2","3","4","5","6","7","8","9","0");row("@","#","€","%","&","-","+","(",")");}else{row("!","?","/","\\","=","*","_",":",";");row("[","]","{","}","<",">","~","^");}row("ALT","ß",",","☺","SPACE",".","⌫","↵");}
    private void row(String... keys){LinearLayout line=new LinearLayout(this);line.setOrientation(0);container.addView(line,new LinearLayout.LayoutParams(-1,dp(52)));for(String s:keys){Button b=new Button(this);b.setAllCaps(false);b.setText(s);b.setTextSize(s.equals("SPACE")?10:15);b.setTextColor(Color.WHITE);b.setPadding(0,0,0,0);b.setMinWidth(0);b.setMinimumWidth(0);GradientDrawable d=new GradientDrawable();d.setColor(0xff34383e);d.setCornerRadius(dp(5));b.setBackground(d);LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,-1,s.equals("SPACE")?2.8f:1f);p.setMargins(dp(2),dp(2),dp(2),dp(2));line.addView(b,p);b.setOnClickListener(v->press(s));}}
    private void press(String s){InputConnection ic=getCurrentInputConnection();if(ic==null)return;switch(s){case "ALT":layer=layer.equals("ABC")?"NUM":layer.equals("NUM")?"SYM":"ABC";draw();return;case "⇧":shift=!shift;return;case "⌫":ic.deleteSurroundingText(1,0);return;case "↵":ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_ENTER));ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP,KeyEvent.KEYCODE_ENTER));return;case "SPACE":ic.commitText(" ",1);return;case "☺":ic.commitText("😀",1);return;default:ic.commitText(shift?s:s.toLowerCase(Locale.GERMAN),1);shift=false;}}
}