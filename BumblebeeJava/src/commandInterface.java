/**
 * @author Ian Zichko-Geithner
 *
 */
public interface commandInterface {
    boolean match(String token);

    String run(String[] command);

}
