package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimation {
    Texture redcapImg;
    Animation<TextureRegion> anm;
    private float time;
    public MyAnimation(String name, int row, int col, float fps, Animation.PlayMode playMode) {

        time = 0;
        redcapImg = new Texture(name);
        TextureRegion reg1 = new TextureRegion(redcapImg);
        TextureRegion[][] regions = reg1.split(redcapImg.getWidth()/col, redcapImg.getHeight()/row);
        anm = new Animation<>(1/fps,regions[0]);
        anm.setPlayMode(playMode);
    }

    public TextureRegion draw() {return anm.getKeyFrame(time);
    }
    public void setTime(float dT){
        time+= dT;
    }

    public void dispose(){
        this.redcapImg.dispose();
    }
}
