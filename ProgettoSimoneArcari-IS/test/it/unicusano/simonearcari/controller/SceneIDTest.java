package it.unicusano.simonearcari.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SceneIDTest {

    @Test
    public void testGetId() {
        // Testa che gli ID delle scene siano corretti
        assertEquals(1, SceneID.DASHBOARD.getId(), "ID di DASHBOARD dovrebbe essere 1");
        assertEquals(2, SceneID.REGISTRATION.getId(), "ID di REGISTRATION dovrebbe essere 2");
        assertEquals(3, SceneID.RENEWAL.getId(), "ID di RENEWAL dovrebbe essere 3");
        assertEquals(4, SceneID.UNSUBSCRIBE.getId(), "ID di UNSUBSCRIBE dovrebbe essere 4");
        assertEquals(5, SceneID.CALCULATE_FEE.getId(), "ID di CALCULATE_FEE dovrebbe essere 5");
        assertEquals(6, SceneID.PRINT_LISTS.getId(), "ID di PRINT_LISTS dovrebbe essere 6");
        assertEquals(7, SceneID.SELECT_ACTIVITY.getId(), "ID di SELECT_ACTIVITY dovrebbe essere 7");
        assertEquals(8, SceneID.SHOW_LIST.getId(), "ID di SHOW_LIST dovrebbe essere 8");
        assertEquals(9, SceneID.STATUS_REG_OK.getId(), "ID di STATUS_REG_OK dovrebbe essere 9");
        assertEquals(10, SceneID.STATUS_DIS_OK.getId(), "ID di STATUS_DIS_OK dovrebbe essere 10");
        assertEquals(11, SceneID.STATUS_ACQ_OK.getId(), "ID di STATUS_ACQ_OK dovrebbe essere 11");
        assertEquals(12, SceneID.STATUS_REG_ERROR.getId(), "ID di STATUS_REG_ERROR dovrebbe essere 12");
        assertEquals(13, SceneID.STATUS_DIS_ERROR.getId(), "ID di STATUS_DIS_ERROR dovrebbe essere 13");
        assertEquals(14, SceneID.STATUS_RIN_ERROR.getId(), "ID di STATUS_RIN_ERROR dovrebbe essere 14");
        assertEquals(15, SceneID.STATUS_MAT_WARNING.getId(), "ID di STATUS_MAT_WARNING dovrebbe essere 15");
    }
}
