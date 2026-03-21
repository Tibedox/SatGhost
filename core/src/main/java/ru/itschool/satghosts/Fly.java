package ru.itschool.satghosts;

import static ru.itschool.satghosts.Main.SCR_HEIGHT;
import static ru.itschool.satghosts.Main.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Fly {
    float x, y;
    float width, height;
    float vx, vy;

    public Fly() {
        width = MathUtils.random(20, 50);
        height = width*0.814f;
        x = MathUtils.random(0, SCR_WIDTH-width);
        y = MathUtils.random(0, SCR_HEIGHT-height);
        vx = MathUtils.random(-5f, 5f);
        vy = MathUtils.random(-5f, 5f);
    }

    void move() {
        x += vx;
        y += vy;

        if(x<0 || x>SCR_WIDTH-width){
            vx = -vx;
        }
        if(y<0 || y>SCR_HEIGHT-height){
            vy = -vy;
        }
    }
}
