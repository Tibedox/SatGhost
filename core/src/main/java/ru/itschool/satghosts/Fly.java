package ru.itschool.satghosts;

import static ru.itschool.satghosts.Main.SCR_HEIGHT;
import static ru.itschool.satghosts.Main.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;

public class Fly extends Ghost{

    public Fly() {
        width = MathUtils.random(20, 50);
        height = width*0.814f;
        x = MathUtils.random(0, SCR_WIDTH-width);
        y = MathUtils.random(0, SCR_HEIGHT-height);
        vx = MathUtils.random(-15f, 15f);
        vy = MathUtils.random(-15f, 15f);
    }
}
