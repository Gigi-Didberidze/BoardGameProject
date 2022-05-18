package ColorCollection.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerModelTest {


    @Test
    void setPlayerOneName() {
        ResultModel resultModel = new ResultModel();
        assertEquals(resultModel.getPlayerOneName(),null);
        resultModel.setPlayerOneName("test");
        assertEquals(resultModel.getPlayerOneName(),"test");
    }


    @Test
    void setPlayerTwoName() {
        ResultModel resultModel = new ResultModel();
        assertEquals(resultModel.getPlayerTwoName(),null);
        resultModel.setPlayerTwoName("test");
        assertEquals(resultModel.getPlayerTwoName(),"test");
    }


}