package zouain;
import robocode.*;
import java.awt.Color;


public class Dhampir extends Robot
{
	
	public void run() {
		// Initialization

		setColors(Color.black,new Color(147,112,219),Color.red);	

		// Robot main loop
		while(true) {
			// vira a mira procurando inimigos
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// get distancia entre robo e inimigo
		double dist = e.getDistance();
		// get angulo do inimigo relativo ao robo (0 = se encarando)
		double bear = e.getBearing();
		// get angulo do radar do robo 
		double rad = getRadarHeading();
		// get angulo do robo
		double head = getHeading();
		
		// ataca se tiver perto
		if (dist <= 200){
			fire(4);
		}
		// corre atrás se tiver longe
		else {
			fire(2);
			turnRight(bear);
			ahead(100);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// tomou ataque, manobras evasivas
		double dir = e.getHeading(); 		

		turnRight(90);
		ahead (50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		double dir = e.getBearing();
		turnRight(-dir);
	}	
}
