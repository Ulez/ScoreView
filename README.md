# ScoreView
利用ClipDrawable显示评分的view.同样类似的可以用在动态显示麦克风音量，只需要修改背景前景图,clipOrientation和gravity。

<img src="https://github.com/Ulez/ScoreView/blob/master/screenshots/a.png" width = "300" height = "507.6" align=center />
<img src="https://github.com/Ulez/ScoreView/blob/master/screenshots/b.png" width = "300" height = "507.6" align=center />

[Blog博客](http://blog.csdn.net/s122ktyt/article/details/74010904) 

Usage:
```xml
    <comulez.github.scoreview.ScoreView
        android:id="@+id/sv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/test_clip"
        app:max_score="5"
        app:src_drawable="@drawable/clip_drawable3"
        app:text_color="@color/colorAccent"
        app:text_size="12" />
```
