package com.github.mdsimmo.openglproject;

import java.util.Random;

public class Rand extends Random {

    public Rand() {
        super();
    }

    public Rand( long seed ) {
        super( seed );
    }

    public float nextFloat( float min, float max ) {
        return nextFloat() * (max - min) + min;
    }

    public float nextInt( int min, int max ) {
        return nextInt( max - min ) + min;
    }

    public float nextFloat( float max ) {
        return nextFloat() * max;
    }
}
