package com.github.mdsimmo.openglproject;

public class Garry extends GameObject {

    private float speed = 0.1f;
    private World world;

    public Garry( Assets assets, World world ) {
        super( new Texture( assets.open( "garry.png" ) ) );
        this.world = world;
        position( 1, 0 );
        size( 2f, 2f );
    }

    @Override
    public void update() {
        // bounce of the walls
        if ( x() < 0 )
            speed = Math.abs( speed );
        if ( x() > world.width() )
            speed = -Math.abs( speed );
        position( x() + speed, y() );
    }
}
