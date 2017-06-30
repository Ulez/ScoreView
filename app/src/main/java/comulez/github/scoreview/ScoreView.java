package comulez.github.scoreview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ulez on 2017/6/30.
 * Email：lcy1532110757@gmail.com
 */


public class ScoreView extends LinearLayout implements Level {
    private Context mContext;
    private ImageView scoreClip;
    private TextView tvScore;
    private float maxScore = 5.0f;
    private float textSize;//單位sp
    private int textColor;
    private int resourceId;

    public ScoreView(Context context) {
        this(context, null);
    }

    public ScoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setHorizontalGravity(HORIZONTAL);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScoreView);
        maxScore = typedArray.getFloat(R.styleable.ScoreView_max_score, 5.0f);
        textColor = typedArray.getColor(R.styleable.ScoreView_text_color, Color.BLACK);
        textSize = typedArray.getFloat(R.styleable.ScoreView_text_size, 14);
        resourceId = typedArray.getResourceId(R.styleable.ScoreView_src_drawable, R.drawable.clip_drawable2);
        typedArray.recycle();

        LinearLayout scoreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.score_view, null);
        scoreClip = (ImageView) scoreView.findViewById(R.id.score_clip);
        tvScore = (TextView) scoreView.findViewById(R.id.tv_score);
        scoreClip.setImageResource(resourceId);
        tvScore.setTextSize(textSize);
        tvScore.setTextColor(textColor);
        addView(scoreView);
//        scoreClip = new ImageView(context);
//        tvScore = new TextView(context);
//        scoreClip.setImageResource(resourceId);
//        tvScore.setTextSize(textSize);
//        tvScore.setTextColor(textColor);
//        LayoutParams lpTV = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        LayoutParams lpIV = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        addView(scoreClip, lpIV);
//        addView(tvScore, lpTV);
    }

    @Override
    public void setPercent(float percent) {
        percent = percent > 1.0f ? 1.0f : percent;
        percent = percent < 0.0f ? 0.0f : percent;
        String result = String.format("%.1f", maxScore * percent);
        tvScore.setText(result);
        scoreClip.getDrawable().setLevel((int) (percent * 10000));
    }
}
