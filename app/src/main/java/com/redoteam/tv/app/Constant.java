package com.redoteam.tv.app;

public interface Constant
{
/**------------------------intent constant------------------------------**/
    String KEY_STRING_1 = "KEY_STRING_1";
    String KEY_STRING_2 = "KEY_STRING_2";
    String KEY_INT_1 = "KEY_INT_1";
    String KEY_BEAN = "KEY_BEAN";
    String KEY_BEAN_2 = "KEY_BEAN_2";
/**------------------------intent end-----------------------------------**/
/**---------------------------------------------------------------------**/
/**------------------------web constant---------------------------------**/
    //设置WebView图片的宽度
    String HTML_START_WITH_CLICK = "<html><head><style type=\"text/css\"> img{width:100%;height:auto} body{line-height:1.7;color:#585858}</style> <script type=\"text/javascript\"> "
            + "function imageOnclick(){ "
            + "var objs = document.getElementsByTagName(\"img\");"
            + " var array=new Array(); "
            + " for(var j=0;j<objs.length;j++){ "
            + "array[j]=objs[j].src;"
            + " }  "
            + "for(var i=0;i<objs.length;i++){"
            + "objs[i].i=i;"
            + "objs[i].onclick=function(){  window.imagelistener.openImage(this.src,array,this.i);"
            + "}  " +
            "" + "}" + "}"
            + "window.onload =  function(){ imageOnclick();  }"
            + "</script> </head><body>";
    String HTML_END = "</body></html>";
/**------------------------web end------------------------------------**/

}
