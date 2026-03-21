package ru.itschool.satghosts;

import static ru.itschool.satghosts.Main.*;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class Ghost {
    float x, y;
    float width, height;
    float vx, vy;
    boolean show = true;

    public Ghost() {
        width = MathUtils.random(50, 150);
        height = width*1.756f;
        //x = MathUtils.random(0, SCR_WIDTH-width);
        //y = MathUtils.random(0, SCR_HEIGHT-height);
        x = 514;
        y = 224;
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

    boolean hit(Vector3 t){
        return t.x>x && t.x<x+width && t.y>y && t.y<y+height;
    }
}
