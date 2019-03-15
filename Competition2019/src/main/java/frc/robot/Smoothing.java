package frc.robot;

/**
 * A smoothing class.
 */

public class Smoothing {
	private double s_rampVup;
	private double s_rampVdown;
	private double s_maxAup;
	private double s_maxAdown;
	private double s_currentPosition;
	private double s_currentVelocity;
	private double c_quickestStop;
	private double c_velocityIdeal;

	public Smoothing (double rampVup, double rampVdown, double maxAup, double maxAdown, double startingPosition, double startingVelocity) {
		s_rampVup = rampVup;
		s_rampVdown = rampVdown;
		s_maxAup = maxAup;
		s_maxAdown = maxAdown;
		s_currentPosition = startingPosition;
		s_currentVelocity = startingVelocity;
	}

	public double compute (double desired) {
		if(s_currentVelocity > 0) {
			c_quickestStop = (Math.pow(s_currentVelocity, 2) / 2 / s_maxAdown + s_currentPosition);
			if(desired < c_quickestStop || desired < s_currentPosition) {
				s_currentVelocity -= s_maxAdown; 
			} 
			else
			{
				// Calculate ideal velocity to 'perfectly' stop
                c_velocityIdeal = Math.sqrt(2 * s_maxAdown * (desired - s_currentPosition));
                
                // Avoid overshoot, so speed up to where it is safe
                s_currentVelocity = Math.min(c_velocityIdeal, s_currentVelocity + s_maxAup);
			}
		}
		else if (s_currentVelocity < 0) {
			c_quickestStop = -Math.pow(s_currentVelocity, 2) / 2 / s_maxAup + s_currentPosition;
            
            if (desired > c_quickestStop || desired > s_currentPosition)
                s_currentVelocity += s_maxAup;
            
            else {
                // Calculate ideal velocity to 'perfectly' stop
                c_velocityIdeal = -Math.sqrt(2 * s_maxAup * (s_currentPosition - desired)); // a neg number
                
                // Avoid overshoot, so speed up to where it is safe
				s_currentVelocity = Math.max(c_velocityIdeal, s_currentVelocity - s_maxAdown);
			}
		} 
		else {
			// currentVelocity is zero. So let's calculate what we should do
            if (desired > s_currentPosition) {
                // Calculate ideal velocity to 'perfectly' stop
                c_velocityIdeal = Math.sqrt(2 * s_maxAdown * (desired - s_currentPosition));
                
                // Avoid overshoot, so speed up to where it is safe
				s_currentVelocity = Math.min(c_velocityIdeal, s_currentVelocity + s_maxAup);
			}
            else if (desired < s_currentPosition) {
                // Calculate ideal velocity to 'perfectly' stop
                c_velocityIdeal = -Math.sqrt(2 * s_maxAup * (s_currentPosition - desired)); // # a neg number
                
                // Avoid overshoot, so speed up to where it is safe
				s_currentVelocity = Math.max(c_velocityIdeal, s_currentVelocity - s_maxAdown);
			}
		}

		s_currentVelocity = Math.min(s_currentVelocity, s_rampVup);
        s_currentVelocity = Math.max(s_currentVelocity, -s_rampVdown);
        
        s_currentPosition += s_currentVelocity;
        
        return s_currentPosition;
	}
}