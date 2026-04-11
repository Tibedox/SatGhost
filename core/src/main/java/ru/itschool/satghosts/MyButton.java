package ru.itschool.satghosts;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector3;


public class MyButton {
    float x, y;
    float width, height;
    BitmapFont font;
    String text;

    public MyButton(float x, float y, BitmapFont font, String text) {
        this.x = x;
        this.y = y;
        this.font = font;
        this.text = text;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        height = layout.height;
    }

    boolean hit(Vector3 t){
        return t.x>x && t.x<x+width && t.y<y && t.y>y-height;
    }
}
