import java.awt.*;

public class Ball {

    public int x, y;
    private final int DIAMETER = 25, SPEED =5;

    double dx = SPEED, dy = SPEED;

    Board board;

    public Ball(Board board){
        x = 0;
        y = 0;



        this.board = board;
    }

    public void move(){

        //left and right
        if(x <= 0){
            dx*=-1;
            board.setcScore(board.getcScore()+1);
        }
        if(x >= (board.getWidth() - DIAMETER)){
            dx*=-1;
            board.setpScore(board.getpScore()+1);
        }
        if(y <= 0 || y >= (board.getHeight() - DIAMETER)){
            dy*=-1;
        }

        x+=dx;
        y+=dy;
    }

    public void setPosition(int x, int y){

        this.x = x - DIAMETER/2;
        this.y = y - DIAMETER/2;

    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

    double MAXANGLE = 5*Math.PI/12;

    public void checkCollisions(Paddle other) {
        if (getBounds().intersects(other.getBounds())) {
            if(x < board.getWidth()/2){
                dx*=-1;
            }
            if(x > board.getWidth()/2){
                dx*=-1;
            }

        }
    }

    public void paint(Graphics g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }

    public int getY() {
        return y;
    }

    public int getDIAMETER() {
        return DIAMETER;
    }

    public int getX() {
        return x;
    }
}
