package myapp.com.app201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView res;
    Animation animation;

    ImageView pos1,pos2,pos3,ball,ball2;
    TextView textView;
    Button again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thamchieu();

        textView.animate().x(pos2.getX()).y(pos2.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                textView.setX(pos2.getX());
                textView.setY(pos2.getY());
            }
        }).start();

        ball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                ball.setClickable(false);
                Random random = new Random();
                int sut= random.ints(1, 4).findFirst().getAsInt();
                int bat= random.ints(1, 4).findFirst().getAsInt();

                if(sut==1)
                {
                    sut1();
                }
                else if(sut==2)
                {
                    sut2();
                }
                else
                {
                    sut3();
                }

                if(bat==1)
                {
                    bat1();
                }
                else if(bat==2)
                {
                    bat2();
                }
                else
                {
                    bat3();
                }

                if(bat==sut)
                {
                    res.setText("SAVE!");
                }
                else
                    res.setText("GOALLL!");

                res.setVisibility(View.VISIBLE);
            }
        });

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ball.setClickable(true);
                pos2.animate().x(textView.getX()).y(textView.getY()).setDuration(20).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        pos2.setX(textView.getX());
                        pos2.setY(textView.getY());
                    }
                }).start();

                ball.animate().x(ball2.getX()).y(ball2.getY()).setDuration(20).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        ball.setX(ball2.getX());
                        ball.setY(ball2.getY());
                    }
                }).start();

                res.setText("");

            }
        });



    }

    private void bat1() {
        pos2.animate().x(pos1.getX()).y(pos1.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                pos2.setX(pos1.getX());
                pos2.setY(pos1.getY());
            }
        }).start();
    }

    private void bat2() {
        pos2.animate().x(textView.getX()).y(textView.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                pos2.setX(textView.getX());
                pos2.setY(textView.getY());
            }
        }).start();



    }

    private void bat3() {
        pos2.animate().x(pos3.getX()).y(pos3.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                pos2.setX(pos3.getX());
                pos2.setY(pos3.getY());
            }
        }).start();
    }

    private void sut1() {
        ball.animate().x(pos1.getX()).y(pos1.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                ball.setX(pos1.getX());
                ball.setY(pos1.getY());
            }
        }).start();
    }

    private void sut2() {
        ball.animate().x(textView.getX()).y(textView.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                ball.setX(textView.getX());
                ball.setY(textView.getY());
            }
        }).start();
    }

    private void sut3() {
        ball.animate().x(pos3.getX()).y(pos3.getY()).setDuration(1100).withEndAction(new Runnable() {
            @Override
            public void run() {
                ball.setX(pos3.getX());
                ball.setY(pos3.getY());
            }
        }).start();
    }


    private void thamchieu() {
        res=findViewById(R.id.res);

        animation= AnimationUtils.loadAnimation(this,R.anim.blink);
        res.startAnimation(animation);

        pos1=findViewById(R.id.pos1);
        pos2=findViewById(R.id.pos2);
        pos3=findViewById(R.id.pos3);

        ball=findViewById(R.id.ball);
        ball2=findViewById(R.id.ball2);
        again=findViewById(R.id.btnaga);
        res.setVisibility(View.INVISIBLE);

        textView=findViewById(R.id.textView2);
    }
}