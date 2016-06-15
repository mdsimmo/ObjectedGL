package com.github.mdsimmo.openglproject;

import android.opengl.GLES10;

public class Sprite {

    private Rectangle vertBuilder;
    private Vertices vertices;
    private Texture texture;
    private float x, y;

    public Sprite( Texture texture ) {
        this.texture = texture;
        vertBuilder = new Rectangle();
        vertices = vertBuilder.create();
    }

    public Sprite texture( Texture texture ) {
        this.texture = texture;
        return this;
    }

    public Sprite position( float x, float y ) {
        this.x = x;
        this.y = y;
        return this;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
    }

    public Sprite size( float width, float height ) {
        vertBuilder.size( width, height ).apply( vertices );
        return this;
    }

    public Sprite origin( float x, float y ) {
        vertBuilder.origin( x, y ).apply( vertices );
        return this;
    }

    public void draw() {
        // position the sprite
        GLES10.glMatrixMode( GLES10.GL_MODELVIEW );
        GLES10.glLoadIdentity();
        GLES10.glTranslatef( x, y, 0 );
        // note, we could easily add rotation and scaling in here too

        // draw the sprite
        texture.bind();
        vertices.draw( GLES10.GL_TRIANGLES );
    }

}
