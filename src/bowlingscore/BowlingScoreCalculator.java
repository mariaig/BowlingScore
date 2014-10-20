package bowlingscore;

/**
 *
 * @author Maria
 */
public interface BowlingScoreCalculator {

  int computeScoreFor(int[] rolls) throws InvalidNumberOfRolls;

}
