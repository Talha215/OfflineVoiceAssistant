/**
 * @author Ian Zichko-Geithner
 *
 */
public interface commandInterface {
	public boolean match(String token);
	public String run(String[] command);

}
