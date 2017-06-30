package comulez.github.scoreview;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView testClip;
    //    private ImageView scoreClip;
    private int level = 0;
    private ScoreView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(android.R.id.progress);
        testClip = (ImageView) findViewById(R.id.test_clip);
//        scoreClip = (ImageView) findViewById(R.id.score_clip);
        scoreView = (ScoreView) findViewById(R.id.sv);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                level += 300;
                setLevel(level);
                imageView.invalidate();
            }
        });
    }

    public void setLevel(int level) {
        Drawable drawable = imageView.getDrawable();
        drawable.setLevel(level);


        ClipDrawable drawable2 = (ClipDrawable) testClip.getDrawable();
        drawable2.setLevel(level);

        scoreView.setPercent(1.0f * level / 10000);
    }
}
