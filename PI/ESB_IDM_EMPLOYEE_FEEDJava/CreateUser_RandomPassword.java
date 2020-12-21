import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;


public class CreateUser_RandomPassword extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		// MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;

		try {
			// create new message as a copy of the input
			MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			MbMessage localenv = outAssembly.getGlobalEnvironment();
			// ----------------------------------------------------------
			// Add user code below
			String random_password = "";
			
			final Random RANDOM = new SecureRandom();
			final int PASSWORD_LENGTH = 8;

			String allChars = "$%^*(abcdefghjkmnpqrstuvwxyz~!@ABCDEFGHJKMNPQRSTUVWXYZ23456789";
			String special_chars = "!#$%&;()*+,.:;<=>?@[]^_`{|}~";
			String letter = "abcdefghjkmnpqrstuvwxyz";
			String numbers = "0123456789";

			String pw_allChars = "";
			String pw_special_chars = "";
			String pw_letter = "";
			String pw_numbers = "";

			String pw = "";

			int allChars_index = (int) (RANDOM.nextDouble() * allChars.length());
			pw_allChars = allChars
					.substring(allChars_index, allChars_index + 1);

			int special_chars_index = (int) (RANDOM.nextDouble() * special_chars
					.length());
			pw_special_chars = pw_allChars
					+ special_chars.substring(special_chars_index,
							special_chars_index + 1);

			int letter_index = (int) (RANDOM.nextDouble() * letter.length());
			pw_letter = pw_special_chars
					+ letter.substring(letter_index, letter_index + 1);

			int numbers_index = (int) (RANDOM.nextDouble() * numbers.length());
			pw_numbers = pw_letter
					+ numbers.substring(numbers_index, numbers_index + 1);

			String letters = "$%^*(abcdefghjkmnpqrstuvwxyz~!@#)ABCDEFGHJKMNPQRSTUVWXYZ23456789";

			for (int i = 4; i < PASSWORD_LENGTH; i++) {

				int index = (int) (RANDOM.nextDouble() * letters.length());

				pw = pw + letters.substring(index, index + 1);

			}
			
			 random_password = pw_numbers + pw;
			
			/*String[] pwd_contains = { "coach", "handbag", "leather", "welcome",
					"password" };
			String[] personalInfo_contains = {};
			
			if (Arrays.asList(pwd_contains).contains(random_password)) {
				
				
			} else {*/
						
				localenv.getRootElement().createElementAsFirstChild(
						MbElement.TYPE_NAME_VALUE, "PCT_PASSWORD1",
						random_password);
			

			// End of user code
			// ----------------------------------------------------------
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be
			// handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}
		// The following should only be changed
		// if not propagating message to the 'out' terminal
		out.propagate(outAssembly);

	}
}
