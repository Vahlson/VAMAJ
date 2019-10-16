import junit.framework.TestCase;
import main.java.model.ModelFacade;
import main.java.viewcontroller.PrimaryController;
import org.junit.Test;

public class InstallationControllerTest extends TestCase {

    @Test
    public void testDataFlow() {

        // Mock Controller
        PrimaryController pc = PrimaryController.getInstance();

        // Mock Model Facade
        ModelFacade modelFacade = pc.getModelFacade();

        // Setting the data
        // modelFacade.setPropertyConsumption(10);
        // modelFacade.setContractCost(100);

        // assertEquals(modelFacade.getProperty().getConsumption(), 10.0);
        // assertEquals(modelFacade.getContract().getCost(), 100);
    }
}
