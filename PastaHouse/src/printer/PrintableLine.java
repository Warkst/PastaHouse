/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printer;

import java.awt.Graphics;

/**
 *
 * @author Warkst
 */
public class PrintableLine implements PrintableObject{

    private final int x1, y1, x2, y2;
    
    public PrintableLine(int x1, int y1, int x2, int y2){
	this.x1=x1;
	this.y1=y1;
	this.x2=x2;
	this.y2=y2;
    }
    
    @Override
    public void print(Graphics g) {
	g.drawLine(x1, y1, x2, y2);
    }
}
