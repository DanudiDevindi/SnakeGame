package com.bolton.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Ellipse2D.Double;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.bolton.view.Snake;

class SnakeTest {
	@Test
    public void aSnakeIs3UnitsLongByDefault() {
		Snake snake = new Snake() ;
       List<Double> length = snake.getSnakeParts();
        assertEquals(3, length);
    }

    @Test
    public void SnakecanHeadUp() {
        Snake snake = new Snake();
        snake.headUp();
        String direction = snake.getCurrentDirection();
        assertEquals("U", direction);
    }

    @Test
    public void SnakecanHeadDown() {
        Snake snake = new Snake();
        snake.headDown();
        String direction = snake.getCurrentDirection();
        assertEquals("D", direction);
    }

    @Test
    public void SnakecanHeadRight() {
        Snake snake = new Snake();
        snake.state = "ULLL";
        snake.headRight();
        String direction = snake.getCurrentDirection();
        assertEquals("R", direction);
    }
    @Test
    public void BeginningSnakeBodyIsExtended() {
        Snake snake = new Snake();
        assertEquals("LRRR", snake.state);
    }

    @Test
    public void SnakecannotHeadBackwards() {
        Snake snake = new Snake();
        snake.state = "RLLL";
        snake.headLeft();
        assertEquals("RLLL", snake.state);
        snake.state = "ggg";
        snake.headRight();
        assertEquals("ggg", snake.state);
        snake.state = "UDDD";
        snake.headDown();
        assertEquals("UDDD", snake.state);
        snake.state = "DUUU";
        snake.headDown();
        assertEquals("DUUU", snake.state);
    }
	
}
