package Forum.AcceptanceTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * The main test class that will run all the tests, once the suite() method will run
 */
public class MainTesting {

	/**
	 * The main method that will run the tests
         * @return
         * @throws FileNotFoundException
         * @throws IOException
	 */
	public static Test suite() throws FileNotFoundException, IOException{
            // making new file with forum minimal info.
            TestSuite suite= new TestSuite("Forum tests");
//            StringBuilder resultPass = new StringBuilder();
//            resultPass.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" );
//            resultPass.append("<forumType>\n" );
//            resultPass.append( "    <forumName>Tapuach</forumName>\n" );
//            resultPass.append("    <messageCounter>1</messageCounter>\n" );
//            resultPass.append("</forumType>\n" );
//           StringBuffer fileName = new StringBuffer();
//           fileName.append("useCase.xml");
//            File f = new File (fileName.toString());
//            FileOutputStream fop = null;
//            fop = new FileOutputStream(f);
//            if (f.exists()) {
//                fop.write(resultPass.toString().getBytes());
//                fop.flush();
//                fop.close();
//            }

            ForumBridge tBridge= null;
			tBridge =  new ProxyBridge(new RealBridge());

		//setting the library bridge to be the created above bridge 
		TestProject.setbridge(tBridge);
		//adding the "donate item test" class to the test suit
		suite.addTest( new TestSuite(UseCasesRegisterTest.class));
		suite.addTest( new TestSuite(UseCasesAddMessageTest.class));
                suite.addTest( new TestSuite(UseCasesReplyToMessageTest.class));
                return suite;
		}
}
