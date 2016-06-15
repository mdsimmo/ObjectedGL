package com.github.mdsimmo.openglproject;

import android.content.SyncAdapterType;

/**
 * A thing that is in the world
 */
public abstract class GameObject {

    private final Sprite sprite;

    public GameObject( Texture texture ) {
        this.sprite = new Sprite( texture );
    }

    public GameObject size( float width, float height ) {
        sprite.size( width, height );
        return this;
    }

    public GameObject position( float x, float y ) {
        sprite.position( x, y );
        return this;
    }

    public float x() {
        return sprite.x();
    }

    public float y() {
        return sprite.y();
    }

    // Some subclasses may not want to be re-textured, thus, protected access
    protected GameObject texture( Texture texture ) {
        sprite.texture( texture );
        return this;
    }

    public void draw() {
        sprite.draw();
    }

    public abstract void update();

}
