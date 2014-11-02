/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intel
 */
public class Chip {
    private int x;
    private int y;
    private int IC;
    
    public Chip(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    protected void move(int direction){
        if(direction == 2){
            this.y = this.y + 1;
        } else if (direction == 4) {
            this.x = this.x - 1;
        } else if (direction == 6) {
            this.x = this.x + 1;
        } else if (direction == 8) {
            this.y = this.y - 1;
        }
    }
    
}
