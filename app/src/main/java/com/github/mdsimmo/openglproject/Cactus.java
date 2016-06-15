package com.github.mdsimmo.openglproject;

public class Cactus extends GameObject {

    public Cactus( Assets assets ) {
        super( new Texture( assets.open( "cactus.png" ) ) );
        size( 1f, 1f );
    }

    @Override
    public void update() {
        // cactus's do nothing
    }
}
